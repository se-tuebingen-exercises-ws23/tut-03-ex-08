//////////////////////////////  PART 1  //////////////////////////////

// As seen in Homework 5,
// a value of type ListOfInts is:
// - either Cons(item: Int, next: ListOfInts)
// - or Empty()
sealed trait ListOfInts
case class Cons(item: Int, next: ListOfInts) extends ListOfInts
case class Empty() extends ListOfInts

// Here are some lists you can test with:
val testEmptyList: ListOfInts = Empty()
val testSingletonList: ListOfInts = Cons(1, Empty())
val testLargerList: ListOfInts = Cons(1, Cons(2, Cons(3, Empty())))

// Precondition: The input is not null.
def nonempty(list: ListOfInts): Boolean = {
  // TODO: Notice that the precondition is never checked.
  // Run `sbt console` in the terminal and then call `nonempty(null)`. What happens?
  //
  // Now uncomment the following line and try again the above:
  // require(list != null)
  list match
    case Cons(_, _) => true
    case Empty()    => false
}

// Postcondition: The output is a non-negative number.
def length(list: ListOfInts): Int = {
  require(list != null)
  list match
    case Cons(_, xs) => 1 + length(xs)
    case Empty()     => 0
}
// TODO: Notice that the postcondition is never checked.
// Try changing the `0` to `-42` and then call `nonempty(testEmptyList)`.
// What happens? [Don't forget to change it back afterwards!]
//
// Now add the following code after the final `}` delimiting the function and try again the above:
// ensuring { res => 0 <= res }

// TODO:
// Whose fault is it when a precondition is not satisfied? The user of the function or the implementor of the function?
// Whose fault is it when a postcondition is not satisfied? The user of the function or the implementor of the function?
// [Terminology: User = caller of the function, implementor = writer of the function; end user = user of the program]
//
// Decide if it's a bigger problem when a precondition is not satisfied or if it's a bigger problem when a postcondition is not satisfied.

//////////////////////////////  PART 2  //////////////////////////////

// TODO:
// Write down the preconditions and postconditions of the following functions as comments.
// Analyze the preconditions and postconditions of the following equivalent functions.
// Compare myHead and myHeadOption. Which one has a weaker precondition? Which one has a stronger postcondition?
// Then compare myTail and myTailOption.

def myHead(list: ListOfInts): Int = {
  require(list != null && nonempty(list))
  (list: @unchecked) match // TODO: The `@unchecked` tells Scala to ignore that we're not matching on all cases. Why is that always safe here?
    case Cons(x, _) => x
}

def myHeadOption(list: ListOfInts): Option[Int] = {
  require(list != null)
  list match
    case Cons(x, _) => Some(x)
    case Empty()    => None
} ensuring { (res: Option[Int]) =>
  if (nonempty(list)) { !res.isEmpty }
  else { res.isEmpty }
}

def myTail(list: ListOfInts): ListOfInts = {
  require(list != null && nonempty(list))
  (list: @unchecked) match
    case Cons(_, xs) => xs
} ensuring { res => length(res) + 1 == length(list) }
// TODO: Try introducing a mistake in the postcondition above.
//       Then test out with the provided lists.

def myTailOption(list: ListOfInts): Option[ListOfInts] = {
  require(list != null)
  list match
    case Cons(_, xs) => Some(xs)
    case Empty()     => None
} ensuring { res =>
  if (nonempty(list)) { !res.isEmpty && length(res.get) + 1 == length(list) }
  else { res.isEmpty }
}

// TODO: In `myTailOption`, try returning `None` in the `Cons(...)` case.
// Then test the function on the provided lists.
// Afterwards, find the part of the contract which caught the introduced problem.

// TODO:
// Program the following functions, don't forget to specify their contracts (preconditions and postconditions),
// as for us, they're a part of the 'Signatur' you know from the 'Entwurfsrezept' from Info 1 (you can find it in the README).
// Go according to the Entwurfsrezept, i.e. first write down the signature with contracts as comment, then the contracts as code, then the function body, etc.
//
// Remember to not use `return` in code blocks followed by `ensuring` - just leave the value.
//
// - `revenue` which gets a ticket price and number of attendees to a theater and returns the total revenue
// - `areaOfSquare` which calculates the area of a square

//////////////////////////////  PART 3  //////////////////////////////

// Now let's create a 'Stack' data structure:
class Stack {
  private var list: List[String] = List()

  // We use 'invariant' to 'assert' things which should *always* hold for our data structure
  // (similarly to `check-expect` from Info 1, but `assert` only works when called in a function or in a method)
  private def invariant(): Unit = {
    assert(list != null) // 'list' should never be null
  }

  // You can use this to verify that a method doesn't change the 'list'.
  def unchanged[A](block: => A): A = {
    val listBefore = list
    val result = block // <-- The 'block' is called and evaluated here.
    assert(listBefore == list, "This method should not change the list!")
    result
  }

  def size(): Int = unchanged {
    val result = list.length
    // list = list.appended("1")
    // TODO: Uncomment the line above and test 'Stack().size()' in the 'sbt console'
    // [Don't forget to change it back afterwards!]
    result
  } ensuring { res => res >= 0 }

  // TODO: Create a method 'isEmpty'. Ensure that it does not change the 'list'.
  def isEmpty(): Boolean = ??? // Note: `???` is a placeholder like `...` in BSL/Racket

  // TODO: Create this wrapper which checks that the size increased by one.
  def sizeIncreasedByOne[A](block: => A): A = {
    val sizeBefore = ???
    val result = block
    assert(??? == size(), "This method should increase the size by one!")
    result
  }

  // TODO: Create a contract for the 'push' method which adds an element on top of the stack.
  //
  // Encode the following pre/post-conditions:
  // - require that the elem is not null
  // - ensure that the size increases by one (use 'sizeIncreasedByOne')
  // - ensure that the Stack is not empty
  // - check the invariant holds (call the 'invariant()' function at the end of the function)
  //
  // BONUS: ensure that the rest of the stack didn't change
  // (you might need something like 'unchanged' and 'sizeIncreasedByOne' for that.
  def push(elem: String): Unit = {
    list = elem :: list
  }

  // We check the invariant once when constructing the object:
  invariant()
}

@main
def main() =
  println("Please, run 'sbt console' instead.")
