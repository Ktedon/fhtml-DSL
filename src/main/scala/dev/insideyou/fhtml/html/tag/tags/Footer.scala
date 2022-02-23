package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Footer(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("5.0")),
    Edge(   Some("9.0")),
    Firefox(Some("4.0")),
    Opera(  Some("11.1")),
    Safari( Some("5.0"))
  )

  def getTag: String =
    s"<footer ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</footer>"

object Footer:
	def apply(tags: HTMLTag*): Footer =
		new Footer(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Footer =
		new Footer(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Footer =
		TagUtils.getWarning("footer")(attributes*)
		new Footer(true)(attributes*)(tags*)