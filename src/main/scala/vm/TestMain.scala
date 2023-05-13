package vm

import utils.FileLoader
import vm.Parser
import vm.SegmentType

import java.io.File

object TestMain extends App {
  val simpleAdd = "vm_programs/StackArithmetic/SimpleAdd"
  val stackTest = "vm_programs/StackArithmetic/StackTest"
  val myStackArithmetic = "vm_programs/MyPrograms/StackArithmetic.vm"
  val negTest = "vm_programs/MyPrograms/NegTest.vm"
  val or = "vm_programs/MyPrograms/Or.vm"
  val eq = "vm_programs/MyPrograms/EqTest.vm"
  val gt = "vm_programs/MyPrograms/popSegments.vm"
  val lt = "vm_programs/MyPrograms/LtTest.vm"
  val static = "vm_programs/MemoryAccess/StaticTest/StaticTest.vm"
  val basicTest = "vm_programs/MemoryAccess/BasicTest"
  val pointerTest = "vm_programs/MemoryAccess/PointerTest"

  val popSegmentsTest = "vm_programs/MyPrograms/popSegments.vm"
  val pushSegmentsTest = "vm_programs/MyPrograms/pushSegments.vm"

//  val tr = Translator(pointerTest)

}


