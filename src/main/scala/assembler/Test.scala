package assembler

object Test extends App {

  case class XD(i: Int);

  val map = Map(XD(1) -> 1)

  println(map.contains(XD(1)))

}


class InteratorPrinter(iterator: Iterator[String]) {
  def printNext = println(iterator.next())
}
