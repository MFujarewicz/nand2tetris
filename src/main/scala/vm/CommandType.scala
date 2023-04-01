package vm

trait CommandType

object CommandTypes {
  case object ARITHMETIC extends CommandType
  case object PUSH extends CommandType
  case object POP extends CommandType
  case object LABEL extends CommandType
  case object GOTO extends CommandType
  case object IF extends CommandType
  case object FUNCTION extends CommandType
  case object RETURN extends CommandType
  case object CALL extends CommandType
}