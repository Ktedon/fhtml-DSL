package fhtml

import fhtml.attributes.*

object TagUtils:
  def getWarning(tagName: String)(attributes: Attribute*): Unit =
    println(fansi.Color.Green(s"$tagName tag info:"))
    attributes.foreach { attr =>
      println((" "*4) ++ s"\"${attr.getClass.getSimpleName}\" attribute information:")
      if (attr.browserSupport.support.keys.filter(_ == tagName).nonEmpty && attr.getWarning == true)
        val browsers: (Chrome, Edge, Firefox, Opera, Safari) = attr.browserSupport.support("doctype")
        println((" "*10) ++ s"""${fansi.Color.Yellow("Earliest Google Chrome Version Support:   ") ++
            (browsers._1.earliestVersionSupported match
                case "" => fansi.Color.Red("No Support")
                case o => fansi.Color.Green(o))
          }
          ${fansi.Color.Yellow("Earliest Microsoft Edge Version Support:  ") ++
            (browsers._2.earliestVersionSupported match
                case "" => fansi.Color.Red("No Support")
                case o => fansi.Color.Green(o))
          }
          ${fansi.Color.Yellow("Earliest Mozilla Firefox Version Support: ") ++
            (browsers._3.earliestVersionSupported match
                case "" => fansi.Color.Red("No Support")
                case o => fansi.Color.Green(o))
          }
          ${fansi.Color.Yellow("Earliest Opera Version Support:           ") ++
            (browsers._4.earliestVersionSupported match
                case "" => fansi.Color.Red("No Support")
                case o => fansi.Color.Green(o))
          }
          ${fansi.Color.Yellow("Earliest Apple Safari Version Support:    ") ++
            (browsers._5.earliestVersionSupported match
                case "" => fansi.Color.Red("No Support")
                case o => fansi.Color.Green(o))
          }\n""")
      else if (attr.getWarning == true)
        println(fansi.Color.Red((" "*10) ++ s"The $tagName tag does not support the \"${attr.getClass.getSimpleName}\" attribute\n"))
    }


trait HTMLTag:
  def getTag: String

  val tagSupport: TagSupport



