package assembler

trait CommandType

object CommnadTypes {
  object A_command extends CommandType {
    val binary = "0"
  }

  object C_command extends CommandType {
    val binary = "111"
  }

  object L_command extends CommandType
}