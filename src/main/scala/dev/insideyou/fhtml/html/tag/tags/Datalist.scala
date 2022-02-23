package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Datalist(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( Some("20.0")),
    Edge(   Some("10.0")),
    Firefox(Some("4.0")),
    Opera(  Some("9.5")),
    Safari( Some("12.1"))
  )

  def getTag: String =
    s"<datalist ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</datalist>"

object Datalist:
	def apply(tags: HTMLTag*): Datalist =
		new Datalist(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Datalist =
		new Datalist(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Datalist =
		TagUtils.getWarning("data")(attributes*)
		new Datalist(true)(attributes*)(tags*)