package exercises.ch2

object Curry extends App {

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a, b)

  type Age = Int
  type Name = String

  class Person(val age: Age, val name: Name) {
    override def toString() = s"$name is $age years old"
    override def equals(other: Any): Boolean = other match {
      case that: Person =>
        (other.isInstanceOf[Person]) &&
          age == that.age &&
          name == that.name
      case _ => false
    }

    override def hashCode(): Int = {
      val state = Seq(age, name)
      state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
    }
  }

  object Person {
    def apply(age: Age, name: Name): Person = new Person(age, name)
  }

  val person1 = Person(27, "Jay")

  val partialPerson = curry[Age, Name, Person](Person.apply)

  println(partialPerson(27)("Jay"))
}
