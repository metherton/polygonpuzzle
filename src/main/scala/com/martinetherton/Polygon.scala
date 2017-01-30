package com.martinetherton

/**
  * Created by martin on 11/01/17.
  */
class Polygon(numberOfSides: Int) {

  var counter = 0

  val tempStartOptions = for {
    x <- 0 to numberOfSides - 1
  } yield (x, 0)

  val startOptions = tempStartOptions.filter(o => if (numberOfSides % 2 == 0) o._1 < numberOfSides / 2 else o._1  < numberOfSides / 2 + 1)

  val nodes = for {
    x <- 0 to numberOfSides -1
    y <- 1 to numberOfSides - 1
  } yield (x, y)

  val permutations = nodes.permutations.map(p => p.toVector).toVector

  println(permutations)

  val possibleSolutions = for {
    start <- startOptions
    permutation <- permutations
    solution = loop(permutation.toVector.filterNot(p => doCheck(start, p)), start, Vector(start), Vector()) if (solution.size == numberOfSides)
  } yield solution

//  val possibleSolutions = for {
//    start <- startOptions
//    permutation <- permutations
//   // bla = (permutation, start)
//  //  solution = loop(permutation.toVector.filterNot(p => doCheck(start, p)), start, Vector(start), Vector()) if (solution.size == numberOfSides)
//  } yield (start, permutation)

  //permutation.filterNot(p => !doCheck(start, p))

  println(possibleSolutions.distinct)

  def loop(possibleNodes: Vector[(Int,Int)], destination: (Int,Int), actions: Vector[(Int, Int)], angles: Vector[Double]): Vector[(Int,Int)] = actions.size match {
    case `numberOfSides` => if (angles.exists(p => p == (actions.head._2 - destination._2).toDouble / (actions.head._1 - destination._1))) Vector() else actions
    case _ => possibleNodes match {
      case Vector() => Vector()
      case x +: xs => if (isValidAngle(x, actions.head, angles)) loop(getNewPermutations(xs, x, destination), destination, x +: actions, getNewAngle(x, actions.head) +: angles) else Vector()
    }
  }

  def isValidAngle(newPoint: (Int, Int), oldPoint: (Int,Int), angles: Vector[Double]): Boolean =
    !angles.exists(l => l == (newPoint._2 - oldPoint._2).toDouble / (newPoint._1 - oldPoint._1))

  //loop(getNewPermutations(xs, x, List()), x +: actions, getNewAngle(x, actions.head) +: angles)

  def getNewAngle(newPoint: (Int, Int), oldPoint: (Int,Int)): Double = (oldPoint._2 - newPoint._2).toDouble / (oldPoint._1 - newPoint._1)
  def getNewPermutations(possibleNodes: Vector[(Int, Int)], newNode: (Int, Int), d: (Int,Int)): Vector[(Int, Int)] = {
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
