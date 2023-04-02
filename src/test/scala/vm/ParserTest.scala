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

    val vmCode =
      """push constant 17
        |pop local 891""".stripMargin.split("\n").toVector

    val parser = new Parser(vmCode)

    parser.advance();
    parser.commandType() shouldEqual PUSH
    parser.memorySegment() shouldEqual CONSTANT
    parser.memoryIndex() shouldEqual 17

    parser.advance()
    parser.commandType() shouldEqual POP
    parser.memorySegment() shouldEqual LOCAL
    parser.memoryIndex() shouldEqual 891


  }

  "parser" should "have correct memory segment" in {

    val vmCode =
      """push argument 17
        |pop local 891
        |pop static 891
        |pop constant 891
        |pop this 891
        |pop that 891
        |pop pointer 891
        |pop temp 891
        |
        |
        |""".stripMargin.split("\n").toVector

    val parser = new Parser(vmCode)

    parser.advance();
    parser.memorySegment() shouldEqual ARGUMENT
    parser.advance();
    parser.memorySegment() shouldEqual LOCAL
    parser.advance();
    parser.memorySegment() shouldEqual STATIC
    parser.advance();
    parser.memorySegment() shouldEqual CONSTANT
    parser.advance();
    parser.memorySegment() shouldEqual THIS
    parser.advance();
    parser.memorySegment() shouldEqual THAT
    parser.advance();
    parser.memorySegment() shouldEqual POINTER
    parser.advance();
    parser.memorySegment() shouldEqual TEMP

  }
}
