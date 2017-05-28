package com.musliminfo.provider.prayer.data.model

import java.time.LocalDateTime

import play.api.libs.json.{Json, OFormat, OWrites, Reads}

/**
  * @author mSobhy on 5/28/17.
  */
case class Prayer(
                   prayerName: String,
                   prayerTime: LocalDateTime
                 )


object Prayer {
  implicit val formatPrayer: OFormat[Prayer] = Json.format[Prayer]
  implicit val readsPrayer: Reads[Prayer] = Json.reads[Prayer]
  implicit val writesPrayer: OWrites[Prayer] = Json.writes[Prayer]
}