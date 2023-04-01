//package vm
//
//import assembler.CommnadTypes._
//
//import java.io.{File, PrintWriter}
//import scala.collection.mutable
//
//class CodeWriter(parser: Parser, outputPath: String) {
//
//
//
//  val symbolTable = generateSymbolTable()
//
//
//  def generateSymbolTable(): Map[Symbol, Int] = {
//    val symbolTable: mutable.Map[Symbol, Int] = scala.collection.mutable.Map(
//      Symbol("SP") -> 0,
//      Symbol("LCL") -> 1,
//      Symbol("ARG") -> 2,
//      Symbol("THIS") -> 3,
//      Symbol("THAT") -> 4,
//      Symbol("R0") -> 0,
//      Symbol("R1") -> 1,
//      Symbol("R2") -> 2,
//      Symbol("R3") -> 3,
//      Symbol("R4") -> 4,
//      Symbol("R5") -> 5,
//      Symbol("R6") -> 6,
//      Symbol("R7") -> 7,
//      Symbol("R8") -> 8,
//      Symbol("R9") -> 9,
//      Symbol("R10") -> 10,
//      Symbol("R11") -> 11,
//      Symbol("R12") -> 12,
//      Symbol("R13") -> 13,
//      Symbol("R14") -> 14,
//      Symbol("R15") -> 15,
//      Symbol("SCREEN") -> 16384,
//      Symbol("KBD") -> 24576,
//    )
//    var instructionCounter = 0
//    var variablePointer = 16
//
//    //add labels
//    while (parser.hasMoreCommands()) {
//      parser.advance()
//
//      parser.commandType() match {
//        case CommnadTypes.A_command => {
//          instructionCounter += 1
//        }
//        case CommnadTypes.C_command => {
//          instructionCounter += 1
//        }
//        case CommnadTypes.L_command => {
//          val symbol = parser.symbol()
//          if (symbol.isSymbolic) {
//            symbolTable.update(symbol, instructionCounter)
//          }
//        }
//      }
//    }
//    parser.reset()
//
//    //add variables
//    while (parser.hasMoreCommands()) {
//      parser.advance()
//
//      parser.commandType() match {
//        case CommnadTypes.A_command => {
//          val symbol = parser.symbol()
//          //symbol.isSymbolic is awkward
//          if (symbol.isSymbolic && !symbolTable.contains(symbol)) {
//            symbolTable.put(symbol, variablePointer)
//            variablePointer += 1
//          }
//        }
//        case CommnadTypes.C_command => {}
//        case CommnadTypes.L_command => {}
//      }
//    }
//
//
//    parser.reset()
//    symbolTable.toMap
//  }
//
//  def generateCode(): Unit = {
//    val writer = new PrintWriter(new File(outputPath))
//
//    while (parser.hasMoreCommands()) {
//      parser.advance()
//      parser.commandType() match {
//        case CommnadTypes.A_command => {
//          writer.print(A_command.binary)
//          parser.symbol().toIntOption match {
//            case Some(value) => writer.print(value.toBinaryString.reverse.padTo(15, '0').reverse)
//            case None => writer.print(symbolTable(parser.symbol()).toBinaryString.reverse.padTo(15, '0').reverse)
//          }
//          writer.println()
//        }
//        case CommnadTypes.C_command => {
//          writer.print(C_command.binary)
//          writer.print(parser.comp().binary)
//          writer.print(parser.dest().binary)
//          writer.print(parser.jump().binary)
//          writer.println()
//        }
//        case CommnadTypes.L_command => {} //ignore
//      }
//
//    }
//    writer.close()
//  }
//
//
//}
//
//
//
//
