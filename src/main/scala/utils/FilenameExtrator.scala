package utils

import scala.io.Source

object FilenameExtrator {
  def extractFilenameWithoutExtension(path: String): String = {
    path.split(Array('/', '\\')).last.takeWhile(_!='.')
  }
}
