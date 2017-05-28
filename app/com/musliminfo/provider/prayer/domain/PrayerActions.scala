package com.musliminfo.provider.prayer.domain

import javax.inject.{Inject, Singleton}

import com.musliminfo.provider.prayer.data.datasource.PrayerDataSource
import com.musliminfo.provider.prayer.data.model.Prayer

import scala.concurrent.{ExecutionContext, Future}

/**
  * @author mSobhy on 5/28/17.
  */
@Singleton
class PrayerActions @Inject()(
                              prayerDataSource: PrayerDataSource,
                              implicit val executionContext: ExecutionContext
                            ) {
  def getPrayersForCity(cityName: String): Future[Option[Seq[Prayer]]] = {
    prayerDataSource.getPrayerForCity(cityName)
  }
}
