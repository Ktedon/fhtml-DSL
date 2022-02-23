package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Del(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<del ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</del>"

object Del:
	def apply(tags: HTMLTag*): Del =
		new Del(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Del =
		new Del(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Del =
		TagUtils.getWarning("del")(attributes*)
		new Del(true)(attributes*)(tags*)