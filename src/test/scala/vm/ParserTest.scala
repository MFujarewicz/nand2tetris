package vm

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import vm.CommandType._
import vm.SegmentType._

class ParserTest extends AnyFlatSpec with Matchers {
  "parser" should "return correct command type" in {

    val vmCode =
      """//only chapter 7 commands
        |push constant 17
        |pop local 891
        |add
        |sub
        |neg
        |eq
        |gt
        |lt
        |and
        |or
        |not
        |""".stripMargin.split("\n").toVector

    val parser = new Parser(vmCode)

    parser.advance();
    parser.commandType() shouldEqual PUSH
    parser.advance();
    parser.commandType() shouldEqual POP
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC
    parser.advance();
    parser.commandType() shouldEqual ARITHMETIC

  }

  "parser" should "have correct command type and args in push and pop " in {

    val vmCode = """push constant 17
                   |pop local 891""".stripMargin.split("\n").toVector

    val parser = new Parser(vmCode)

    parser.advance();
    parser.commandType() shouldEqual PUSH
    parser.arg1() shouldEqual CONSTANT
    parser.arg2() shouldEqual 17

    parser.advance()
    parser.commandType() shouldEqual POP
    parser.arg1() shouldEqual LOCAL
    parser.arg2() shouldEqual 891


  }
}
