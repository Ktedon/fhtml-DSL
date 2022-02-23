package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Dl(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<dl ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</dl>"

object Dl:
	def apply(tags: HTMLTag*): Dl =
		new Dl(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Dl =
		new Dl(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Dl =
		TagUtils.getWarning("dl")(attributes*)
		new Dl(true)(attributes*)(tags*)