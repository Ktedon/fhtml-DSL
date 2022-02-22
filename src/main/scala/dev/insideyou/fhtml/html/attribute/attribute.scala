package fhtml.attributes

import fhtml.*

val DefaultWarningValue = true

abstract class Attribute(showWarning: Boolean):
	val supportedTags: Array[String]
	val browserSupport: AttributeSupport

	def getAttribute: String
	def getWarning = showWarning

abstract class NoParamAttribute(showWarning: Boolean) extends Attribute(showWarning)
abstract class ParamAttribute(showWarning: Boolean) extends Attribute(showWarning):
	def ->(suffixValue: String): Attribute
	def getSuffix: String

case class HTML(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("doctype")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map (
				"doctype" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "html"
	def this() = this(DefaultWarningValue)

class Accept(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("8.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String) = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"accept=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class AcceptCharset(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"accept-charset=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Accesskey(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"accesskey=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Action(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map (
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"action=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Alt(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("area", "img", "input")
	val browserSupport: AttributeSupport = 
		AttributeSupport(
			Map(
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome(Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome(Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"alt=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Async(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("script")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map (
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("3.6")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "async"

class Autocomplete(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form", "input")
	val browserSupport: AttributeSupport = 
		AttributeSupport(
			Map(
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("4.0")),
					Opera(  Some("15.0")),
					Safari( Some("5.2"))
				),
				"input" -> (
					Chrome(Some("17.0")),
					Edge(   Some("5.0")),
					Firefox(Some("4.0")),
					Opera(  Some("9.6")),
					Safari( Some("15.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"autocomplete=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Autofocus(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("form", "input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"form" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("9.6")),
					Safari( Some("5.0"))
				),
				"input" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("9.6")),
					Safari( Some("5.0"))
				),
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "autofocus"
	def this() = this(DefaultWarningValue)

class Autoplay(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map (
				"audio" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				),
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def getAttribute: String = "autoplay"
	def this() = this(DefaultWarningValue)

class Charset(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meta", "script")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"meta" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"charset=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Checked(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("2.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				)
			)
		)

	def getAttribute: String = "checked"
	def this() = this(DefaultWarningValue)

class Cite(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("blockquote", "del", "ins", "q")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"blockquote" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"del" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"ins" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"q" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"cite=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Class(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"class=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Cols(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"cols=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Colspan(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("td", "th")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"td" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"th" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"colspan=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Content(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meta")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"td" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"content=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Contenteditable(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("4.0")),
					Edge(   Some("6.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.1")),
					Safari( Some("3.1"))
				)
			)
		)

	def getAttribute: String = "contenteditable"
	def this() = this(DefaultWarningValue)

class Controls(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				),
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def getAttribute: String = "controls"
	def this() = this(DefaultWarningValue)

class Coords(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("area")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"coords=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Data(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("object")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"object" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"data=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class `Data-`(nameAddition: String)(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("4.0")),
					Edge(   Some("5.5")),
					Firefox(Some("2.0")),
					Opera(  Some("9.6")),
					Safari( Some("3.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"data-$nameAddition=\"$suffix\""
	def getSuffix:               String = suffix
	def this(nameAddition: String)() = this(nameAddition)(DefaultWarningValue)

class Datatime(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("del", "ins", "time")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"del" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"ins" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"time" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"datatime=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Default(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"track" -> (
					Chrome( Some("18.0")),
					Edge(   Some("10.0")),
					Firefox(Some("31.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def getAttribute: String = "default"
	def this() = this(DefaultWarningValue)

class Defer(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("script")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("3.6")),
					Opera(  Some("15.0")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "defer"
	def this() = this(DefaultWarningValue)

class Dir(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"dir=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Dirname(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(None),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(None),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"dirname=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Disabled(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("button", "fieldset", "input", "optgroup", "option", "select", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"button" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"fieldset" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("7.0"))
				),
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("6.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"optgroup" -> (
					Chrome( Some("1.0")),
					Edge(   Some("8.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"option" -> (
					Chrome( Some("1.0")),
					Edge(   Some("8.0")),
					Firefox(Some("1.0")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"select" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute:            String = "disabled"
	def this() = this(DefaultWarningValue)

class Download(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("a", "area")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("14.0")),
					Edge(   Some("13.0")),
					Firefox(Some("20.0")),
					Opera(  Some("15.0")),
					Safari( None)
				),
				"area" -> (
					Chrome( Some("14.0")),
					Edge(   None),
					Firefox(Some("20.0")),
					Opera(  Some("15.0")),
					Safari( None)
				)
			)
		)

	def getAttribute: String = "download"
	def this() = this(DefaultWarningValue)

class Draggable(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("13.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def getAttribute:            String = "draggabe"
	def this() = this(DefaultWarningValue)

class Enctype(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"enctype=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)


class For(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("label", "output")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"label" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"output" -> (
					Chrome( Some("10.0")),
					Edge(   None),
					Firefox(Some("4.0")),
					Opera(  Some("11.0")),
					Safari( Some("5.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"for=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Form(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "fieldset", "input", "label", "meter", "object", "output", "select", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport(
			Map(
				"button" -> (
					Chrome( Some("10.0")),
					Edge(   None),
					Firefox(Some("4.0")),
					Opera(  Some("9.5")),
					Safari( Some("5.1"))
				),
				"fieldset" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				),
				"input" -> (
					Chrome( Some("9.0")),
					Edge(   None),
					Firefox(Some("4.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.1"))
				),
				"label" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"meter" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				),
				"object" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				),
				"output" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"select" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			) 
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"form=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Formaction(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"button" -> (
					Chrome( Some("9.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.1"))
				),
				"input" -> (
					Chrome( Some("9.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"formaction=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Headers(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("td", "th")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"td" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"th" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"headers=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Height(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("canvas", "embed", "iframe", "img", "input", "object", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"canvas" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("2.0")),
					Opera(  Some("9.0")),
					Safari( Some("3.1"))
				),
				"embed" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"iframe" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("All")),
					Firefox(Some("16.0")),
					Opera(  Some("1.0")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"height=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Hidden(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("6.0")),
					Edge(   Some("11.0")),
					Firefox(Some("4.0")),
					Opera(  Some("11.1")),
					Safari( Some("5.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = "hidden"
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class High(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meter")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"meter" -> (
					Chrome( Some("8.0")),
					Edge(   None),
					Firefox(Some("6.0")),
					Opera(  Some("11.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"high=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Href(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "base", "link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"base" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"href=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Hreflang(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"hreflang=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class HttpEquiv(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meta")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"meta" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"http-equiv=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Id(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"id=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ismap(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("img")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "ismap"
	def this() = this(DefaultWarningValue)

class Kind(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("18.0")),
					Edge(   Some("10.0")),
					Firefox(Some("31.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"kind=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Label(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"track" -> (
					Chrome( Some("18.0")),
					Edge(   Some("10.0")),
					Firefox(Some("31.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"label=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Lang(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attribute" -> (
					Chrome( Some("18.0")),
					Edge(   Some("10.0")),
					Firefox(Some("31.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"lang=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class List(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("20.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("9.6")),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"list=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Loop(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				),
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("11.0")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def getAttribute: String = "loop"
	def this() = this(DefaultWarningValue)

class Low(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meter")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"meter" -> (
					Chrome( Some("8.0")),
					Edge(   None),
					Firefox(Some("6.0")),
					Opera(  Some("11.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"low=\"$suffix\""
	def getSuffix:               String = suffix	
	def this() = this(DefaultWarningValue)

class Max(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "meter", "progress")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("16.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.1"))
				),
				"meter" -> (
					Chrome( Some("8.0")),
					Edge(   None),
					Firefox(Some("6.0")),
					Opera(  Some("11.0")),
					Safari( Some("6.0"))
				),
				"progress" -> (
					Chrome( Some("8.0")),
					Edge(   Some("10.0")),
					Firefox(Some("16.0")),
					Opera(  Some("11.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"max=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Maxlength(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("2.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("15.0")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"maxlength=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Media(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "link", "source", "style")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"source" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				),
				"style" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"media=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Method(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"method=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Min(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "meter")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("16.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.1"))
				),
				"meter" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("16.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"min=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Multiple(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "select")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("6.0")),
					Edge(   Some("10.0")),
					Firefox(Some("3.6")),
					Opera(  Some("11.0")),
					Safari( Some("5.0"))
				),
				"select" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("ALl")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"multiple=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Muted(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   Some("10.0")),
					Firefox(Some("11.0")),
					Opera(  Some("10.5")),
					Safari( Some("7.1"))
				)
			)
		)

	def getAttribute: String = "muted"
	def this() = this(DefaultWarningValue)

class Name(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "fieldset", "form", "iframe", "input", "map", "meta", "object", "output", "param", "select", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"button" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"fieldset" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"iframe" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("2.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"map" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"meta" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"output" -> (
					Chrome( Some("10.0")),
					Edge(   None),
					Firefox(Some("4.0")),
					Opera(  Some("11.0")),
					Safari( Some("5.1"))
				),
				"param" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"select" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"name=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Novalidate(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"video" -> (
					Chrome( Some("10.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("10.6")),
					Safari( None)
				)
			)
		)

	def getAttribute: String = "novalidate"
	def this() = this(DefaultWarningValue)

class Onabort(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "embed", "img", "object", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"embed" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("ALl")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("ALl")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(Some("ALl")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("ALl")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onabort=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onafterprint(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("63")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onafterprint=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onbeforeprint(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("63")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onbeforeprint=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onbeforeunload(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("15.0")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onbeforeunload=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onblur(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onblur=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oncanplay(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "embed", "object", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"embed" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				),
				"object" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oncanplay=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oncanplaythrough(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oncanplaythrough=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onchange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onchange=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onclick(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onclick=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oncontextmenu(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oncontextmenu=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oncopy(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oncopy=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oncuechange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"track" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(None),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oncuechange=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oncut(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oncut=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondblclick(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondblclick=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondrag(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondrag=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondragend(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondragend=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondragenter(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondragenter=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondragleave(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondragleave=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondragover(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondragover=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondragstart(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondragstart=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondrop(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("12.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondrop=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ondurationchange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ondurationchange=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onemptied(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("Unknown")),
					Edge(   Some("Unknown")),
					Firefox(Some("Unknown")),
					Opera(  Some("Unknown")),
					Safari( Some("Unknown"))
				),
				"video" -> (
					Chrome( Some("Unknown")),
					Edge(   Some("Unknown")),
					Firefox(Some("Unknown")),
					Opera(  Some("Unknown")),
					Safari( Some("Unknown"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onemptied=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onended(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onended=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onerror(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "body", "embed", "img", "link", "object", "script", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"body" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"embed" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onerror=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onfocus(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onfocus=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onhashchange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("5.0")),
					Edge(   Some("8.0")),
					Firefox(Some("3.6")),
					Opera(  Some("10.6")),
					Safari( Some("5.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onhashchange=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Oninput(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oninput=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Oninvalidate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("All")),
					Opera(  None),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"oninvalidate=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onkeydown(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onkeydown=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onkeypress(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onkeypress=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onkeyup(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body", "iframe", "img", "input", "link", "script", "style")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"iframe" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"style" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onkeyup=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onloadeddata(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onloadeddata=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onloadedmetadata(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onloadedmetadata=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onloadstart(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onloadstart=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onmousedown(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onmousedown=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onmousemove(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onmousemove=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onmouseout(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onmouseout=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onmouseover(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onmouseover=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onmouseup(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onmouseup=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onoffline(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( None),
					Edge(   Some("8.0")),
					Firefox(Some("3.0")),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onoffline=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Ononline(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( None),
					Edge(   Some("8.0")),
					Firefox(Some("3.0")),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ononline=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onpagehide(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("Unknown")),
					Edge(   Some("Unknown")),
					Firefox(Some("Unknown")),
					Opera(  Some("Unknown")),
					Safari( Some("Unknown"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onpagehide=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onpageshow(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("11.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("5.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onpageshow=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onpaste(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onpaste=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onpause(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onpause=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onplay(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onplay=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onplaying(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onplaying=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onpopstate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("Unknown")),
					Edge(   Some("Unknown")),
					Firefox(Some("Unknown")),
					Opera(  Some("Unknown")),
					Safari( Some("Unknown"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onpopstate=\"$suffix\""
	def getSuffix:               String = suffix 
	def this() = this(DefaultWarningValue)

class Onprogress(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onprogress=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onratechange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onratechange=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onreset(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onreset=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onresize(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onresize=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onscroll(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onscroll=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onsearch(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   None),
					Firefox(None),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onsearch=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onseeked(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onseeked=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onseeking(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onseeking=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onselect(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onselect=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onstalled(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onstalled=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onstorage(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"body" -> (
					Chrome( Some("Unknown")),
					Edge(   Some("Unknown")),
					Firefox(Some("Unknown")),
					Opera(  Some("Unknown")),
					Safari( Some("Unknown"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onstorage=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onsubmit(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onsubmit=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onsuspend(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onsuspend=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ontimeupdate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ontimeupdate=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Ontoggle(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("details")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"details" -> (
					Chrome( Some("12.0")),
					Edge(   None),
					Firefox(None),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ontoggle=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onunload(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("details")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"details" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onunload=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onvolumechange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onvolumechange=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onwaiting(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("9.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onwaiting=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Onwheel(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"All visible elements" -> (
					Chrome( Some("31.0")),
					Edge(   None),
					Firefox(Some("17.0")),
					Opera(  Some("18.0")),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onwheel=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Open(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("details")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"details" -> (
					Chrome( Some("12.0")),
					Edge(   None),
					Firefox(None),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def getAttribute:            String = "open"
	def this() = this(DefaultWarningValue)

class Optimum(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meter")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"meter" -> (
					Chrome( Some("8.0")),
					Edge(   None),
					Firefox(Some("6.0")),
					Opera(  Some("11.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"optimum=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Pattern(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("9.6")),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"pattern=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Placeholder(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("10.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("11.0")),
					Safari( Some("5.0"))
				),
				"input" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("11.5")),
					Safari( Some("5.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"placeholder=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Poster(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"poster=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Preload(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("4.0")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				),
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   None),
					Firefox(Some("4.0")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"preload=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Readonly(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("6.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"video" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "readonly"
	def this() = this(DefaultWarningValue)

class Rel(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "form", "link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"rel=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Required(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("a", "area", "form", "link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("9.6")),
					Safari( None)
				),
				"select" -> (
					Chrome( Some("All")),
					Edge(   Some("10.0")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( None)
				),
				"textarea" -> (
					Chrome( Some("5.0")),
					Edge(   Some("10.0")),
					Firefox(Some("4.0")),
					Opera(  Some("All")),
					Safari( None)
				)
			)
		)

	def getAttribute: String = "required"
	def this() = this(DefaultWarningValue)

class Reversed(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("ol")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"ol" -> (
					Chrome( Some("18.0")),
					Edge(   None),
					Firefox(Some("18.0")),
					Opera(  Some("All")),
					Safari( Some("5.2"))
				)
			)
		)

	def getAttribute: String = "reversed"

class Rowspan(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("td", "th")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"td" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"th" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"rowspan=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Sandbox(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("iframe")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"iframe" -> (
					Chrome( Some("4.0")),
					Edge(   Some("10.0")),
					Firefox(Some("17.0")),
					Opera(  Some("15.0")),
					Safari( Some("5.0"))
				)
			)
		)

	def getAttribute: String = "sandbox"
	def this() = this(DefaultWarningValue)

class Scope(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("th")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"th" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"scope=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Selected(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("option")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"option" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def getAttribute: String = "selected"
	def this() = this(DefaultWarningValue)

class Shape(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("area")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"shape=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Size(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "select")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("2.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"select" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"size=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Sizes(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"link" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"sizes=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Span(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("col", "colgroup")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"col" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"colgroup" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"span=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Spellcheck(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("9.0")),
					Edge(   Some("10.0")),
					Firefox(Some("2.0")),
					Opera(  Some("10.5")),
					Safari( Some("5.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"spellcheck=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Src(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "embed", "iframe", "img", "input", "script", "source", "track", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"audio" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				),
				"embed" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"iframe" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("2.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"source" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				),
				"track" -> (
					Chrome( Some("18.0")),
					Edge(   Some("10.0")),
					Firefox(Some("31.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				),
				"video" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"src=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Srcdoc(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("iframe")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"iframe" -> (
					Chrome( Some("20.0")),
					Edge(   None),
					Firefox(Some("25.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"srcdoc=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Srclang(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"track" -> (
					Chrome( Some("18.0")),
					Edge(   Some("10.0")),
					Firefox(Some("31.0")),
					Opera(  Some("15.0")),
					Safari( Some("6.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"srclang=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Srcset(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("img", "source")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"img" -> (
					Chrome( Some("38.0")),
					Edge(   Some("13.0")),
					Firefox(Some("38.0")),
					Opera(  Some("25.0")),
					Safari( Some("9.1"))
				),
				"source" -> (
					Chrome( Some("38.0")),
					Edge(   Some("13.0")),
					Firefox(Some("38.0")),
					Opera(  Some("25.0")),
					Safari( Some("9.1"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"srcset=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Start(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("ol")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"ol" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"start=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Step(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"input" -> (
					Chrome( Some("6.0")),
					Edge(   Some("10.0")),
					Firefox(Some("16.0")),
					Opera(  Some("10.6")),
					Safari( Some("5.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"step=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Style(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"style=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Tabindex(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"tabindex=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Target(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "base", "form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"area" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"base" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"form" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"target=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class TitleAttr(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"title=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Translate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"Global Attributes" -> (
					Chrome( None),
					Edge(   None),
					Firefox(None),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"translate=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Type(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "button", "embed", "input", "link", "menu", "object", "script", "source", "style")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"a" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"embed" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"button" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"link" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"style" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"script" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"source" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("3.5")),
					Opera(  Some("10.5")),
					Safari( Some("4.0"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"type=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Usemap(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("img", "object")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( None),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  None),
					Safari( None)
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"usemap=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Value(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "input", "li", "meter", "option", "progress", "param")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"button" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("2.0")),
					Firefox(Some("1.0")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"li" -> (
					Chrome( Some("1.0")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("1.0")),
					Safari( Some("1.0"))
				),
				"meter" -> (
					Chrome( Some("8.0")),
					Edge(   Some("13.0")),
					Firefox(Some("6.0")),
					Opera(  Some("11.0")),
					Safari( Some("61.0"))
				),
				"option" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"progress" -> (
					Chrome( Some("8.0")),
					Edge(   Some("10.0")),
					Firefox(Some("16.0")),
					Opera(  Some("11.0")),
					Safari( Some("6.0"))
				),
				"param" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"value=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Width(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("canvas", "embed", "iframe", "img", "input", "object", "width")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"canvas" -> (
					Chrome( Some("4.0")),
					Edge(   Some("9.0")),
					Firefox(Some("2.0")),
					Opera(  Some("9.0")),
					Safari( Some("3.1"))
				),
				"embed" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"iframe" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"img" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"input" -> (
					Chrome( Some("1.0")),
					Edge(   Some("All")),
					Firefox(Some("16.0")),
					Opera(  Some("1.0")),
					Safari( Some("All"))
				),
				"object" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				),
				"width" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"width=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

class Wrap(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			Map(
				"textarea" -> (
					Chrome( Some("All")),
					Edge(   Some("All")),
					Firefox(Some("All")),
					Opera(  Some("All")),
					Safari( Some("All"))
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"wrap=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)
