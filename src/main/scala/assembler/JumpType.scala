package assembler

trait JumpType {
  val binary: String
}

object JumpTypes {
  object NoJump_jump extends JumpType {
    val binary = "000"
  }

  object JGT_jump extends JumpType {
    val binary = "001"
  }

  object JEQ_jump extends JumpType {
    val binary = "010"
  }

  object JGE_jump extends JumpType {
    val binary = "011"
  }

  object JLT_jump extends JumpType {
    val binary = "100"
  }

  object JNE_jump extends JumpType {
    val binary = "101"
  }

  object JLE_jump extends JumpType {
    val binary = "110"
  }

  object JMP_jump extends JumpType {
    val binary = "111"
  }
}