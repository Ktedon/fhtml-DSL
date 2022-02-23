package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Figure(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("8.0")),
    Edge(   Some("9.0")),
    Firefox(Some("4.0")),
    Opera(  Some("11.0")),
    Safari( Some("5.1"))
  )

  def getTag: String =
    s"<figure ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</figure>"

object Figure:
	def apply(tags: HTMLTag*): Figure =
		new Figure(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Figure =
		new Figure(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Figure =
		TagUtils.getWarning("figure")(attributes*)
		new Figure(true)(attributes*)(tags*)