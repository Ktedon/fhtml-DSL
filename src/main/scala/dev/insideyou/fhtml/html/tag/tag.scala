package fhtml

import fhtml.attributes.*

val DefaultWarningValue = true

trait FormattedString:

  @annotation.tailrec
  protected final def getFormattedString(text: String, formattedString: String)(
      index: Int
  ): String =
    if (text.length == 0)
      ""
    else if ((text.length - 1) == index)
      text(index) match
        case '\n'  => formattedString ++ "<br>"
        case '\t'  => formattedString ++ "&emsp"
        case ' '   => formattedString ++ "&nbsp"
        case '<'   => formattedString ++ "&lt;"
        case '>'   => formattedString ++ "&gt;"
        case other => formattedString ++ s"$other"
    else
      getFormattedString(
        text,
        text(index) match
          case '\n'  => formattedString ++ "<br>"
          case '\t'  => formattedString ++ "&emsp"
          case ' '   => formattedString ++ "&nbsp"
          case '<'   => formattedString ++ "&lt;"
          case '>'   => formattedString ++ "&gt;"
          case other => formattedString ++ s"$other"
      )(index + 1)

trait HTMLTag:
  def getTag: String
  def getWarning(tagName: String)(attributes: Attribute*): Unit =
    println(fansi.Color.Green(s"$tagName tag info:"))
    attributes.foreach { attr =>
      println((" "*4) ++ s"\"${attr.getClass.getSimpleName}\" attribute information:")
      if (attr.browserSupport.support.keys.filter(_ == tagName).nonEmpty && attr.getWarning == true)
        val browsers: (Chrome, Edge, Firefox, Opera, Safari) = attr.browserSupport.support("doctype")
        println((" "*10) ++ s"""${fansi.Color.Yellow("Earliest Google Chrome Version Support:   ") ++
            (browsers._1.earliestVersionSupported match {
              case Some(found) => fansi.Color.Green(s"${found}")
              case None        => fansi.Color.Red("No Support")
            })
          }
          ${fansi.Color.Yellow("Earliest Microsoft Edge Version Support:  ") ++
            (browsers._2.earliestVersionSupported match {
              case Some(found) => fansi.Color.Green(s"${found}")
              case None        => fansi.Color.Red("No Support")
            })
          }
          ${fansi.Color.Yellow("Earliest Mozilla Firefox Version Support: ") ++
            (browsers._3.earliestVersionSupported match {
              case Some(found) => fansi.Color.Green(s"${found}")
              case None        => fansi.Color.Red("No Support")
            })
          }
          ${fansi.Color.Yellow("Earliest Opera Version Support:           ") ++
            (browsers._4.earliestVersionSupported match {
              case Some(found) => fansi.Color.Green(s"${found}")
              case None        => fansi.Color.Red("No Support")
            })
          }
          ${fansi.Color.Yellow("Earliest Apple Safari Version Support:    ") ++
            (browsers._5.earliestVersionSupported match {
              case Some(found) => fansi.Color.Green(s"${found}")
              case None        => fansi.Color.Red("No Support")
            })
          }\n""")
      else if (attr.getWarning == true)
        println(fansi.Color.Red((" "*10) ++ s"The $tagName tag does not support the \"${attr.getClass.getSimpleName}\" attribute\n"))
    }

  val tagSupport: TagSupport

@scala.annotation.varargs
class Doctype(showWarning: Boolean)(attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  if (showWarning)
    getWarning("doctype")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  final def getText: String =
    this.tags.map(_.getTag).mkString("")

  def getTag: String =
    s"<!DOCTYPE ${this.attributes.map(_.getAttribute).mkString(" ")}>${this.tags.map(_.getTag).mkString("")}"

  def this(attributes: Attribute*)(tags: HTMLTag*) = this(DefaultWarningValue)(attributes*)(tags*)


@scala.annotation.varargs
class Plaintext(showWarning: Boolean)(attributes: Attribute*)(text: String)
    extends HTMLTag
    with FormattedString:

  if (showWarning)
    getWarning("plaintext")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  final def getText: String =
    this.text

  def getTag: String =
    s"<div ${this.attributes.map(_.getAttribute).mkString(" ")}>${getFormattedString(this.text, "")(0)}</div>"

  def this(attributes: Attribute*)(text: String) = this(DefaultWarningValue)(attributes*)(text)


@scala.annotation.varargs
class A(showWarning: Boolean)(attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  if (showWarning)
    getWarning("a")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  final def getText: String =
    this.tags.map(_.getTag).mkString("")

  def getTag: String =
    s"<a ${this.attributes.map(_.getAttribute).mkString(" ")}>${this.tags.map(_.getTag).mkString("")}</a>"

  def this(attributes: Attribute*)(tags: HTMLTag*) = this(DefaultWarningValue)(attributes*)(tags*)

@scala.annotation.varargs
class Abbr(showWarning: Boolean)(attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  if (showWarning)
    getWarning("abbr")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  final def getText: String =
    this.tags.map(_.getTag).mkString("")

  def getTag: String =
    s"<abbr ${this.attributes.map(_.getAttribute).mkString(" ")}>${this.tags.map(_.getTag).mkString("")}</abbr>"

  def this(attributes: Attribute*)(tags: HTMLTag*) = this(DefaultWarningValue)(attributes*)(tags*)

@scala.annotation.varargs
class Address(showWarning: Boolean)(attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  if (showWarning)
    getWarning("address")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  final def getText: String =
    this.tags.map(_.getTag).mkString("")

  def getTag: String =
    s"<address ${this.attributes.map(_.getAttribute).mkString(" ")}>${this.tags.map(_.getTag).mkString("")}</address>"

  def this(attributes: Attribute*)(tags: HTMLTag*) = this(DefaultWarningValue)(attributes*)(tags*)

@scala.annotation.varargs
class Area(showWarning: Boolean)(attributes: Attribute*)
    extends HTMLTag:

  if (showWarning)
    getWarning("address")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  def getTag: String =
    s"<address ${this.attributes.map(_.getAttribute).mkString(" ")}>"

  def this(attributes: Attribute*) = this(DefaultWarningValue)(attributes*)

@scala.annotation.varargs
class Article(showWarning: Boolean)(attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  if (showWarning)
    getWarning("article")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("All")),
      Edge(   Some("All")),
      Firefox(Some("All")),
      Opera(  Some("All")),
      Safari( Some("All"))
    )

  final def getText: String =
    this.tags.map(_.getTag).mkString("")

  def getTag: String =
    s"<article ${this.attributes.map(_.getAttribute).mkString(" ")}>${this.tags.map(_.getTag).mkString("")}</article>"

  def this(attributes: Attribute*)(tags: HTMLTag*) = this(DefaultWarningValue)(attributes*)(tags*)

@scala.annotation.varargs
class Aside(showWarning: Boolean)(attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  if (showWarning)
    getWarning("aside")(attributes*)

  val tagSupport: TagSupport =
    TagSupport(
      Chrome( Some("6.0")),
      Edge(   Some("9.0")),
      Firefox(Some("4.0")),
      Opera(  Some("11.1")),
      Safari( Some("5.0"))
    )

  final def getText: String =
    this.tags.map(_.getTag).mkString("")

  def getTag: String =
    s"<aside ${this.attributes.map(_.getAttribute).mkString(" ")}>${this.tags.map(_.getTag).mkString("")}</aside>"

  def this(attributes: Attribute*)(tags: HTMLTag*) = this(DefaultWarningValue)(attributes*)(tags*)



