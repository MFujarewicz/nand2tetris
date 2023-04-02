package vm


enum SegmentType {
  case ARGUMENT, LOCAL, STATIC, CONSTANT, THIS, THAT, POINTER, TEMP
}