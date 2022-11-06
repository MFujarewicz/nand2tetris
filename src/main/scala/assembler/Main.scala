package assembler

import utils.FileLoader

object Main extends App {

  val programNames = List(
    "test",
    "Add",
    "Max",
    "Rect",
    "Pong"
  )

  def assemble(sourcePath: String, outputPath: String) = {
    val lines = FileLoader.load(sourcePath)
    val parser = new Parser(lines)
    val codeGenerator = new CodeGenerator(parser, outputPath)
    codeGenerator.generateCode()
  }

  programNames.foreach(programName => {
    val programPath = s"assembly_programs/source/$programName.asm"
    val outputPath = s"assembly_programs/assembled/$programName.hack"
    assemble(programPath, outputPath)
  })
}


