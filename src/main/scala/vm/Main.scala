package vm

import utils.FileLoader
import vm.Parser
import vm.SegmentType

import java.io.File

object Main extends App {
  val simpleAdd= "vm_programs/StackArithmetic/SimpleAdd"
  val stackTest= "vm_programs/StackArithmetic/SimpleAdd"

  val tr = Translator(simpleAdd)

}


