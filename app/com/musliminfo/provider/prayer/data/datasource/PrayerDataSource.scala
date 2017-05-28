package com.musliminfo.provider.prayer.data.datasource

import java.time.LocalDateTime

import com.musliminfo.provider.prayer.data.model.Prayer

import scala.concurrent.Future

/**
  * @author mSobhy on 5/28/17.
  */
class PrayerDataSource {
  val prayers: Seq[Prayer] = List(
    Prayer("Fajr", LocalDateTime.now()),
    Prayer("Duhr", LocalDateTime.now()),
    Prayer("Asr", LocalDateTime.now()),
    Prayer("Maghrib", LocalDateTime.now()),
    Prayer("Ishaa", LocalDateTime.now())
  )

  def getPrayerForCity(cityName: String): Future[Option[Seq[Prayer]]] = {
    Future.successful(
      Option.apply(prayers)
    )
  }
}
