package vm

import utils.FileLoader
import vm.Parser
import vm.SegmentType

import java.io.File

object Main extends App {
  val simpleAdd = "vm_programs/StackArithmetic/SimpleAdd"
  val stackTest = "vm_programs/StackArithmetic/StackTest"
  val myStackArithmetic = "vm_programs/MyPrograms/StackArithmetic.vm"
  val negTest = "vm_programs/MyPrograms/NegTest.vm"
  val or = "vm_programs/MyPrograms/Or.vm"
  val eq = "vm_programs/MyPrograms/EqTest.vm"
  val gt = "vm_programs/MyPrograms/GtTest.vm"
  val lt = "vm_programs/MyPrograms/LtTest.vm"

  val tr = Translator(stackTest)

}


