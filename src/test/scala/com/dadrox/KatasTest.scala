package com.dadrox
import org.junit.Test
import org.junit.Assert._

class KatasTest {

    /**
   __        __         _    _                        _ _   _       _     _     _
   \ \      / /__  _ __| | _(_)_ __   __ _  __      _(_) |_| |__   | |   (_)___| |_ ___
    \ \ /\ / / _ \| '__| |/ / | '_ \ / _` | \ \ /\ / / | __| '_ \  | |   | / __| __/ __|
     \ V  V / (_) | |  |   <| | | | | (_| |  \ V  V /| | |_| | | | | |___| \__ \ |_\__ \
      \_/\_/ \___/|_|  |_|\_\_|_| |_|\__, |   \_/\_/ |_|\__|_| |_| |_____|_|___/\__|___/
                                     |___/
     */

    @Test
    def `P01 (*) Find the last elment of a list` {
        assertEquals(5, Katas.last(List(1, 2, 3, 4, 5)))
        assertEquals("baz", Katas.last(List("foo", "bar", "baz")))
    }

    @Test
    def `P02 (*) Find the next to last element in a list` {
        assertEquals(4, Katas.penultimate(List(1, 2, 3, 4, 5)))
        assertEquals("bar", Katas.penultimate(List("foo", "bar", "baz")))
    }

    @Test
    def `P03 (*) Find the Nth element of a list` {
        assertEquals(1, Katas.nth(0, List(1, 2, 3, 4, 5)))
        assertEquals(3, Katas.nth(2, List(1, 2, 3, 4, 5)))
        assertEquals(5, Katas.nth(4, List(1, 2, 3, 4, 5)))
        assertEquals("bar", Katas.nth(2, List("foo", "bar", "baz")))
        assertEquals("baz", Katas.nth(3, List("foo", "bar", "baz")))
    }

    @Test
    def `P04 (*) Find the number of elements in a list` {
        assertEquals(5, Katas.size(List(1, 2, 3, 4, 5)))
        assertEquals(3, Katas.size(List("foo", "bar", "baz")))
        assertEquals(0, Katas.size(::))
        assertEquals(0, Katas.size(Nil))
    }

    @Test
    def `P05 (*) Reverse a list` {
        assertEquals(List(3, 2, 1), Katas.reverse(List(1, 2, 3)))
        assertEquals(List("baz", "bar", "foo"), Katas.reverse(List("foo", "bar", "baz")))
        assertEquals(Nil, Katas.reverse(::))
    }

    @Test
    def `P06 (*) Find out whether a list is a palindrome` {
        assertTrue(Katas.isPalindrome(Nil))
        assertTrue(Katas.isPalindrome(List(1)))
        assertTrue(Katas.isPalindrome(List(1, 1)))
        assertTrue(Katas.isPalindrome(List(1, 2, 1)))
        assertTrue(Katas.isPalindrome(List("Madam, I'm Adam")))
        assertTrue(Katas.isPalindrome(List("foo", "bar", "foo")))

        assertFalse(Katas.isPalindrome(List(1, 2)))
        assertFalse(Katas.isPalindrome(List("foo", "bar", "baz")))
    }

    @Test
    def `P07 (**) Flatten a nested list structure` {
        assertEquals(List(1, 2), Katas.flatten(List(List(1), List(2))))
        assertEquals(List(1, 2, 3), Katas.flatten(List(List(1), List(2), 3)))
        assertEquals(List(1, 2, 3), Katas.flatten(List(List(1, List(2, List(3))))))
    }

    @Test
    // If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
    def `P08 (**) Eliminate consecutive duplicates of list elements` {
        assertEquals(List(1, 2, 3), Katas.compress(List(1, 1, 1, 2, 2, 3, 3, 3, 3)))
        assertEquals(List("foo"), Katas.compress(List("foo", "foo")))
    }

    @Test
    // If a list contains repeated elements they should be placed in separate sublists.
    def `P09 (**) Pack consecutive duplicates of list elements into sublists` {
        assertEquals(List(List(1)),
                        Katas.pack(List(1)))
        assertEquals(List(List(1, 1), List(2, 2)),
                        Katas.pack(1, 1, 2, 2))
        assertEquals(List(List(1), List(2)),
                        Katas.pack(List(1, 2)))
        assertEquals(List(List("a", "a"), List("b", "b", "b"), List("c", "c", "c", "c")),
                        Katas.pack(List("a", "a", "b", "b", "b", "c", "c", "c", "c")))
    }

    @Test
    // Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
    def `P10 (*) Run-length encoding of a list` {
        assertEquals(List((1, 1)), Katas.encode(List(1)))
        assertEquals(List((3, 1)), Katas.encode(List(1, 1, 1)))
        assertEquals(List((3, 1), (2, 2)), Katas.encode(List(1, 1, 1, 2, 2)))
        assertEquals(List((1, "foo"), (3, "bar"), (2, "baz")), Katas.encode(List("foo", "bar", "bar", "bar", "baz", "baz")))
    }

    @Test
    // Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
    def `P11 (*) Modified run-length encoding` {
        assertEquals(List(1), Katas.encodeModified(List(1)))
        assertEquals(List((3, 1)), Katas.encodeModified(List(1, 1, 1)))
        assertEquals(List((3, 1), (2, 2)), Katas.encodeModified(List(1, 1, 1, 2, 2)))
        assertEquals(List("foo", (3, "bar"), (2, "baz")), Katas.encodeModified(List("foo", "bar", "bar", "bar", "baz", "baz")))
    }

    @Test
    // Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
    def `P12 (**) Decode a run-length encoded list` {
        assertEquals(List(1), Katas.decode(List((1, 1))))
        assertEquals(List(1, 1, 1), Katas.decode(List((3, 1))))
        assertEquals(List(1, 1, 1, 2, 2), Katas.decode(List((3, 1), (2, 2))))
        assertEquals(List("foo", "bar", "bar", "bar", "baz", "baz"), Katas.decode(List((1, "foo"), (3, "bar"), (2, "baz"))))
    }

    @Test
    // Implement the so-called run-length encoding data compression method directly. I.e. don't use other methods you've written (like P09's pack); do all the work directly.
    def `P13 (**) Run-length encoding of a list (direct solution)` {
        assertEquals(List((1, 1)), Katas.encodeDirect(List(1)))
        assertEquals(List((3, 1)), Katas.encodeDirect(List(1, 1, 1)))
        assertEquals(List((3, 1), (2, 2)), Katas.encodeDirect(List(1, 1, 1, 2, 2)))
        assertEquals(List((1, "foo"), (3, "bar"), (2, "baz")), Katas.encodeDirect(List("foo", "bar", "bar", "bar", "baz", "baz")))
    }

    @Test
    def `P14 (*) Duplicate the elements of a list.` {
        assertEquals(Nil, Katas.duplicate(Nil))
        assertEquals(List(1, 1, 2, 2), Katas.duplicate(List(1, 2)))
        assertEquals(List(1, 1, 2, 2, 2, 2), Katas.duplicate(List(1, 2, 2)))
        assertEquals(List("foo", "foo", "bar", "bar", "baz", "baz"), Katas.duplicate(List("foo", "bar", "baz")))
    }

    @Test
    def `P15 (**) Duplicate the elements of a list a given number of times.` {
        assertEquals(Nil, Katas.duplicateN(3, Nil))
        assertEquals(List(1, 1, 1, 2, 2, 2), Katas.duplicateN(3, List(1, 2)))
        assertEquals(List("foo", "bar", "baz"), Katas.duplicateN(1, List("foo", "bar", "baz")))
    }

    @Test
    def `P16 (**) Drop every Nth element from a list.` {
        assertEquals(Nil, Katas.drop(3, Nil))
        assertEquals(List(1, 2, 4, 5, 7), Katas.drop(3, List(1, 2, 3, 4, 5, 6, 7)))
        assertEquals(List(), Katas.drop(1, List(1, 2, 3)))
        assertEquals(List("a", "b", "d"), Katas.drop(3, List("a", "b", "c", "d")))
    }

    @Test
    // The length of the first part is given. Use a Tuple for your result.
    def `P17 (*) Split a list into two parts.` {
        assertEquals(List((), ()), Katas.split(3, List()))
        assertEquals(List((), ()), Katas.split(3, List()))
        assertEquals(List((), ()), Katas.split(1, List()))
        assertEquals(List((), ()), Katas.split(0, List()))
    }

    @Test
    // Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
    def `P18 (**) Extract a slice from a list.` {
        assertEquals(List(2, 3), Katas.slice(1, 3, List(1, 2, 3, 4, 5)))
        assertEquals(List('d, 'e, 'f, 'g), Katas.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }

    @Test
    def `P19 (**) Rotate a list N places to the left.` {
        assertEquals(List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c), Katas.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
        assertEquals(List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i), Katas.rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    }

    @Test
    // Return the list and the removed element in a Tuple. Elements are numbered from 0.
    def `P20 (*) Remove the Kth element from a list.` {
        assertEquals((List(2, 3), 1), Katas.removeAt(0, List(1, 2, 3)))
        assertEquals((List('a, 'c, 'd), 'b), Katas.removeAt(1, List('a, 'b, 'c, 'd)))
    }

    @Test
    def `P21 (*) Insert an element at a given position into a list.` {
        assertEquals(List('new), Katas.insertAt('new, 0, List()))
        assertEquals(List('a, 'new, 'b, 'c, 'd), Katas.insertAt('new, 1, List('a, 'b, 'c, 'd)))
    }

    @Test
    def `P22 (*) Create a list containing all integers within a given range.` {
        assertEquals(List(4, 5, 6, 7, 8, 9), Katas.range(4, 9))
    }

    @Test
    // Hint: Use the solution to problem P20
    def `P23 (**) Extract a given number of randomly selected elements from a list.` {
        // TODO random, how to create a test for this?
        assertEquals(List('e, 'd, 'a), Katas.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
        assertEquals(List('e, 'd, 'a), Katas.randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
    }

    @Test
    def `P24 (*) Lotto: Draw N different random numbers from the set 1..M.` {
        // TODO random, how to create a test for this?
        assertEquals(List(23, 1, 17, 33, 21, 37), Katas.lotto(6, 49))
    }

    @Test
    /** Hint: Use the solution of problem P23.
     */
    def `P25 (*) Generate a random permutation of the elements of a list.` {
        // TODO random, how to create a test for this?
        assertEquals(List('b, 'a, 'd, 'c, 'e, 'f), Katas.randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
    }

    @Test
    /** In how many ways can a committee of 3 be chosen from a group of 12 people?
     * We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
     * For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
     */
    def `P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.` {
        val result = Katas.combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
        assertEquals(220, result.size)
        assertTrue(result.contains(List('a, 'b, 'c)))
        assertTrue(result.contains(List('a, 'b, 'd)))
        assertTrue(result.contains(List('a, 'b, 'e)))
        assertTrue(result.contains(List('c, 'e, 'f)))
        assertTrue(result.contains(List('d, 'e, 'f)))
    }

    @Test
    /**
     * a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
        Example:

        scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...

       b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
        Example:

        scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
        Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...). However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).

        You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
     */
    def `P27a (**) Group the elements of a set into disjoint subsets.` {
        val result = Katas.group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        assertEquals(33, result.size)
        assertTrue(result.contains(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)))
        assertTrue(result.contains(List(List(Aldo, Beat, Carla), List(David, Evi), List(Flip, Gary, Hugo, Ida)))
    }

    def `P27b (**) Group the elements of a set into disjoint subsets.` {
        val result = Katas.group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        assertEquals(33, result.size)
        assertTrue(result.contains(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)))
        assertTrue(result.contains(List(List(Aldo, Carla), List(Beat, David), List(Evi, Flip, Gary, Hugo, Ida)))
    }

    @Test
    /**
     * a) We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the list according to their length.
        E.g. short lists first, longer lists later, or vice versa.
        Example:

        scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))

       b) Again, we suppose that a list contains elements that are lists themselves.
        But this time the objective is to sort the elements according to their length frequency;
        i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.
        Example:

        scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

        Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
        The third and fourth lists have length 3 and there are two list of this length.
        Finally, the last three lists have length 2. This is the most frequent length.
     */
    def `P28a (**) Sorting a list of lists according to length of sublists.` {
        val result = Katas.lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        assertEquals(List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)), result)
    }

    def `P28b (**) Sorting a list of lists according to length of sublists.` {
        val result = Katas.lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        assertEquals(List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n)), result)
    }

    /**
    _         _ _   _                    _   _
   / \   _ __(_) |_| |__  _ __ ___   ___| |_(_) ___
  / _ \ | '__| | __| '_ \| '_ ` _ \ / _ \ __| |/ __|
 / ___ \| |  | | |_| | | | | | | | |  __/ |_| | (__
/_/   \_\_|  |_|\__|_| |_|_| |_| |_|\___|\__|_|\___|

     */

    @Test
    def `P31 (**) Determine whether a given integer number is prime.` {
        assertTrue(2.isPrime)
        assertTrue(7.isPrime)
        assertTrue(101.isPrime)
        assertTrue(31337.isPrime)
        assertFalse(4,isPrime)
        assertFalse(42,isPrime)
        assertFalse(333,isPrime)
    }

    @Test
    // Use Euclid's algorithm.
    def `P32 (**) Determine the greatest common divisor of two positive integer numbers.` {
        assertEquals(9, gcd(36, 63))
        assertEquals(12, gcd(12, 24))
        assertEquals(1, gcd(51, 101))
    }

    @Test
    /** Two numbers are coprime if their greatest common divisor equals 1.
     */
    def `P33 (*) Determine whether two positive integer numbers are coprime.` {
        assertTrue(35.isCoprimeTo(64))
        assertTrue(51.isCoprimeTo(101))
        assertTrue(111.isCoprimeTo(1024))
    }

    @Test
    /** Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
     */
    def `P34 (**) Calculate Euler's totient function phi(m).` {
    }

    @Test
    /** Construct a flat list containing the prime factors in ascending order.
     */
    def `P35 (**) Determine the prime factors of a given positive integer.` {
    }

    @Test
    /** Construct a list containing the prime factors and their multiplicity.
     */
    def `P36 (**) Determine the prime factors of a given positive integer (2).` {
    }

    @Test
    /**
     */
    def `P37 (**) Calculate Euler's totient function phi(m) (improved).` {
    }

    @Test
    /** Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example.
     */
    def `P38 (*) Compare the two methods of calculating Euler's totient function.` {
    }

    @Test
    /** Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
     */
    def `P39 (*) A list of prime numbers.` {
    }

    @Test
    /**
    Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
    E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
    It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
    Write a function to find the two prime numbers that sum up to a given even integer.

    scala> 28.goldbach
    res0: (Int, Int) = (5,23)
     */
    def `P40 (**) Goldbach's conjecture.` {
    }

    @Test
    /**
    Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
    scala> printGoldbachList(9 to 20)
    10 = 3 + 7
    12 = 5 + 7
    14 = 3 + 11
    16 = 3 + 13
    18 = 5 + 13
    20 = 3 + 17
    In most cases, if an even number is written as the sum of two prime numbers, one of them is very small. Very rarely, the primes are both bigger than, say, 50. Try to find out how many such cases there are in the range 2..3000.

    Example (minimum value of 50 for the primes):

    scala> printGoldbachListLimited(1 to 2000, 50)
    992 = 73 + 919
    1382 = 61 + 1321
    1856 = 67 + 1789
    1928 = 61 + 1867
     */
    def `P41 (**) A list of Goldbach compositions.` {
    }

//    @Test
//    def `` {
//    }






















}