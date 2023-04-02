package vm

import vm.CodeWriter

import java.io.File

class Translator(codeWriter: CodeWriter, filepaths: List[String]) {

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
        val dirName = path.split(Array('/', '\\')).last.takeWhile(_ != '.')
        val codeWriter = CodeWriter(s"$path/$dirName.asm")

        val filepaths = directory.listFiles().toList.filter(_.isFile).map(_.getPath).filter(_.endsWith(".vm"))

        new Translator(codeWriter, filepaths)

      }
    }
  }
}
