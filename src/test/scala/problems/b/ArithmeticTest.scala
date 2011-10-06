package problems
import org.junit.Assert._
import org.junit.Test
import answers.Arithmetic._

/** For the next section, we're going to take a different tack with the solutions.
    We'll declare a new class, S99Int, and an implicit conversion from regular Ints.
    The arithmetic1 file contains the starting definitions for this section.
    Each individual solution will show the relevant additions to the S99Int class.
    The full class will be given at the end of the section.
 */
class ArithmeticTest {
    @Test
    def `P31 (**) Determine whether a given integer number is prime.` {
        assertTrue(2.isPrime)
        assertTrue(7.isPrime)
        assertTrue(101.isPrime)
        assertTrue(31337.isPrime)
        assertFalse(4.isPrime)
        assertFalse(42.isPrime)
        assertFalse(333.isPrime)
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
        assertFalse(3.isCoprimeTo(6))
        assertFalse(32.isCoprimeTo(128))
        assertFalse(555.isCoprimeTo(10305))
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
    /** See problem P34 for the definition of Euler's totient function.  If the
     *  list of the prime factors of a number m is known in the form of problem
     *  P36 then the function phi(m>) can be efficiently calculated as follows:
     *  Let [[p_1, m_1], [p_2, m_2], [p_3, m_3], ...] be the list of prime
     *  factors (and their multiplicities) of a given number m.  Then phi(m) can
     *  be calculated with the following formula:
     *
     *  phi(m) = (p_1-1)*p_1^(m_1-1) * (p_2-1)*p_2^(m_2-1) * (p_3-1)*p_3^(m_3-1) * ...
     *
     *  Note that a^b stands for the bth power of a.
     */
    def `P37 (**) Calculate Euler's totient function phi(m) (improved).` {
        assertTrue(true)
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
        assertEquals(List(1, 2, 3), listPrimesinRange(1 until 5))
        assertEquals(List(1, 2, 3, 5), listPrimesinRange(1 to 5))
        assertEquals(List(7, 11, 13, 17, 19, 23, 29, 31), listPrimesinRange(7 to 31))
    }

    @Test
    /** Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
     *  E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be correct in the general case.
     *  It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
     *  Write a function to find the two prime numbers that sum up to a given even integer.
     */
    def `P40 (**) Goldbach's conjecture.` {
        assertEquals((3, 3), 6.goldbach)
        assertEquals((3, 5), 8.goldbach)
        assertEquals((5, 7), 12.goldbach)
        assertEquals((5, 23), 28.goldbach)
    }

    @Test
    /** Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
     *  scala> printGoldbachList(9 to 20)
     *  10 = 3 + 7
     *  12 = 5 + 7
     *  14 = 3 + 11
     *  16 = 3 + 13
     *  18 = 5 + 13
     *  20 = 3 + 17
     *  In most cases, if an even number is written as the sum of two prime numbers, one of them is very small.
     *  Very rarely, the primes are both bigger than, say, 50.
     *  Try to find out how many such cases there are in the range 2..3000.
     *
     *  Example (minimum value of 50 for the primes):
     *
     *  scala> printGoldbachListLimited(1 to 2000, 50)
     *  992 = 73 + 919
     *  1382 = 61 + 1321
     *  1856 = 67 + 1789
     *  1928 = 61 + 1867
     */
    def `P41 (**) A list of Goldbach compositions.` {
        // TODO
    }
}