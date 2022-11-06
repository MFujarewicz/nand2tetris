package assembler
import assembler.CommnadTypes._
import assembler.DestinationTypes._
import assembler.JumpTypes._
import assembler.ComputationTypes._


class Parser(input: Vector[String]) {

  var iterator: Iterator[String] = input.map(cleanLine).filter(_.nonEmpty).iterator

  var command: String = null

  def reset(): Unit = {
    iterator = input.map(cleanLine).filter(_.nonEmpty).iterator
  }

  def cleanLine(string: String): String = {
    dropComment(dropAllWhitespace(string))
  }

  def dropAllWhitespace(string: String): String = {
    string.filter(!_.isWhitespace)
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
  }

  def commandType(): CommandType = {
    command.head match {
      case '@' => A_command
      case '(' => L_command
      case _ => C_command
    }
  }

  def symbol(): Symbol = {
    commandType() match {
      case A_command => Symbol(command.tail)
      case L_command => Symbol(command.substring(1, command.length - 1))
      case C_command => throw new Exception(s"There's no symbol in C_COMMAND: $command")
    }
  }

  def dest(): DestinationType = {
    assert(commandType() == C_command)
    val commnandBeforeEquals = if (command.contains("=")) command.takeWhile(_ != '=') else ""

    commnandBeforeEquals match {
      case "" => NoDestination_dest
      case  "M" => M_dest
      case  "D" => D_dest
      case  "MD" => MD_dest
      case  "A" => A_dest
      case  "AM" => AM_dest
      case  "AD" => AD_dest
      case  "AMD" => AMD_dest
    }
  }


  def comp(): ComputationType = {
    assert(commandType() == C_command)

    val equalsIndex = command.indexOf("=")

    val partBeforeSemicolon = command.takeWhile(_ != ';')
    val compString = if (equalsIndex > -1) partBeforeSemicolon.substring(equalsIndex+1) else partBeforeSemicolon

    compString match {
      case "0" => Zero_comp
      case "1" => One_comp
      case "-1" => MinusOne_comp
      case "D" => D_comp
      case "A" => A_comp
      case "!D" => NotD_comp
      case "!A" => NotA_comp
      case "-D" => MinusD_comp
      case "-A" => MinusA_comp
      case "D+1" => DPlusOne_comp
      case "A+1" => APlusOne_comp
      case "D-1" => DMinusOne_comp
      case "A-1" => AMinusOne_comp
      case "D+A" => DPlusA_comp
      case "D-A" => DMinusA_comp
      case "A-D" => AMinusD_comp
      case "D&A" => DAndA_comp
      case "D|A" => DOrA_comp

      case "M" => M_comp
      case "!M" => NotM_comp
      case "-M" => MinusM_comp
      case "M+1" => MPlusOne_comp
      case "M-1" => MMinusOne_comp
      case "D+M" => DPlusM_comp
      case "D-M" => DMinusM_comp
      case "M-D" => MMinusD_comp
      case "D&M" => DAndM_comp
      case "D|M" => DOrM_comp

    }
  }

  def jump(): JumpType = {
    assert(commandType() == C_command)
    val commandLastPart = command.dropWhile(_ != ';').filter(_ != ';')

    commandLastPart match {
      case "" => NoJump_jump
      case "JGT" => JGT_jump
      case "JEQ" => JEQ_jump
      case "JGE" => JGE_jump
      case "JLT" => JLT_jump
      case "JNE" => JNE_jump
      case "JLE" => JLE_jump
      case "JMP" => JMP_jump
    }
  }
}




