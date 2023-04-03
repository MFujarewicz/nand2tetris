package vm

import vm.CommandType.CommandType

import java.io.{File, PrintWriter}
import scala.collection.mutable
import com.typesafe.scalalogging.Logger
import vm.SegmentType.{CONSTANT, SegmentType}

class CodeWriter(outputPath: String) {

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
      case vm.ArithmeticType.SUB => ???
      case vm.ArithmeticType.NEG => ???
      case vm.ArithmeticType.EQ => ???
      case vm.ArithmeticType.GT => ???
      case vm.ArithmeticType.LT => ???
      case vm.ArithmeticType.AND => ???
      case vm.ArithmeticType.OR => ???
      case vm.ArithmeticType.NOT => ???
    }
  }

  //  def writePushPop(command: CommandType, segment: SegmentType, index: Int): Unit = {
  //
  //  }

  def writePush(segmentType: SegmentType, arg2: Int): Unit = {
    segmentType match {
      case CONSTANT => {
        writer.println(s"@$arg2")
        writer.println(s"D=A")
        writer.println(s"@SP")
        writer.println(s"A=M")
        writer.println(s"M=D")
        writer.println(s"@SP")
        writer.println(s"M=M+1")
      }
    }
  }

  def writePop(segmentType: SegmentType, arg2: Int): Unit = {
    ???
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




