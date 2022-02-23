package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Col(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<col ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Col:

	def apply(attributes: Attribute*): Col =
		new Col(false)(attributes*)

	def w(attributes: Attribute*): Col =
		TagUtils.getWarning("col")(attributes*)
		new Col(true)(attributes*)