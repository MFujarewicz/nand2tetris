package vm

import vm.CommandType._
import vm.SegmentType


class Parser(input: Vector[String]) {

  private var commandTypeOpt: Option[CommandType] = None
  private var memorySegmentOpt: Option[SegmentType] = None
  private var arg2Opt: Option[Int] = None

  var iterator: Iterator[String] = input.map(cleanLine).filter(_.nonEmpty).iterator

  var command: String = null


  def reset(): Unit = {
    iterator = input.map(cleanLine).filter(_.nonEmpty).iterator
  }

  def cleanLine(string: String): String = {
    dropComment(dropMargins(string))
  }

  private def dropMargins(string: String): String = {
    string.stripLeading().stripTrailing()
  }

  def dropComment(string: String): String = {
    val index: Int = string.indexOf("//")
    if (index < 0) string else string.take(index)
  }

  def hasMoreCommands(): Boolean = {
    iterator.hasNext
  }

  def advance(): Unit = {
    command = iterator.next()

    commandTypeOpt = None
    memorySegmentOpt = None
    arg2Opt = None

    command match {
      case s"push ${arg1} ${arg2}" => {
        commandTypeOpt = Some(PUSH)
        memorySegmentOpt = Some(SegmentType.withName(arg1.toUpperCase))
        arg2Opt = Some(arg2.toInt)
      }
      case s"pop ${arg1} ${arg2}" => {
        commandTypeOpt = Some(POP)
        memorySegmentOpt = Some(SegmentType.withName(arg1.toUpperCase))
        arg2Opt = Some(arg2.toInt)
      }
      case "add" => commandTypeOpt = Some(ARITHMETIC)
      case "sub" => commandTypeOpt = Some(ARITHMETIC)
      case "neg" => commandTypeOpt = Some(ARITHMETIC)
      case "eq" => commandTypeOpt = Some(ARITHMETIC)
      case "gt" => commandTypeOpt = Some(ARITHMETIC)
      case "lt" => commandTypeOpt = Some(ARITHMETIC)
      case "and" => commandTypeOpt = Some(ARITHMETIC)
      case "or" => commandTypeOpt = Some(ARITHMETIC)
      case "not" => commandTypeOpt = Some(ARITHMETIC)
    }
  }

  def commandType(): CommandType = {
    commandTypeOpt.get
  }

  def memorySegment(): SegmentType = {
    memorySegmentOpt.get
  }

  def arg2(): Int = {
    arg2Opt.get
  }
}

object Parser{
  def apply(input: Vector[String]): Parser = new Parser(input)
}




