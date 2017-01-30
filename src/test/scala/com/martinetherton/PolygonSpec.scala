package com.martinetherton

import org.scalatest.{Matchers, WordSpec}

/**
  * Created by martin on 11/01/17.
  */
class PolygonSpec extends WordSpec with Matchers {

//  "docheck from polygon" should {
//    "return true if same x coord" in {
//      val polygon = Polygon(3)
//      polygon.doCheck((1,2), (1,3)) shouldBe true
//      println("polygonpoints: " + polygon.points)
//    }
//  }
//
//  "creating polygon with 3 sides" should {
//    "set number of sides" in {
//      val polygon = Polygon(3)
//      println("polygonpoints: " + polygon.points)
//      polygon.points.size shouldEqual 4
//    }
//  }
//
//  "creating polygon with 4 sides" should {
//    "set number of sides" in {
//      val polygon = Polygon(4)
//      println("polygonpoints: " + polygon.points)
//      polygon.points.size shouldEqual 12
//    }
//  }

  "creating polygon with 6 sides" should {
    "set number of sides" in {
      val polygon = new Polygon(3)
 //     println(polygon.solution())
    }
  }


}
