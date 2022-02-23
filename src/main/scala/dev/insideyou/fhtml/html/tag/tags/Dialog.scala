package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Dialog(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("37.0")),
    Edge(   Some("79.0")),
    Firefox(None),
    Opera(  Some("24.0")),
    Safari( None)
  )

  def getTag: String =
    s"<dialog ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</dialog>"

object Dialog:
	def apply(tags: HTMLTag*): Dialog =
		new Dialog(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Dialog =
		new Dialog(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Dialog =
		TagUtils.getWarning("dialog")(attributes*)
		new Dialog(true)(attributes*)(tags*)