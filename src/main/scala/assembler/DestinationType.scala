package assembler


trait DestinationType {
  val binary: String
}

object DestinationTypes {
  object NoDestination_dest extends DestinationType {
    val binary = "000"
  }

  object M_dest extends DestinationType {
    val binary = "001"
  }

  object D_dest extends DestinationType {
    val binary = "010"
  }

  object MD_dest extends DestinationType {
    val binary = "011"
  }

  object A_dest extends DestinationType {
    val binary = "100"
  }

  object AM_dest extends DestinationType {
    val binary = "101"
  }

  object AD_dest extends DestinationType {
    val binary = "110"
  }

  object AMD_dest extends DestinationType {
    val binary = "111"
  }
}