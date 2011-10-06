package problems
import org.junit.Assert._
import org.junit.Ignore
import org.junit.Test


/** A multiway tree is composed of a root element and a (possibly empty) set of successors which are multiway trees themselves.
 *  A multiway tree is never empty. The set of successor trees is sometimes called a forest.
 *
 *  The code to represent these is somewhat simpler than the code for binary trees,
 *  partly because we don't separate classes for nodes and terminators,
 *  and partly because we don't need the restriction that the value type be ordered.
 *
 *  <pre>
 *  case class MTree[+T](value: T, children: List[MTree[T]]) {
 *    def this(value: T) = this(value, List())
 *    override def toString = "M(" + value.toString + " {" + children.map(_.toString).mkString(",") + "})"
 *  }
 *
 *  object MTree {
 *    def apply[T](value: T) = new MTree(value, List())
 *    def apply[T](value: T, children: List[MTree[T]]) = new MTree(value, children)
 *  }
 *  </pre>
 *
 *  The example tree is, thus:
 *
 *  MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e')))))
 */
class MultiwayTreesTest {

    @Test
    @Ignore
    def `P70B Omitted; we can only create well-formed trees.` {
    }

    @Test
    /** Write a method nodeCount which counts the nodes of a given multiway tree.
     *  scala> MTree('a', List(MTree('f'))).nodeCount
     *  res0: Int = 2
     */
    def `P70C (*) Count the nodes of a multiway tree.` {
    }

    @Test
    /** We suppose that the nodes of a multiway tree contain single characters.
     *  In the depth-first order sequence of its nodes, a special character ^ has been inserted whenever,
     *  during the tree traversal, the move is a backtrack to the previous level.
     *  By this rule, the tree in the figure opposite is represented as:
     *
     *  afg^^c^bd^e^^^
     *
     *  http://aperiodic.net/phil/scala/s-99/p70.gif
     *
     *  Define the syntax of the string and write a function string2MTree to construct an MTree from a String.
     *  Make the function an implicit conversion from String. Write the reverse function, and make it the toString method of MTree.
     *
     *  scala> MTree('a', List(MTree('f', List(MTree('g'))), MTree('c'), MTree('b', List(MTree('d'), MTree('e'))))).toString
     *  res0: String = afg^^c^bd^e^^^
     */
    def `P70 (**) Tree construction from a node string.` {
    }

    @Test
    /** We define the internal path length of a multiway tree as the total sum of the path lengths from the root to all nodes of the tree.
     *  By this definition, the tree in the figure of problem P70 has an internal path length of 9.
     *  Write a method internalPathLength to return that sum.
     *  scala> "afg^^c^bd^e^^^".internalPathLength
     *  res0: Int = 9
     */
    def `P71 (*) Determine the internal path length of a tree.` {
    }

    @Test
    /** Write a method postorder which constructs the postorder sequence of the nodes of a multiway tree. The result should be a List.
     *  scala> "afg^^c^bd^e^^^".postorder
     *  res0: List[Char] = List(g, f, c, d, e, b, a)
     */
    def `P72 (*) Construct the postorder sequence of the tree nodes.` {
    }

    @Test
    /** There is a particular notation for multiway trees in Lisp.
     *  Lisp is a prominent functional programming language. In Lisp almost everything is a list.
     *  Our example tree would be represented in Lisp as (a (f g) c (b d e)). The following pictures give some more examples.
     *
     *  http://aperiodic.net/phil/scala/s-99/p73.png
     *
     *  Note that in the "lispy" notation a node with successors (children) in the tree is always the first element in a list, followed by its children.
     *  The "lispy" representation of a multiway tree is a sequence of atoms and parentheses '(' and ')', with the atoms separated by spaces.
     *  We can represent this syntax as a Scala String. Write a method lispyTree which constructs a "lispy string" from an MTree.
     *
     *  scala> MTree("a", List(MTree("b", List(MTree("c"))))).lispyTree
     *  res0: String = (a (b c))
     *  As a second, even more interesting, exercise try to write a method that takes a "lispy" string and turns it into a multiway tree.
     *
     *  [Note: Much of this problem is taken from the wording of the same problem in the Prolog set.
     *  This is certainly one way of looking at Lisp notation, but it's not how the language actually represents that syntax internally.
     *  I can elaborate more on this, if requested. <PMG>]
     */
    def `P73 (**) Lisp-like tree representation.` {
    }
}