package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Blockquote(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("All")),
    Edge(   Some("All")),
    Firefox(Some("All")),
    Opera(  Some("All")),
    Safari( Some("All"))
  )

  def getTag: String =
    s"<blockquote ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</blockquote>"

object Blockquote:
	def apply(tags: HTMLTag*): Blockquote =
		new Blockquote(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Blockquote =
		new Blockquote(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Blockquote =
		TagUtils.getWarning("blockquote")(attributes*)
		new Blockquote(true)(attributes*)(tags*)