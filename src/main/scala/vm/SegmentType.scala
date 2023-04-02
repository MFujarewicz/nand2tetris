package vm


object SegmentType extends Enumeration {
  type SegmentType = Value
  val ARGUMENT, LOCAL, STATIC, CONSTANT, THIS, THAT, POINTER, TEMP = Value
}