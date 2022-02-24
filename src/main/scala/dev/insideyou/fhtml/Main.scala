package fhtml

import fhtml.*
import fhtml.attributes.*

object Main extends App:
  println("")

  val markup = 
    Doctype.w(Html())(
      HtmlT(Accept :* "hello")(
        Body.w(Spellcheck())(
          H1(Plaintext("The main element")),
          MainT(
            H1(Plaintext("Most Popular Browsers")),
            P(Plaintext("Chrome, Firefox, and Edge are the most used browsers today.")),
            Article(
              H2(Plaintext("Google Chrome")),
              P(Plaintext("Google Chrome is a web browser developed by Google, released in 2008. Chrome is the world's most popular web browser today!"))
            ),
            Article(
              H2(Plaintext("Mozilla Firefox")),
              P(Plaintext("Mozilla Firefox is an open-source web browser developed by Mozilla. Firefox has been the second most popular web browser since January, 2018."))
            ),
            Article(
              H2(Plaintext("Microsoft Edge")),
              P(Plaintext("Microsoft Edge is a web browser developed by Microsoft, released in 2015. Microsoft Edge replaced Internet Explorer."))
            )
          )
        )
      )
    )

  // println(markup.getTag)

  