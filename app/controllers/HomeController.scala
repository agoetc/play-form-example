package controllers

import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents, messagesAction: MessagesActionBuilder) extends AbstractController(cc) {

  def index = Action { implicit request =>
    Ok(views.html.index())
  }

  def post = messagesAction { implicit request =>
    import forms.User.testForm

    val jsonOpt = request.body.asJson
    jsonOpt match {
      case Some(json) =>
        testForm.bind(json).fold(
          errors => BadRequest(errors.errorsAsJson),
          form => Ok
        )
      case None =>
        BadRequest
    }
  }

}

