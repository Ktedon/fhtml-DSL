package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Dd(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<dd ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</dd>"

object Dd:
	def apply(tags: HTMLTag*): Dd =
		new Dd(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Dd =
		new Dd(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Dd =
		TagUtils.getWarning("dd")(attributes*)
		new Dd(true)(attributes*)(tags*)