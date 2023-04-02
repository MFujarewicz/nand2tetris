package vm

import assembler.CommnadTypes._

import java.io.{File, PrintWriter}
import scala.collection.mutable

class CodeWriter(outputPath: String) {
  private var currentFile: Option[String] = None

  def setFileName(filename: String): Unit = {
    currentFile = Some(filename)
  }

  def writeArithmetic(command: String): Unit = {

  }

  def writePushPop(command: CommandType, segment: String, index: Int): Unit = {

  }

}




