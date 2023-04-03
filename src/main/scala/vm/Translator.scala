package vm

import vm.Parser
import vm.CodeWriter
import utils.FileLoader
import utils.FilenameExtrator.extractFilenameWithoutExtension

import java.io.File

class Translator(codeWriter: CodeWriter, filepaths: List[String]) {

  filepaths.foreach(path => {
    val filename = extractFilenameWithoutExtension(path)

    val parser = Parser(FileLoader.load(path))
    codeWriter.setFileName(filename)

    while (parser.hasMoreCommands()){
      parser.advance()

      parser.commandType() match {
        case vm.CommandType.ARITHMETIC => codeWriter.writeArithmetic(parser.command)
        case vm.CommandType.PUSH => codeWriter.writePush(parser.memorySegment(), parser.arg2())
        case vm.CommandType.POP => codeWriter.writePop(parser.memorySegment(), parser.arg2())
        case vm.CommandType.LABEL => ???
        case vm.CommandType.GOTO => ???
        case vm.CommandType.IF => ???
        case vm.CommandType.FUNCTION => ???
        case vm.CommandType.RETURN => ???
        case vm.CommandType.CALL => ???
      }
    }


  })

  codeWriter.writeProgramEndLoop();
  codeWriter.close()
}

object Translator {
  def apply(path: String): Translator = {
    path match {
      case s"$filename.vm" =>
        val codeWriter = CodeWriter(s"$filename.asm")
        val filepaths = List(path)
        new Translator(codeWriter, filepaths)
      case _ => {
        val directory = new File(path)
        val dirName = extractFilenameWithoutExtension(path)
        val codeWriter = CodeWriter(s"$path/$dirName.asm")

        val filepaths = directory.listFiles().toList.filter(_.isFile).map(_.getPath).filter(_.endsWith(".vm"))

        new Translator(codeWriter, filepaths)

      }
    }
  }
}
