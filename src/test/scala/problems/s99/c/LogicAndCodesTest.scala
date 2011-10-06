package problems
import org.junit.Test
import org.junit.Assert._
import org.junit.Ignore
import answers.LogicAndCodes._

/** As in the previous section, we will start with a skeleton file, logic1.scala, and add code to it for each problem.
 *  The difference here is that the file starts out almost empty.
 */
class LogicAndCodesTest {

    @Test
    /** Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence) which return true or false according to the result of their respective operations;
     *  e.g. and(A, B) is true if and only if both A and B are true.
     *  scala> and(true, true)
     *  res0: Boolean = true
     *
     *  scala> xor(true. true)
     *  res1: Boolean = false
     */
    def `P46 (**) Truth tables for logical expressions.` {
        assertFalse(and(false, false))
        assertFalse(and(false, true))
        assertFalse(and(true, false))
        assertTrue(and(true, true))

        assertFalse(or(false, false))
        assertTrue(or(false, true))
        assertTrue(or(true, false))
        assertTrue(or(true, true))

        assertTrue(nand(false, false))
        assertTrue(nand(false, true))
        assertTrue(nand(true, false))
        assertFalse(nand(true, true))

        assertTrue(nor(false, false))
        assertFalse(nor(false, true))
        assertFalse(nor(true, false))
        assertFalse(nor(true, true))

        assertFalse(xor(false, false))
        assertTrue(xor(false, true))
        assertTrue(xor(true, false))
        assertFalse(xor(true, true))

        // TODO impl, equ
    }

    /** A logical expression in two variables can then be written as a function of two variables, e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
     *  Now, write a function called table2 which prints the truth table of a given logical expression in two variables.
     *
     *  scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
     *  A     B     result
     *  true  true  true
     *  true  false true
     *  false true  false
     *  false false false
     */
    def `P46b (**) Print truth tables for logical expressions.` {
    }

    @Test
    /** Continue problem P46 by redefining and, or, etc as operators.
     *  (i.e. make them methods of a new class with an implicit conversion from Boolean.) not will have to be left as a object method.
     *  scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
     *  A     B     result
     *  true  true  true
     *  true  false true
     *  false true  false
     *  false false false
     */
    def `P47 (*) Truth tables for logical expressions (2).` {
    }

    @Test
    @Ignore // omitted apparently
    def `P48 (**) Truth tables for logical expressions (3).` {
    }

    @Test
    /** An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
     *  n = 1: C(1) = ("0", "1").
     *  n = 2: C(2) = ("00", "01", "11", "10").
     *  n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").
     *  Find out the construction rules and write a function to generate Gray codes.
     *
     *  scala> gray(3)
     *  res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
     *  See if you can use memoization to make the function more efficient.
     */
    def `P49 (**) Gray code.` {
        assertEquals(List("0", "1"), gray(1))
        assertEquals(List("00", "01", "11", "10"), gray(2))
        assertEquals(List("000", "001", "011", "010", "110", "111", "101", "100"), gray(3))
    }

    @Test
    /** First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
     *  We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples.
     *  E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
     *  Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.
     *
     *  scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
     *  res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
     *
     */
    def `P50 (***) Huffman code.` {
        val result = huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
        assertEquals(List(("a","0"), ("b","101"), ("c","100"), ("d","111"), ("e","1101"), ("f","1100")), result)
    }
}