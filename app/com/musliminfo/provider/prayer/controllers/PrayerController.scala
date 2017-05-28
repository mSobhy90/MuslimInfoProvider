package com.musliminfo.provider.prayer.controllers

import javax.inject._

import com.musliminfo.provider.prayer.data.model.Prayer
import com.musliminfo.provider.prayer.domain.PrayerActions
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

/**
  * This controller all `Actions` related to prayer (schedules, special prayers, etc...).
  */
@Singleton
class PrayerController @Inject()(prayerActions: PrayerActions)(implicit val executionContext: ExecutionContext) extends Controller {

  def getPrayerSchedule(cityName: String): Action[AnyContent] = Action.async {
    _ => {
      Logger.debug("Get prayer schedule for city " + cityName)
      val optionalPrayerFuture: Future[Option[Seq[Prayer]]] = prayerActions.getPrayersForCity(cityName)
      optionalPrayerFuture.map(
        optionalPrayer => {
          Logger.debug(optionalPrayer.toString)
          optionalPrayer match {
            case Some(foundPrayer) => Results.Ok(Json.toJson(foundPrayer))
            case None => Results.NotFound
          }
        }
      )
    }
  }
}
