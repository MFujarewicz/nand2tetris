package vm

import utils.FileLoader
import vm.Parser

object Main extends App {

  val vmSources = List(
    "vm_programs/StackArithmetic/SimpleAdd/SimpleAdd.vm",
    "vm_programs/StackArithmetic/StackTest/StackTest.vm",
  )

  val path = vmSources(0)
  val lines = FileLoader.load(path)
  val parser = new Parser(lines)


}


