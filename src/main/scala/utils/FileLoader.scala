package utils

import scala.io.Source

object FileLoader {
  def load(path: String): Vector[String] = {
    val source = Source.fromFile(path)
    val lines = source.getLines().toVector
    source.close()
    lines
  }
}
