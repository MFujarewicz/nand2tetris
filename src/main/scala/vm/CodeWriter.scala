package vm

import vm.CommandType.CommandType

import java.io.{File, PrintWriter}
import scala.collection.mutable
import com.typesafe.scalalogging.Logger
class CodeWriter(outputPath: String) {
  private var currentFile: Option[String] = None

  val logger: Logger = Logger("codewriter")
  logger.info(s"initiated code writer, writing to $outputPath")

  val writer = new PrintWriter(new File(outputPath))
  writer.print("// generated with nand2tetris vm -> asm translator")
  writer.flush()

  def setFileName(filename: String): Unit = {
    currentFile = Some(filename)
  }

  def writeArithmetic(command: String): Unit = {

  }

  def writePushPop(command: CommandType, segment: String, index: Int): Unit = {

  }

}

object CodeWriter {
  def apply(outputPath: String): CodeWriter = new CodeWriter(outputPath)
}




