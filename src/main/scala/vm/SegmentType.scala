package vm

import vm.SegmentTypes._


//object SegmentType extends Enumeration {
//  type SegmentType = Value
//  val LOCAL, ARGUMENT, STATIC, CONSTANT, THIS, THAT, POINTER, TEMP = Value
//}

trait SegmentType {
  val asmShorthand: Option[String] = None
}

object SegmentTypes {

  object LOCAL extends SegmentType {
    override val asmShorthand: Option[String] = Some("LCL")
  }

  object ARGUMENT extends SegmentType {
    override val asmShorthand: Option[String] = Some("ARG")
  }

  object STATIC extends SegmentType

  object CONSTANT extends SegmentType

  object THIS extends SegmentType {
    override val asmShorthand: Option[String] = Some("THIS")
  }

  object THAT extends SegmentType {
    override val asmShorthand: Option[String] = Some("THAT")
  }

  object POINTER extends SegmentType

  object TEMP extends SegmentType

}

object SegmentType {
  def withName(s: String): SegmentType = {
    s match {
      case "LOCAL" => LOCAL
      case "ARGUMENT" => ARGUMENT
      case "STATIC" => STATIC
      case "CONSTANT" => CONSTANT
      case "THIS" => THIS
      case "THAT" => THAT
      case "POINTER" => POINTER
      case "TEMP" => TEMP
    }
  }
}