package exercises.ch2

object IsSorted extends App {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(a: Int, b: Int): Boolean =
      if (as.length <= b) true
      else if (ordered(as(a), as(b)) == true) loop(a + 1, b + 1)
      else false

    loop(0, 1)
  }

  def intOrdering(a: Int, b: Int) = a < b

  val arrayOfInts = Array(2, 3, 4, 1)

  println(isSorted[Int](arrayOfInts, intOrdering))

}
