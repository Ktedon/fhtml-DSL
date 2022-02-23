package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Data(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("62.0")),
    Edge(   Some("13.0")),
    Firefox(Some("22.0")),
    Opera(  Some("49.0")),
    Safari( None)
  )

  def getTag: String =
    s"<data ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</data>"

object Data:
	def apply(tags: HTMLTag*): Data =
		new Data(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Data =
		new Data(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Data =
		TagUtils.getWarning("data")(attributes*)
		new Data(true)(attributes*)(tags*)