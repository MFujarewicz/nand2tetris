package vm

import vm.CodeWriter

class Translator(codeWriter: CodeWriter, filepaths: List[String]) {

}

object Translator {
  def apply(path: String): Translator = {
    path match {
      case s"$filename.vm" =>
        val cd = CodeWriter("sd")
        val filepaths = List(path)
        new Translator(cd, filepaths)
      case _ => {
        ???
      }
    }
  }
}
