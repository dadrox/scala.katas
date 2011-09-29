package com.dadrox
import org.junit.Test
import org.junit.Assert._
import org.junit.Ignore

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
     *  We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
     *  For pure mathematicians, this result may be great. But we want to really generate all the possibilities.
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
    /** In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.
     */
    def `P27a (**) Group the elements of a set into disjoint subsets.` {
        val result = Katas.group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        assertEquals(33, result.size)
        assertTrue(result.contains(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida))))
        assertTrue(result.contains(List(List(Aldo, Beat, Carla), List(David, Evi), List(Flip, Gary, Hugo, Ida))))
    }

    @Test
    /** Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
     *  You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
     */
    def `P27b (**) Group the elements of a set into disjoint subsets.` {
        val result = Katas.group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
        assertEquals(33, result.size)
        assertTrue(result.contains(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida))))
        assertTrue(result.contains(List(List(Aldo, Carla), List(Beat, David), List(Evi, Flip, Gary, Hugo, Ida))))
    }

    @Test
    /** We suppose that a list contains elements that are lists themselves. The objective is to sort the elements of the list according to their length.
        E.g. short lists first, longer lists later, or vice versa.
        Example:

        scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
     */
    def `P28a (**) Sorting a list of lists according to length of sublists.` {
        val result = Katas.lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        assertEquals(List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)), result)
    }

    @Test
    /** Again, we suppose that a list contains elements that are lists themselves.
        But this time the objective is to sort the elements according to their length frequency;
        i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed, others with a more frequent length come later.
        Example:

        scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
        res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

        Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
        The third and fourth lists have length 3 and there are two list of this length.
        Finally, the last three lists have length 2. This is the most frequent length.
     */
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
        assertFalse(3, 6)
        assertFalse(32, 128)
        assertFalse(555, 10305)
    }

    @Test
    /** Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
     */
    def `P34 (**) Calculate Euler's totient function phi(m).` {
        assertEquals(4, 10.totient) // 1, 3, 7, 9
        assertEquals(2, 11.totient) // 1, 11
        assertEquals(4, 12.totient) // 1, 5, 7, 11
    }

    @Test
    /** Construct a flat list containing the prime factors in ascending order.
     */
    def `P35 (**) Determine the prime factors of a given positive integer.` {
        assertEquals(List(2), 2.primeFactors)
        assertEquals(List(2, 3, 7), 42.primeFactors)
        assertEquals(List(3, 3, 5, 7), 315.primeFactors)
    }

    @Test
    /** Construct a list containing the prime factors and their multiplicity.
     */
    def `P36 (**) Determine the prime factors of a given positive integer (2).` {
        assertEquals(List((2, 1), (3, 1), (7, 1)), 42.primeFactorMultiplicity)
        assertEquals(List((3,2), (5,1), (7,1)), 315.primeFactorMultiplicity)
        assertEquals(List((2, 10)), 256.primeFactorMultiplicity)
    }

    @Test
    def `P37 (**) Calculate Euler's totient function phi(m) (improved).` {
        // TODO
    }

    @Test
    /** Use the solutions of problems P34 and P37 to compare the algorithms. Try to calculate phi(10090) as an example.
     */
    def `P38 (*) Compare the two methods of calculating Euler's totient function.` {
        // TODO
    }

    @Test
    /** Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
     */
    def `P39 (*) A list of prime numbers.` {
        assertEquals(List(1, 2, 3), Katas.listPrimesinRange(1 until 5))
        assertEquals(List(1, 2, 3, 5), Katas.listPrimesinRange(1 to 5))
        assertEquals(List(7, 11, 13, 17, 19, 23, 29, 31), Katas.listPrimesinRange(7 to 31))
    }

    @Test
    /** Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
        E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
        It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
        Write a function to find the two prime numbers that sum up to a given even integer.
     */
    def `P40 (**) Goldbach's conjecture.` {
        assertEquals((3, 3), 6.goldbach)
        assertEquals((3, 5), 8.goldbach)
        assertEquals((5, 7), 12.goldbach)
        assertEquals((5, 23), 28.goldbach)
    }

    @Test
    /** Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
        scala> printGoldbachList(9 to 20)
        10 = 3 + 7
        12 = 5 + 7
        14 = 3 + 11
        16 = 3 + 13
        18 = 5 + 13
        20 = 3 + 17
        In most cases, if an even number is written as the sum of two prime numbers, one of them is very small. Very rarely, the primes are both bigger than, say, 50.
         Try to find out how many such cases there are in the range 2..3000.

        Example (minimum value of 50 for the primes):

        scala> printGoldbachListLimited(1 to 2000, 50)
        992 = 73 + 919
        1382 = 61 + 1321
        1856 = 67 + 1789
        1928 = 61 + 1867
     */
    def `P41 (**) A list of Goldbach compositions.` {
        // TODO
    }

    // LOGIC AND CODES

    @Test
    /** Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return true or false according to the result of their respective operations;
        e.g. and(A, B) is true if and only if both A and B are true.
        scala> and(true, true)
        res0: Boolean = true

        scala> xor(true. true)
        res1: Boolean = false
        A logical expression in two variables can then be written as an function of two variables, e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))

        Now, write a function called table2 which prints the truth table of a given logical expression in two variables.

        scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
        A     B     result
        true  true  true
        true  false true
        false true  false
        false false false
     */
    def `P46 (**) Truth tables for logical expressions.` {
    }

    @Test
    /** Continue problem P46 by redefining and, or, etc as operators.
        (i.e. make them methods of a new class with an implicit conversion from Boolean.) not will have to be left as a object method.
        scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
        A     B     result
        true  true  true
        true  false true
        false true  false
        false false false
     */
    def `P47 (*) Truth tables for logical expressions (2).` {
    }

    @Test
    @Ignore // omitted apparently
    def `P48 (**) Truth tables for logical expressions (3).` {
    }

    @Test
    /** An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
        n = 1: C(1) = ("0", "1").
        n = 2: C(2) = ("00", "01", "11", "10").
        n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
        Find out the construction rules and write a function to generate Gray codes.

        scala> gray(3)
        res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
        See if you can use memoization to make the function more efficient.
     */
    def `P49 (**) Gray code.` {
    }

    @Test
    /** First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
        We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
        E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
        Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.

        scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
        res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))

     */
    def `P50 (***) Huffman code.` {
    }

    // BINARY TREES

    @Test
    @Ignore // not necessary due to static typing :D
    def `P54 Omitted; our tree representation will only allow well-formed trees.` {
    }

    @Test
    /** In a completely balanced binary tree, the following property holds for every node:
        The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one.
        Define an object named Tree. Write a function Tree.cBalanced to construct completely balanced binary trees for a given number of nodes.
        The function should generate all solutions. The function should take as parameters the number of nodes and a single value to put in all of them.

        scala> Tree.cBalanced(4, "x")
        res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...
     */
    def `P55 (**) Construct completely balanced binary trees.` {
    }

    @Test
    /** Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the right subtree is the mirror image of the left subtree.
        Add an isSymmetric method to the Tree class to check whether a given binary tree is symmetric.
        Hint: Write an isMirrorOf method first to check whether one tree is the mirror image of another.
        We are only interested in the structure, not in the contents of the nodes.
            scala> Node('a', Node('b'), Node('c')).isSymmetric
            res0: Boolean = true
     */
    def `P56 (**) Symmetric binary trees.` {
    }

    @Test
    /** Write a function to add an element to a binary search tree.
        scala> End.addValue(2)
        res0: Node[Int] = T(2 . .)

        scala> res0.addValue(3)
        res1: Node[Int] = T(2 . T(3 . .))

        scala> res1.addValue(0)
        res2: Node[Int] = T(2 T(0 . .) T(3 . .))
        Hint: The abstract definition of addValue in Tree should be def addValue[U >: T <% Ordered[U]](x: U): Tree[U]. The >: T
        is because addValue's parameters need to be contravariant in T.
        (Conceptually, we're adding nodes above existing nodes.
        In order for the subnodes to be of type T or any subtype, the upper nodes must be of type T or any supertype.)
        The <% Ordered[U] allows us to use the < operator on the values in the tree.

        Use that function to construct a binary tree from a list of integers.

        scala> Tree.fromList(List(3, 2, 5, 7, 1))
        res3: Node[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))
        Finally, use that function to test your solution to P56.

        scala> Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric
        res4: Boolean = true

        scala> Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric
        res5: Boolean = false
     */
    def `P57 (**) Binary search trees (dictionaries).` {
    }

    @Test
    /** Apply the generate-and-test paradigm to construct all symmetric, completely balanced binary trees with a given number of nodes.
        scala> Tree.symmetricBalancedTrees(5, "x")
        res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))
     */
    def `P58 (**) Generate-and-test paradigm.` {
    }

    @Test
    /** In a height-balanced binary tree, the following property holds for every node:
        The height of its left subtree and the height of its right subtree are almost equal, which means their difference is not greater than one.
        Write a method Tree.hbalTrees to construct height-balanced binary trees for a given height with a supplied value for the nodes.
        The function should generate all solutions.

        scala> Tree.hbalTrees(3, "x")
        res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...
     */
    def `P59 (**) Construct height-balanced binary trees.` {
    }

    @Test
    /** Consider a height-balanced binary tree of height H. What is the maximum number of nodes it can contain?
        Clearly, MaxN = 2H - 1. However, what is the minimum number MinN? This question is more difficult.
        Try to find a recursive statement and turn it into a function minHbalNodes that takes a height and returns MinN.
        scala> minHbalNodes(3)
        res0: Int = 4
        On the other hand, we might ask: what is the maximum height H a height-balanced binary tree with N nodes can have? Write a maxHbalHeight function.

        scala> maxHbalHeight(4)
        res1: Int = 3
        Now, we can attack the main problem: construct all the height-balanced binary trees with a given nuber of nodes.

        scala> Tree.hbalTreesWithNodes(4, "x")
        res2: List[Node[String]] = List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), ...
        Find out how many height-balanced trees exist for N = 15.
     */
    def `P60 (**) Construct height-balanced binary trees with a given number of nodes.` {
    }

    @Test
    /** A leaf is a node with no successors. Write a method leafCount to count them.
        scala> Node('x', Node('x'), End).leafCount
        res0: Int = 1
     */
    def `P61 (*) Count the leaves of a binary tree.` {
    }

    @Test
    /** A leaf is a node with no successors. Write a method leafList to collect them in a list.
        scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
        res0: List[Char] = List(b, d, e)
     */
    def `61A (*) Collect the leaves of a binary tree in a list.` {
    }

    @Test
    /**
An internal node of a binary tree has either one or two non-empty successors. Write a method internalList to collect them in a list.
scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
res0: List[Char] = List(a, c)
     */
    def `P62 (*) Collect the internal nodes of a binary tree in a list.` {
    }

    @Test
    /**
A node of a binary tree is at level N if the path from the root to the node has length N-1. The root node is at level 1. Write a method atLevel to collect all nodes at a given level in a list.
scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
res0: List[Char] = List(b, c)
Using atLevel it is easy to construct a method levelOrder which creates the level-order sequence of the nodes. However, there are more efficient ways to do that.
     */
    def `P62B (*) Collect the nodes at a given level in a list.` {
    }

    @Test
    /**
A complete binary tree with height H is defined as follows: The levels 1,2,3,...,H-1 contain the maximum number of nodes (i.e 2(i-1) at the level i, note that we start counting the levels from 1 at the root). In level H, which may contain less than the maximum possible number of nodes, all the nodes are "left-adjusted". This means that in a levelorder tree traversal all internal nodes come first, the leaves come second, and empty successors (the Ends which are not really nodes!) come last.
Particularly, complete binary trees are used as data structures (or addressing schemes) for heaps.

We can assign an address number to each node in a complete binary tree by enumerating the nodes in levelorder, starting at the root with number 1. In doing so, we realize that for every node X with address A the following property holds: The address of X's left and right successors are 2*A and 2*A+1, respectively, supposed the successors do exist. This fact can be used to elegantly construct a complete binary tree structure. Write a method completeBinaryTree that takes as parameters the number of nodes and the value to put in each node.

scala> Tree.completeBinaryTree(6, "x")
res0: Node[String] = T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))
     */
    def `P63 (**) Construct a complete binary tree.` {
    }

    @Test
    /**
As a preparation for drawing a tree, a layout algorithm is required to determine the position of each node in a rectangular grid.
Several layout methods are conceivable, one of them is shown in the illustration on the right. http://aperiodic.net/phil/scala/s-99/p64.gif
In this layout strategy, the position of a node v is obtained by the following two rules:

x(v) is equal to the position of the node v in the inorder sequence
y(v) is equal to the depth of the node v in the tree
In order to store the position of the nodes, we add a new class with the additional information.

case class PositionedNode[+T](override val value: T, override val left: Tree[T], override val right: Tree[T], x: Int, y: Int) extends Node[T](value, left, right) {
  override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
}
Write a method layoutBinaryTree that turns a tree of normal Nodes into a tree of PositionedNodes.

scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree
res0: PositionedNode[Char] = T[3,1](a T[1,2](b . T[2,3](c . .)) T[4,2](d . .))
The tree at right may be constructed with Tree.fromList(List('n','k','m','c','a','h','g','e','u','p','s','q')). Use it to check your code.
     */
    def `P64 (**) Layout a binary tree (1).` {
    }

    @Test
    /**
An alternative layout method is depicted in the illustration opposite. Find out the rules and write the corresponding method. Hint: On a given level, the horizontal distance between neighboring nodes is constant.
Use the same conventions as in problem P64.

http://aperiodic.net/phil/scala/s-99/p65.gif

scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2
res0: PositionedNode[Char] = T[3,1]('a T[1,2]('b . T[2,3]('c . .)) T[5,2]('d . .))
The tree at right may be constructed with Tree.fromList(List('n','k','m','c','a','e','d','g','u','p','q')). Use it to check your code.
     */
    def `P65 (**) Layout a binary tree (2).` {
    }

    @Test
    /**
Yet another layout strategy is shown in the illustration opposite. The method yields a very compact layout while maintaining a certain symmetry in every node. Find out the rules and write the corresponding method. Hint: Consider the horizontal distance between a node and its successor nodes. How tight can you pack together two subtrees to construct the combined binary tree?
Use the same conventions as in problem P64 and P65. Note: This is a difficult problem. Don't give up too early!

http://aperiodic.net/phil/scala/s-99/p66.gif

scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree3
res0: PositionedNode[Char] = T[2,1]('a T[1,2]('b . T[2,3]('c . .)) T[3,2]('d . .))
Which layout do you like most?
     */
    def `P66 (***) Layout a binary tree (3).` {
    }

    @Test
    /**
Somebody represents binary trees as strings of the following type (see example opposite):
a(b(d,e),c(,f(g,)))
Write a method which generates this string representation, if the tree is given as usual (in Nodes and Ends). Use that method for the Tree class's and subclass's toString methods. Then write a method (on the Tree object) which does this inverse; i.e. given the string representation, construct the tree in the usual form.

http://aperiodic.net/phil/scala/s-99/p67.gif

For simplicity, suppose the information in the nodes is a single letter and there are no spaces in the string.

scala> Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).toString
res0: String = a(b(d,e),c(,f(g,)))

scala> Tree.fromString("a(b(d,e),c(,f(g,)))")
res1: Node[Char] = a(b(d,e),c(,f(g,)))
     */
    def `P67 (**) A string representation of binary trees.` {
    }

    @Test
    /** We consider binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67.
        a) Write methods preorder and inorder that construct the preorder and inorder sequence of a given binary tree, respectively.
        The results should be lists, e.g. List('a','b','d','e','c','f','g') for the preorder sequence of the example in problem P67.

        scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder
        res0: List[Char] = List(a, b, d, e, c, f, g)

        scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder
        res1: List[Char] = List(d, b, e, a, c, g, f)
        b) If both the preorder sequence and the inorder sequence of the nodes of a binary tree are given, then the tree is determined unambiguously.
        Write a method preInTree that does the job.

        scala> Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f'))
        res2: Node[Char] = a(b(d,e),c(,f(g,)))
     */
    def `P68 (**) Preorder and inorder sequences of binary trees.` {
    }

    @Test
    /** We consider again binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67.
        Such a tree can be represented by the preorder sequence of its nodes in which dots (.) are inserted where an
        empty subtree (End) is encountered during the tree traversal.
        For example, the tree shown in problem P67 is represented as "abd..e..c.fg...".
        First, try to establish a syntax (BNF or syntax diagrams) and then write two methods, toDotstring and fromDotstring, which do the conversion in both directions.
        scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").toDotstring
        res0: String = abd..e..c.fg...

        scala> Tree.fromDotstring("abd..e..c.fg...")
        res1: Node[Char] = a(b(d,e),c(,f(g,)))
     */
    def `P69 (**) Dotstring representation of binary trees.` {
    }

    // MULTI-WAY TREES

    @Test
    @Ignore
    def `P70B Omitted; we can only create well-formed trees.` {
    }

    @Test
    /** Write a method nodeCount which counts the nodes of a given multiway tree.
        scala> MTree('a', List(MTree('f'))).nodeCount
        res0: Int = 2
     */
    def `P70C (*) Count the nodes of a multiway tree.` {
    }

    @Test
    /** We suppose that the nodes of a multiway tree contain single characters.
        In the depth-first order sequence of its nodes, a special character ^ has been inserted whenever,
        during the tree traversal, the move is a backtrack to the previous level.
        By this rule, the tree in the figure opposite is represented as:

        afg^^c^bd^e^^^

        http://aperiodic.net/phil/scala/s-99/p70.gif

        Define the syntax of the string and write a function string2MTree to construct an MTree from a String.
        Make the function an implicit conversion from String. Write the reverse function, and make it the toString method of MTree.

        scala> MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))).toString
        res0: String = afg^^c^bd^e^^^
     */
    def `P70 (**) Tree construction from a node string.` {
    }

    @Test
    /** We define the internal path length of a multiway tree as the total sum of the path lengths from the root to all nodes of the tree.
        By this definition, the tree in the figure of problem P70 has an internal path length of 9.
        Write a method internalPathLength to return that sum.
        scala> "afg^^c^bd^e^^^".internalPathLength
        res0: Int = 9
     */
    def `P71 (*) Determine the internal path length of a tree.` {
    }

    @Test
    /** Write a method postorder which constructs the postorder sequence of the nodes of a multiway tree. The result should be a List.
        scala> "afg^^c^bd^e^^^".postorder
        res0: List[Char] = List(g, f, c, d, e, b, a)
     */
    def `P72 (*) Construct the postorder sequence of the tree nodes.` {
    }

    @Test
    /**
There is a particular notation for multiway trees in Lisp. Lisp is a prominent functional programming language. In Lisp almost everything is a list.
Our example tree would be represented in Lisp as (a (f g) c (b d e)). The following pictures give some more examples.

http://aperiodic.net/phil/scala/s-99/p73.png

Note that in the "lispy" notation a node with successors (children) in the tree is always the first element in a list, followed by its children. The "lispy" representation of a multiway tree is a sequence of atoms and parentheses '(' and ')', with the atoms separated by spaces. We can represent this syntax as a Scala String. Write a method lispyTree which constructs a "lispy string" from an MTree.

scala> MTree("a", List(MTree("b", List(MTree("c"))))).lispyTree
res0: String = (a (b c))
As a second, even more interesting, exercise try to write a method that takes a "lispy" string and turns it into a multiway tree.

[Note: Much of this problem is taken from the wording of the same problem in the Prolog set. This is certainly one way of looking at Lisp notation, but it's not how the language actually represents that syntax internally. I can elaborate more on this, if requested. <PMG>]
     */
    def `P73 (**) Lisp-like tree representation.` {
    }

//    @Test
//    def `` {
//    }


}