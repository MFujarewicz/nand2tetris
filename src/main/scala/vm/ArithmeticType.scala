package vm

object ArithmeticType extends Enumeration {
  type CommandType = Value
  val ADD, SUB, NEG, EQ, GT, LT, AND, OR, NOT = Value
}