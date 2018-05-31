package forms

import play.api.data.Form
import play.api.data.Forms._

object User {

  case class TestForm(name: String, kana: String)

  val testForm = Form(
    mapping(
      "name" -> nonEmptyText,
      "kana" -> nonEmptyText,
    )(TestForm.apply)(TestForm.unapply)
  )
}
