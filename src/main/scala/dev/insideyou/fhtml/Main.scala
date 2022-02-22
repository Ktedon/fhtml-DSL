package fhtml

import fhtml.*
import fhtml.attributes.*

object Main extends App:
  println("")

  var j = Doctype(new HTML)(Plaintext("yo  yoyo  "))
  
  println("\n" ++ j.getTag ++ "\n")
