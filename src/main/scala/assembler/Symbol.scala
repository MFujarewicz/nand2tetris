package assembler

case class Symbol(value: String){
  val toIntOption: Option[Int] = value.toIntOption
  val isNumeric: Boolean = toIntOption.nonEmpty
  val isSymbolic: Boolean = !isNumeric
}