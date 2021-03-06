package model

import play.api.libs.json.{JsPath, Reads}
import play.api.libs.functional.syntax._


case class User(
  id:          String,
  displayName: String,
  mail:        Option[String]
)

object User {
  implicit val userReads: Reads[User] = (
    (JsPath \ "id").read[String] and
    (JsPath \ "displayName").read[String] and
    (JsPath \ "mail").readNullable[String]
  )(User.apply _)
}
