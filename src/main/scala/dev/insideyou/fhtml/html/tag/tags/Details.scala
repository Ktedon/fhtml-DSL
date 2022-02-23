package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Details(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("12.0")),
    Edge(   Some("79.0")),
    Firefox(Some("49.0")),
    Opera(  Some("15.0")),
    Safari( Some("6.0"))
  )

  def getTag: String =
    s"<details ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</details>"

object Details:
	def apply(tags: HTMLTag*): Details =
		new Details(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Details =
		new Details(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Details =
		TagUtils.getWarning("details")(attributes*)
		new Details(true)(attributes*)(tags*)