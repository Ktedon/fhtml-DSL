package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Area(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  def getTag: String =
    s"<area ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Area:

	def apply(attributes: Attribute*): Area =
		new Area(false)(attributes*)

	def w(attributes: Attribute*): Area =
		TagUtils.getWarning("area")(attributes*)
		new Area(true)(attributes*)