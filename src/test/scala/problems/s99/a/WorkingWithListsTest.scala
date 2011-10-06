package problems
import org.junit.Assert._
import org.junit.Test
import answers.WorkingWithLists._

/** In Scala, lists are objects of type List[A], where A can be any type.
 *  Lists are effective for many recursive algorithms, because it's easy to add elements to the head of a list,
 *  and to get the tail of the list, which is everything but the first element.
 *
 *  The solutions to the problems in this section will be in objects named after the problems (P01, P02, etc.).
 *  You can compile the source files with scalac and thereafter use import to bring the functions into scope.
 *  Some of the problems can be solved easily by using imported solutions to previous problems.
 *
 *  In many cases, there's more than one reasonable approach. The files linked here may include multiple solutions,
 *  with all but one commented out.
 *  They'll also indicate whether there's a builtin method in Scala that accomplishes the task.
 */
class WorkingWithListsTest {
    @Test
    def `P01 (*) Find the last elment of a list` {
        assertEquals(5, last(List(1, 2, 3, 4, 5)))
        assertEquals("baz", last(List("foo", "bar", "baz")))
    }

    @Test
    def `P02 (*) Find the next to last element in a list` {
        assertEquals(4, penultimate(List(1, 2, 3, 4, 5)))
        assertEquals("bar", penultimate(List("foo", "bar", "baz")))
    }

    @Test
    def `P03 (*) Find the Nth element of a list` {
        assertEquals(1, nth(0, List(1, 2, 3, 4, 5)))
        assertEquals(3, nth(2, List(1, 2, 3, 4, 5)))
        assertEquals(5, nth(4, List(1, 2, 3, 4, 5)))
        assertEquals("bar", nth(2, List("foo", "bar", "baz")))
        assertEquals("baz", nth(3, List("foo", "bar", "baz")))
    }

    @Test
    def `P04 (*) Find the number of elements in a list` {
        assertEquals(5, size(List(1, 2, 3, 4, 5)))
        assertEquals(3, size(List("foo", "bar", "baz")))
        assertEquals(0, size(Nil))
    }

    @Test
    def `P05 (*) Reverse a list` {
        assertEquals(List(3, 2, 1), reverse(List(1, 2, 3)))
        assertEquals(List("baz", "bar", "foo"), reverse(List("foo", "bar", "baz")))
        assertEquals(Nil, reverse(Nil))
    }

    @Test
    def `P06 (*) Find out whether a list is a palindrome` {
        assertTrue(isPalindrome(Nil))
        assertTrue(isPalindrome(List(1)))
        assertTrue(isPalindrome(List(1, 1)))
        assertTrue(isPalindrome(List(1, 2, 1)))
        assertTrue(isPalindrome(List("Madam, I'm Adam")))
        assertTrue(isPalindrome(List("foo", "bar", "foo")))

        assertFalse(isPalindrome(List(1, 2)))
        assertFalse(isPalindrome(List("foo", "bar", "baz")))
    }

    @Test
    def `P07 (**) Flatten a nested list structure` {
        assertEquals(List(1, 2), flatten(List(List(1), List(2))))
        assertEquals(List(1, 2, 3), flatten(List(List(1), List(2), 3)))
        assertEquals(List(1, 2, 3), flatten(List(List(1, List(2, List(3))))))
    }

    @Test
    // If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
    def `P08 (**) Eliminate consecutive duplicates of list elements` {
        assertEquals(List(1, 2, 3), compress(List(1, 1, 1, 2, 2, 3, 3, 3, 3)))
        assertEquals(List("foo"), compress(List("foo", "foo")))
    }

    @Test
    // If a list contains repeated elements they should be placed in separate sublists.
    def `P09 (**) Pack consecutive duplicates of list elements into sublists` {
        assertEquals(List(List(1)), pack(List(1)))
        assertEquals(List(List(1, 1), List(2, 2)), pack(List(1, 1, 2, 2)))
        assertEquals(List(List(1), List(2)), pack(List(1, 2)))
        assertEquals(List(List("a", "a"), List("b", "b", "b"), List("c", "c", "c", "c")),
                        pack(List("a", "a", "b", "b", "b", "c", "c", "c", "c")))
    }

    @Test
    // Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
    def `P10 (*) Run-length encoding of a list` {
        assertEquals(List((1, 1)), encode(List(1)))
        assertEquals(List((3, 1)), encode(List(1, 1, 1)))
        assertEquals(List((3, 1), (2, 2)), encode(List(1, 1, 1, 2, 2)))
        assertEquals(List((1, "foo"), (3, "bar"), (2, "baz")), encode(List("foo", "bar", "bar", "bar", "baz", "baz")))
    }

    @Test
    // Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
    def `P11 (*) Modified run-length encoding` {
        assertEquals(List(1), encodeModified(List(1)))
        assertEquals(List((3, 1)), encodeModified(List(1, 1, 1)))
        assertEquals(List((3, 1), (2, 2)), encodeModified(List(1, 1, 1, 2, 2)))
        assertEquals(List("foo", (3, "bar"), (2, "baz")), encodeModified(List("foo", "bar", "bar", "bar", "baz", "baz")))
    }

    @Test
    // Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
    def `P12 (**) Decode a run-length encoded list` {
        assertEquals(List(1), decode(List((1, 1))))
        assertEquals(List(1, 1, 1), decode(List((3, 1))))
        assertEquals(List(1, 1, 1, 2, 2), decode(List((3, 1), (2, 2))))
        assertEquals(List("foo", "bar", "bar", "bar", "baz", "baz"), decode(List((1, "foo"), (3, "bar"), (2, "baz"))))
    }

    @Test
    // Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
    def `P13 (**) Run-length encoding of a list (direct solution)` {
        assertEquals(List((1, 1)), encodeDirect(List(1)))
        assertEquals(List((3, 1)), encodeDirect(List(1, 1, 1)))
        assertEquals(List((3, 1), (2, 2)), encodeDirect(List(1, 1, 1, 2, 2)))
        assertEquals(List((1, "foo"), (3, "bar"), (2, "baz")), encodeDirect(List("foo", "bar", "bar", "bar", "baz", "baz")))
    }

    @Test
    def `P14 (*) Duplicate the elements of a list.` {
        assertEquals(Nil, duplicate(Nil))
        assertEquals(List(1, 1, 2, 2), duplicate(List(1, 2)))
        assertEquals(List(1, 1, 2, 2, 2, 2), duplicate(List(1, 2, 2)))
        assertEquals(List("foo", "foo", "bar", "bar", "baz", "baz"), duplicate(List("foo", "bar", "baz")))
    }

    @Test
    def `P15 (**) Duplicate the elements of a list a given number of times.` {
        assertEquals(Nil, duplicateN(3, Nil))
        assertEquals(List(1, 1, 1, 2, 2, 2), duplicateN(3, List(1, 2)))
        assertEquals(List("foo", "bar", "baz"), duplicateN(1, List("foo", "bar", "baz")))
    }

    @Test
    def `P16 (**) Drop every Nth element from a list.` {
        assertEquals(Nil, drop(3, Nil))
        assertEquals(List(1, 2, 4, 5, 7), drop(3, List(1, 2, 3, 4, 5, 6, 7)))
        assertEquals(List(), drop(1, List(1, 2, 3)))
        assertEquals(List("a", "b", "d"), drop(3, List("a", "b", "c", "d")))
    }

    @Test
    // The length of the first part is given. Use a Tuple for your result.
    def `P17 (*) Split a list into two parts.` {
        assertEquals(List((), ()), split(3, List()))
        assertEquals(List((), ()), split(3, List()))
        assertEquals(List((), ()), split(1, List()))
        assertEquals(List((), ()), split(0, List()))
    }

    @Test
    // Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
    def `P18 (**) Extract a slice from a list.` {
        assertEquals(List(2, 3), slice(1, 3, List(1, 2, 3, 4, 5)))
        assertEquals(List('d, 'e, 'f, 'g), slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }

    @Test
    def `P19 (**) Rotate a list N places to the left.` {
        assertEquals(List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c), rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
        assertEquals(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i), rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }

    @Test
    // Return the list and the removed element in a Tuple. Elements are numbered from 0.
    def `P20 (*) Remove the Kth element from a list.` {
        assertEquals((List(2, 3), 1), removeAt(0, List(1, 2, 3)))
        assertEquals((List('a, 'c, 'd), 'b), removeAt(1, List('a, 'b, 'c, 'd)))
    }

    @Test
    def `P21 (*) Insert an element at a given position into a list.` {
        assertEquals(List('new), insertAt('new, 0, List()))
        assertEquals(List('a, 'new, 'b, 'c, 'd), insertAt('new, 1, List('a, 'b, 'c, 'd)))
    }

    @Test
    def `P22 (*) Create a list containing all integers within a given range.` {
        assertEquals(List(4, 5, 6, 7, 8, 9), range(4, 9))
    }

    @Test
    def `P22b (*) Create a list containing all integers within a given range.` {
        assertEquals(List(4, 5, 6, 7, 8, 9), (4 to 9))
        assertEquals(List(4, 5, 6, 7, 8), (4 until 9))
    }

    @Test
    // Hint: Use the solution to problem P20
    def `P23 (**) Extract a given number of randomly selected elements from a list.` {
        def test[A](howMany: Int, in: List[A]) {
            val result = randomSelect(howMany, in)
            assertEquals("For input " + howMany + " " + in, howMany, result.size)
            assertTrue("For input " + howMany + " " + in, result.toSet.subsetOf(in.toSet))
        }

        test(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
        test(2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
        test(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
    }

    @Test
    def `P24 (*) Lotto: Draw N different random numbers from the set 1..M.` {
        def test[A](n: Int, m: Int) {
            val result = lotto(n, m)
            assertEquals("For inputs n=" + n + ", m=" + m, n, result.size)
            result.foreach { it => assertTrue(it + " did not exist in the range to " + m + "!", (1 to m).contains(it)) }
        }

        test(5, 10)
        test(6, 49)
        test(7, 149)
    }

    @Test
    /** Hint: Use the solution of problem P23.
     */
    def `P25 (*) Generate a random permutation of the elements of a list.` {
        def test[A](original: List[A]) {
            val result = randomPermute(original)
            assertEquals(original.size, result.size)
            assertEquals(original.toSet, result.toSet)
        }

        test(List('a, 'b, 'c, 'd, 'e, 'f))
        test(List("foo", "bar", "baz"))
        test((10 to 100).toList)
    }

    @Test
    /** In how many ways can a committee of 3 be chosen from a group of 12 people?
     *  We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
     *  For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
     */
    def `P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.` {
        val result = combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
        assertEquals(220, result.size)
        assertTrue(result.contains(List('a, 'b, 'c)))
        assertTrue(result.contains(List('a, 'b, 'd)))
        assertTrue(result.contains(List('a, 'b, 'e)))
        assertTrue(result.contains(List('c, 'e, 'f)))
        assertTrue(result.contains(List('d, 'e, 'f)))
    }

    @Test
    /** In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
     */
    def `P27a (**) Group the elements of a set into disjoint subsets.` {
        val result = group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        assertEquals(33, result.size)
        assertTrue(result.contains(List(List("Aldo", "Beat"), List("Carla", "David", "Evi"), List("Flip", "Gary", "Hugo", "Ida"))))
        assertTrue(result.contains(List(List("Aldo", "Beat", "Carla"), List("David", "Evi"), List("Flip", "Gary", "Hugo", "Ida"))))
    }

    @Test
    /** Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
     *  You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
     */
    def `P27b (**) Group the elements of a set into disjoint subsets.` {
        val result = group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        assertEquals(33, result.size)
        assertTrue(result.contains(List(List("Aldo", "Beat"), List("Carla", "David"), List("Evi", "Flip", "Gary", "Hugo", "Ida"))))
        assertTrue(result.contains(List(List("Aldo", "Carla"), List("Beat", "David"), List("Evi", "Flip", "Gary", "Hugo", "Ida"))))
    }

    @Test
    /** We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the list according to their length.
     *  E.g. short lists first, longer lists later, or vice versa.
     *  Example:
     *
     *  scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
     *  res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
     */
    def `P28a (**) Sorting a list of lists according to length of sublists.` {
        val result = lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        assertEquals(List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)), result)
    }

    @Test
    /** Again, we suppose that a list contains elements that are lists themselves.
     *  But this time the objective is to sort the elements according to their length frequency;
     *  i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.
     *  Example:
     *
     *  scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
     *  res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
     *
     *  Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
     *  The third and fourth lists have length 3 and there are two list of this length.
     *  Finally, the last three lists have length 2. This is the most frequent length.
     */
    def `P28b (**) Sorting a list of lists according to length of sublists.` {
        val result = lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        assertEquals(List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n)), result)
    }
}