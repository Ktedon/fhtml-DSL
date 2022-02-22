package fhtml

trait Browser

// List of browsers that this library supports and
// earliest version numbers supported for a tag or attribute.
case class Chrome(
    earliestVersionSupported: Option[String]
) extends Browser

case class Edge(
    earliestVersionSupported: Option[String]
) extends Browser

case class Firefox(
    earliestVersionSupported: Option[String]
) extends Browser

case class Opera(
    earliestVersionSupported: Option[String]
) extends Browser

case class Safari(
    earliestVersionSupported: Option[String]
) extends Browser

// Array of browsers which contain their level of support for the attribute.
case class AttributeSupport(support: Map[String, (Chrome, Edge, Firefox, Opera, Safari)])

// Array of browsers which contain their level of support for the tag.
case class TagSupport(support: (Chrome, Edge, Firefox, Opera, Safari))
