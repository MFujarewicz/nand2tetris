package vm

object Main extends App {

  if (args.length != 1) {
    println("Please supply path to vm file or directory with vm files")
    System.exit(1)
  }
  Translator(args(0))
}


