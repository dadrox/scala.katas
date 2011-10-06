package answers

object Arithmetic {
    class S99Int(val start: Int) {

        def isPrime = {
            false
        }

        def isCoprimeTo(end: Int) = {
            false
        }

        def totient = {
            false
        }

        def primeFactors = {
            List()
        }

        def primeFactorMultiplicity = {
            List()
        }

        def goldbach = {
        }
    }

    def gcd(left: Int, right: Int) = {
    }

    def listPrimesinRange(range: Range) = {
        List()
    }

    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
}