package com.martinetherton

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by martin on 11/01/17.
  */
class PolygonSpec extends WordSpec with Matchers {

  "creating polygon" should {
    "set number of sides" in {
      val polygon = Polygon(3)
      polygon.numberOfSides shouldEqual 3
    }
  }

}
