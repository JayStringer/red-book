package exercises.ch2

object RecFib extends App {

  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(a: Int, b: Int, iter: Int): Int = {
      if (iter == n) a
      else loop(b, a + b, iter + 1)
    }

    loop(0, 1, 1)
  }

  println(fib(5))

  // 0, 1, 1, 2, 3, 5, 8, 13, 21
}
