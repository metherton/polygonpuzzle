import com.martinetherton.Polygon

object Test {
  val p = for {
    i <- 1 to 10
    j <- 1 to 5
    k = i * j
  } yield k
  println(p)
}
