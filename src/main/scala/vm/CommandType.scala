package vm

object CommandType extends Enumeration {
  type CommandType = Value
  val ARITHMETIC, PUSH, POP, LABEL, GOTO, IF, FUNCTION, RETURN, CALL = Value
}