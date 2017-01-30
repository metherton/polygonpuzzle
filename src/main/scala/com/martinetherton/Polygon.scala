package com.martinetherton

/**
  * Created by martin on 11/01/17.
  */
class Polygon(numberOfSides: Int) {

  val startOptions = for {
    x <- 0 to numberOfSides - 1
  } yield (x, 0)

  val nodes = for {
    x <- 0 to numberOfSides -1
    y <- 1 to numberOfSides - 1
  } yield (x, y)

  val permutations = nodes.permutations

//  println(startOptions)
//  permutations.foreach(p => println(p))

  val possibleSolutions = for {
    start <- startOptions
    permutation <- permutations
    solution = loop(permutation.toList.filterNot(p => doCheck(start, p)), start, List(start), List()) if (solution.size == numberOfSides)
  } yield solution

  //permutation.filterNot(p => !doCheck(start, p))

  println(possibleSolutions)

  def loop(possibleNodes: List[(Int,Int)], destination: (Int,Int), actions: List[(Int, Int)], angles: List[Double]): List[(Int,Int)] = actions.size match {
    case `numberOfSides` => if (angles.exists(p => p == (actions.head._2 - destination._2).toDouble / (actions.head._1 - destination._1))) List() else actions
    case _ => possibleNodes match {
      case Nil => List()
      case x :: xs => if (isValidAngle(x, actions.head, angles)) loop(getNewPermutations(xs, x), destination, x +: actions, getNewAngle(x, actions.head) +: angles) else List()
    }
  }

  def isValidAngle(newPoint: (Int, Int), oldPoint: (Int,Int), angles: List[Double]): Boolean =
    !angles.exists(l => l == (newPoint._2 - oldPoint._2).toDouble / (newPoint._1 - oldPoint._1))

  //loop(getNewPermutations(xs, x, List()), x +: actions, getNewAngle(x, actions.head) +: angles)

  def getNewAngle(newPoint: (Int, Int), oldPoint: (Int,Int)): Double = (oldPoint._2 - newPoint._2).toDouble / (oldPoint._1 - newPoint._1)
  def getNewPermutations(possibleNodes: List[(Int, Int)], newNode: (Int, Int)): List[(Int, Int)] = {
    val newNodes = possibleNodes.filterNot(p => doCheck(newNode, p))
    newNodes
  }

//  def sameAngle(newNode: (Int, Int), oldNode: (Int, Int), angles: List[Double]): Boolean =
//    val newAngle =


//  (p._2 - myp._2).toDouble / (p._1 - myp._1)

//  def solution() = println(pairs)


  def doCheck(p1: (Int, Int), p2: (Int, Int)) = {
    val first = p1._1 == p2._1
    val second =  p1._2 == p2._2
    first || second
  }

}
