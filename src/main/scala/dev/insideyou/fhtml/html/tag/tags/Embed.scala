package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Embed(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<embed ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Embed:

	def apply(attributes: Attribute*): Embed =
		new Embed(false)(attributes*)

	def w(attributes: Attribute*): Embed =
		TagUtils.getWarning("embed")(attributes*)
		new Embed(true)(attributes*)