package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Caption(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<caption ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</caption>"

object Caption:
	def apply(tags: HTMLTag*): Caption =
		new Caption(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Caption =
		new Caption(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Caption =
		TagUtils.getWarning("caption")(attributes*)
		new Caption(true)(attributes*)(tags*)