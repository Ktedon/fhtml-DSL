package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Em(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<em ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</em>"

object Em:
	def apply(tags: HTMLTag*): Em =
		new Em(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Em =
		new Em(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Em =
		TagUtils.getWarning("em")(attributes*)
		new Em(true)(attributes*)(tags*)