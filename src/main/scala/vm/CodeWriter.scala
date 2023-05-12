package vm

import vm.CommandType.CommandType

import java.io.{File, PrintWriter}
import scala.collection.mutable
import com.typesafe.scalalogging.Logger

import vm.SegmentTypes._

class CodeWriter(outputPath: String) {

  private var labelCount = 0;

  def createUniqueLabel(): String = {
    val label = s"__TranslatorLabel$labelCount"
    labelCount += 1;
    label
  }

  private var currentFile: Option[String] = None

  val logger: Logger = Logger("codewriter")
  logger.info(s"initiated code writer, writing to $outputPath")

  val writer = new PrintWriter(new File(outputPath))
  writer.println("// generated with nand2tetris vm -> asm translator")

  //prepare stuff
  writer.println(
    """|@256
       |D=A
       |@0
       |M=D""".stripMargin)


  def setFileName(filename: String): Unit = {
    logger.info(s"file set to $filename")
    currentFile = Some(filename)
  }

  def writeArithmetic(command: String): Unit = {
    ArithmeticType.withName(command.toUpperCase()) match {
      case vm.ArithmeticType.ADD => {
        writer.println(
          """|@SP
             |A=M-1
             |D=M
             |A=A-1
             |M=D+M
             |D=A
             |@SP
             |M=D+1""".stripMargin)
      }
      case vm.ArithmeticType.SUB => {
        writer.println(
          """|@SP
             |A=M-1
             |D=M
             |A=A-1
             |M=M-D
             |D=A
             |@SP
             |M=D+1""".stripMargin)
      }
      case vm.ArithmeticType.NEG => {
        writer.println(
          """|@SP
             |A=M-1
             |M=-M""".stripMargin)
      }
      case vm.ArithmeticType.EQ => {
        val label = createUniqueLabel();

        writer.println(
          s"""|@SP
              |A=M-1
              |D=M
              |A=A-1
              |D=D-M
              |M=-1
              |@$label
              |D;JEQ
              |@SP
              |A=M-1
              |A=A-1
              |M=0
              |($label)
              |@SP
              |M=M-1""".stripMargin)
      }
      case vm.ArithmeticType.GT => {
        val label = createUniqueLabel();

        writer.println(
          s"""|@SP
              |A=M-1
              |D=M
              |A=A-1
              |D=D-M
              |M=0
              |@$label
              |D;JGE
              |@SP
              |A=M-1
              |A=A-1
              |M=-1
              |($label)
              |@SP
              |M=M-1""".stripMargin)
      }
      case vm.ArithmeticType.LT => {
        val label = createUniqueLabel();

        writer.println(
          s"""|@SP
              |A=M-1
              |D=M
              |A=A-1
              |D=D-M
              |M=0
              |@$label
              |D;JLE
              |@SP
              |A=M-1
              |A=A-1
              |M=-1
              |($label)
              |@SP
              |M=M-1""".stripMargin)
      }
      case vm.ArithmeticType.AND => {
        writer.println(
          """|@SP
             |A=M-1
             |D=M
             |A=A-1
             |M=D&M
             |D=A
             |@SP
             |M=D+1""".stripMargin)
      }
      case vm.ArithmeticType.OR => {
        writer.println(
          """|@SP
             |A=M-1
             |D=M
             |A=A-1
             |M=D|M
             |D=A
             |@SP
             |M=D+1""".stripMargin)
      }
      case vm.ArithmeticType.NOT => {
        writer.println(
          """|@SP
             |A=M-1
             |M=!M""".stripMargin)
      }
    }
  }


  /*
  local done
  argument done
  this done
  that done
  constant done
  static done
  pointer
  temp done


   */

  def writePush(segmentType: SegmentType, arg2: Int): Unit = {
    segmentType match {
      case CONSTANT => {
        writer.println(
          s"""|@${arg2}
              |D=A
              |@SP
              |M=M+1
              |A=M-1
              |M=D""".stripMargin
        )

      }
      case _ if List(LOCAL, ARGUMENT, THIS, THAT).contains(segmentType) => {
        val memoryOffset = arg2
        writer.println(
          s"""|@${segmentType.asmShorthand.get}
              |D=M
              |@${memoryOffset}
              |A=D+A
              |D=M
              |@SP
              |M=M+1
              |A=M-1
              |M=D""".stripMargin
        )
      }

      case STATIC => {
        writer.println(
          s"""|@${currentFile.get}.${arg2}
              |D=M
              |@SP
              |M=M+1
              |A=M-1
              |M=D""".stripMargin
        )
      }
      case TEMP => {
        writer.println(
          s"""|@${arg2 + 5}
              |D=M
              |@SP
              |M=M+1
              |A=M-1
              |M=D""".stripMargin
        )
      }
    }
  }

  def writePop(segmentType: SegmentType, arg2: Int): Unit = {
    segmentType match {
      case _ if List(LOCAL, ARGUMENT, THIS, THAT).contains(segmentType) => {
        val memoryOffset = arg2
        writer.println(
          s"""|@${segmentType.asmShorthand.get}
              |D=M
              |@${memoryOffset}
              |D=D+A
              |@14
              |M=D
              |@SP
              |M=M-1
              |A=M
              |D=M
              |@14
              |A=M
              |M=D""".stripMargin
        )
      }
      case STATIC => {
        writer.println(
          s"""|@SP
              |M=M-1
              |A=M
              |D=M
              |@${currentFile.get}.${arg2}
              |M=D""".stripMargin
        )
      }
      case TEMP => {
        writer.println(
          s"""|@SP
              |M=M-1
              |A=M
              |D=M
              |@${arg2+5}
              |M=D""".stripMargin
        )
      }
    }
  }

  def writeProgramEndLoop() = {
    writer.println(
      """|(INFINITE_LOOP)
         |@INFINITE_LOOP
         |0;JMP""".stripMargin)


  }

  def close(): Unit = {
    writer.close()
  }

}

object CodeWriter {
  def apply(outputPath: String): CodeWriter = new CodeWriter(outputPath)
}




