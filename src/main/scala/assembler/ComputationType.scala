package assembler

trait ComputationType {
  val binary: String
}

object ComputationTypes {
  // a=0
  object Zero_comp extends ComputationType {
    val binary = "0101010"
  }

  object One_comp extends ComputationType {
    val binary = "0111111"
  }

  object MinusOne_comp extends ComputationType {
    val binary = "0111010"
  }

  object D_comp extends ComputationType {
    val binary = "0001100"
  }

  object A_comp extends ComputationType {
    val binary = "0110000"
  }

  object NotD_comp extends ComputationType {
    val binary = "0001101"
  }

  object NotA_comp extends ComputationType {
    val binary = "0110001"
  }

  object MinusD_comp extends ComputationType {
    val binary = "0001111"
  }

  object MinusA_comp extends ComputationType {
    val binary = "0110011"
  }

  object DPlusOne_comp extends ComputationType {
    val binary = "0011111"
  }

  object APlusOne_comp extends ComputationType {
    val binary = "0110111"
  }

  object DMinusOne_comp extends ComputationType {
    val binary = "0001110"
  }

  object AMinusOne_comp extends ComputationType {
    val binary = "0110010"
  }

  object DPlusA_comp extends ComputationType {
    val binary = "0000010"
  }

  object DMinusA_comp extends ComputationType {
    val binary = "0010011"
  }

  object AMinusD_comp extends ComputationType {
    val binary = "0000111"
  }

  object DAndA_comp extends ComputationType {
    val binary = "0000000"
  }

  object DOrA_comp extends ComputationType {
    val binary = "0010101"
  }

  //a=1
  object M_comp extends ComputationType {
    val binary = "1110000"
  }

  object NotM_comp extends ComputationType {
    val binary = "1110001"
  }

  object MinusM_comp extends ComputationType {
    val binary = "1110011"
  }

  object MPlusOne_comp extends ComputationType {
    val binary = "1110111"
  }

  object MMinusOne_comp extends ComputationType {
    val binary = "1110010"
  }

  object DPlusM_comp extends ComputationType {
    val binary = "1000010"
  }

  object DMinusM_comp extends ComputationType {
    val binary = "1010011"
  }

  object MMinusD_comp extends ComputationType {
    val binary = "1000111"
  }

  object DAndM_comp extends ComputationType {
    val binary = "1000000"
  }

  object DOrM_comp extends ComputationType {
    val binary = "1010101"
  }


}