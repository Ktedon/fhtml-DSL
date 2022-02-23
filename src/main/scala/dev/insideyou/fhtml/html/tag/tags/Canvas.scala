package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Canvas(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("2.0")),
    Edge(   Some("9.0")),
    Firefox(Some("2.0")),
    Opera(  Some("3.1")),
    Safari( Some("9.0"))
  )

  def getTag: String =
    s"<canvas ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</canvas>"

object Canvas:
	def apply(tags: HTMLTag*): Canvas =
		new Canvas(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Canvas =
		new Canvas(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Canvas =
		TagUtils.getWarning("canvas")(attributes*)
		new Canvas(true)(attributes*)(tags*)