package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Audio(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
      Chrome( Some("4.0")),
      Edge(   Some("9.0")),
      Firefox(Some("3.5")),
      Opera(  Some("4.0")),
      Safari( Some("11.5"))
    )

  def getTag: String =
    s"<audio ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Audio:

	def apply(attributes: Attribute*): Audio =
		new Audio(false)(attributes*)

	def w(attributes: Attribute*): Audio =
		TagUtils.getWarning("audio")(attributes*)
		new Audio(true)(attributes*)