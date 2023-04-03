package vm

import utils.FileLoader
import vm.Parser
import vm.SegmentType

import java.io.File

object Main extends App {
  val simpleAdd = "vm_programs/StackArithmetic/SimpleAdd"
  val stackTest = "vm_programs/StackArithmetic/SimpleAdd"
  val myStackArithmetic = "vm_programs/MyPrograms/StackArithmetic.vm"
  val negTest = "vm_programs/MyPrograms/NegTest.vm"
  val or = "vm_programs/MyPrograms/Or.vm"

  val tr = Translator(or)

}


