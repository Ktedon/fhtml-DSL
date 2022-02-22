package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Aside(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("6.0")),
    Edge(   Some("9.0")),
    Firefox(Some("4.0")),
    Opera(  Some("11.1")),
    Safari( Some("5.0"))
  )

  def getTag: String =
    s"<aside ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</aside>"

object Aside:
	def apply(tags: HTMLTag*): Aside =
		new Aside(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Aside =
		new Aside(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Aside =
		TagUtils.getWarning("article")(attributes*)
		new Aside(true)(attributes*)(tags*)