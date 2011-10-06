package com.dadrox
import org.junit.Assert._
import org.junit.Ignore
import org.junit.Test

/** A binary tree is either empty or it is composed of a root element and two successors, which are binary trees themselves.
 *
 *  We shall use the following classes to represent binary trees. (Also available in tree1.scala.)
 *  An End is equivalent to an empty tree. A Branch has a value, and two descendant trees.
 *  The toString functions are relatively arbitrary, but they yield a more compact output than Scala's default.
 *  Putting a plus in front of the T makes the class covariant; it will be able to hold subtypes of whatever type it's created for.
 *  (This is important so that End can be a singleton object;
 *  as a singleton, it must have a specific type, so we give it type Nothing, which is a subtype of every other type.)
 *  <pre>
 *  sealed abstract class Tree[+T]
 *  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
 *    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"
 *  }
 *  case object End extends Tree[Nothing] {
 *    override def toString = "."
 *  }
 *  object Node {
 *    def apply[T](value: T): Node[T] = Node(value, End, End)
 *  }
 *  </pre>
 *
 *  The example tree on the right is given by
 *
 *  Node('a',
 *       Node('b', Node('d'), Node('e')),
 *       Node('c', End, Node('f', Node('g'), End)))
 *  A tree with only a root node would be Node('a') and an empty tree would be End.
 *
 *  Throughout this section, we will be adding methods to the classes above, mostly to Tree.
 */
class BinaryTreesTest {

    @Test
    @Ignore // not necessary due to static typing :D
    def `P54 Omitted; our tree representation will only allow well-formed trees.` {
    }

    @Test
    /** In a completely balanced binary tree, the following property holds for every node:
     *  The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal, which means their difference is not greater than one.
     *  Define an object named Tree. Write a function Tree.cBalanced to construct completely balanced binary trees for a given number of nodes.
     *  The function should generate all solutions. The function should take as parameters the number of nodes and a single value to put in all of them.
     *
     *  scala> Tree.cBalanced(4, "x")
     *  res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...
     */
    def `P55 (**) Construct completely balanced binary trees.` {
    }

    @Test
    /** Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the right subtree is the mirror image of the left subtree.
     *  Add an isSymmetric method to the Tree class to check whether a given binary tree is symmetric.
     *  Hint: Write an isMirrorOf method first to check whether one tree is the mirror image of another.
     *  We are only interested in the structure, not in the contents of the nodes.
     *      scala> Node('a', Node('b'), Node('c')).isSymmetric
     *      res0: Boolean = true
     */
    def `P56 (**) Symmetric binary trees.` {
    }

    @Test
    /** Write a function to add an element to a binary search tree.
     *  scala> End.addValue(2)
     *  res0: Node[Int] = T(2 . .)
     *
     *  scala> res0.addValue(3)
     *  res1: Node[Int] = T(2 . T(3 . .))
     *
     *  scala> res1.addValue(0)
     *  res2: Node[Int] = T(2 T(0 . .) T(3 . .))
     *  Hint: The abstract definition of addValue in Tree should be def addValue[U >: T <% Ordered[U]](x: U): Tree[U]. The >: T
     *  is because addValue's parameters need to be contravariant in T.
     *  (Conceptually, we're adding nodes above existing nodes.
     *  In order for the subnodes to be of type T or any subtype, the upper nodes must be of type T or any supertype.)
     *  The <% Ordered[U] allows us to use the < operator on the values in the tree.
     *
     *  Use that function to construct a binary tree from a list of integers.
     *
     *  scala> Tree.fromList(List(3, 2, 5, 7, 1))
     *  res3: Node[Int] = T(3 T(2 T(1 . .) .) T(5 . T(7 . .)))
     *  Finally, use that function to test your solution to P56.
     *
     *  scala> Tree.fromList(List(5, 3, 18, 1, 4, 12, 21)).isSymmetric
     *  res4: Boolean = true
     *
     *  scala> Tree.fromList(List(3, 2, 5, 7, 4)).isSymmetric
     *  res5: Boolean = false
     */
    def `P57 (**) Binary search trees (dictionaries).` {
    }

    @Test
    /** Apply the generate-and-test paradigm to construct all symmetric, completely balanced binary trees with a given number of nodes.
     *  scala> Tree.symmetricBalancedTrees(5, "x")
     *  res0: List[Node[String]] = List(T(x T(x . T(x . .)) T(x T(x . .) .)), T(x T(x T(x . .) .) T(x . T(x . .))))
     */
    def `P58 (**) Generate-and-test paradigm.` {
    }

    @Test
    /** In a height-balanced binary tree, the following property holds for every node:
     *  The height of its left subtree and the height of its right subtree are almost equal, which means their difference is not greater than one.
     *  Write a method Tree.hbalTrees to construct height-balanced binary trees for a given height with a supplied value for the nodes.
     *  The function should generate all solutions.
     *
     *  scala> Tree.hbalTrees(3, "x")
     *  res0: List[Node[String]] = List(T(x T(x T(x . .) T(x . .)) T(x T(x . .) T(x . .))), T(x T(x T(x . .) T(x . .)) T(x T(x . .) .)), ...
     */
    def `P59 (**) Construct height-balanced binary trees.` {
    }

    @Test
    /** Consider a height-balanced binary tree of height H. What is the maximum number of nodes it can contain?
     *  Clearly, MaxN = 2H - 1. However, what is the minimum number MinN? This question is more difficult.
     *  Try to find a recursive statement and turn it into a function minHbalNodes that takes a height and returns MinN.
     *  scala> minHbalNodes(3)
     *  res0: Int = 4
     *  On the other hand, we might ask: what is the maximum height H a height-balanced binary tree with N nodes can have? Write a maxHbalHeight function.
     *
     *  scala> maxHbalHeight(4)
     *  res1: Int = 3
     *  Now, we can attack the main problem: construct all the height-balanced binary trees with a given nuber of nodes.
     *
     *  scala> Tree.hbalTreesWithNodes(4, "x")
     *  res2: List[Node[String]] = List(T(x T(x T(x . .) .) T(x . .)), T(x T(x . T(x . .)) T(x . .)), ...
     *  Find out how many height-balanced trees exist for N = 15.
     */
    def `P60 (**) Construct height-balanced binary trees with a given number of nodes.` {
    }

    @Test
    /** A leaf is a node with no successors. Write a method leafCount to count them.
     *  scala> Node('x', Node('x'), End).leafCount
     *  res0: Int = 1
     */
    def `P61 (*) Count the leaves of a binary tree.` {
    }

    @Test
    /** A leaf is a node with no successors. Write a method leafList to collect them in a list.
     *  scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).leafList
     *  res0: List[Char] = List(b, d, e)
     */
    def `61A (*) Collect the leaves of a binary tree in a list.` {
    }

    @Test
    /** An internal node of a binary tree has either one or two non-empty successors.
     *  Write a method internalList to collect them in a list.
     *  scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).internalList
     *  res0: List[Char] = List(a, c)
     */
    def `P62 (*) Collect the internal nodes of a binary tree in a list.` {
    }

    @Test
    /** A node of a binary tree is at level N if the path from the root to the node has length N-1.
     *  The root node is at level 1. Write a method atLevel to collect all nodes at a given level in a list.
     *  scala> Node('a', Node('b'), Node('c', Node('d'), Node('e'))).atLevel(2)
     *  res0: List[Char] = List(b, c)
     *  Using atLevel it is easy to construct a method levelOrder which creates the level-order sequence of the nodes.
     *  However, there are more efficient ways to do that.
     */
    def `P62B (*) Collect the nodes at a given level in a list.` {
    }

    @Test
    /** A complete binary tree with height H is defined as follows:
     *  The levels 1,2,3,...,H-1 contain the maximum number of nodes (i.e 2(i-1) at the level i, note that we start counting the levels from 1 at the root).
     *  In level H, which may contain less than the maximum possible number of nodes, all the nodes are "left-adjusted".
     *  This means that in a levelorder tree traversal all internal nodes come first, the leaves come second, and empty successors (the Ends which are not really nodes!) come last.
     *  Particularly, complete binary trees are used as data structures (or addressing schemes) for heaps.
     *
     *  We can assign an address number to each node in a complete binary tree by enumerating the nodes in levelorder, starting at the root with number 1.
     *  In doing so, we realize that for every node X with address A the following property holds:
     *  The address of X's left and right successors are 2*A and 2*A+1, respectively, supposed the successors do exist.
     *  This fact can be used to elegantly construct a complete binary tree structure.
     *  Write a method completeBinaryTree that takes as parameters the number of nodes and the value to put in each node.
     *
     *  scala> Tree.completeBinaryTree(6, "x")
     *  res0: Node[String] = T(x T(x T(x . .) T(x . .)) T(x T(x . .) .))
     */
    def `P63 (**) Construct a complete binary tree.` {
    }

    @Test
    /** As a preparation for drawing a tree, a layout algorithm is required to determine the position of each node in a rectangular grid.
     *  Several layout methods are conceivable, one of them is shown in the illustration on the right. http://aperiodic.net/phil/scala/s-99/p64.gif
     *  In this layout strategy, the position of a node v is obtained by the following two rules:
     *
     *  x(v) is equal to the position of the node v in the inorder sequence
     *  y(v) is equal to the depth of the node v in the tree
     *  In order to store the position of the nodes, we add a new class with the additional information.
     *
     *  case class PositionedNode[+T](override val value: T, override val left: Tree[T], override val right: Tree[T], x: Int, y: Int) extends Node[T](value, left, right) {
     *    override def toString = "T[" + x.toString + "," + y.toString + "](" + value.toString + " " + left.toString + " " + right.toString + ")"
     *  }
     *  Write a method layoutBinaryTree that turns a tree of normal Nodes into a tree of PositionedNodes.
     *
     *  scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree
     *  res0: PositionedNode[Char] = T[3,1](a T[1,2](b . T[2,3](c . .)) T[4,2](d . .))
     *  The tree at right may be constructed with Tree.fromList(List('n','k','m','c','a','h','g','e','u','p','s','q')). Use it to check your code.
     */
    def `P64 (**) Layout a binary tree (1).` {
    }

    @Test
    /** An alternative layout method is depicted in the illustration opposite.
     *  Find out the rules and write the corresponding method.
     *  Hint: On a given level, the horizontal distance between neighboring nodes is constant.
     *  Use the same conventions as in problem P64.
     *
     *  http://aperiodic.net/phil/scala/s-99/p65.gif
     *
     *  scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree2
     *  res0: PositionedNode[Char] = T[3,1]('a T[1,2]('b . T[2,3]('c . .)) T[5,2]('d . .))
     *  The tree at right may be constructed with Tree.fromList(List('n','k','m','c','a','e','d','g','u','p','q')). Use it to check your code.
     */
    def `P65 (**) Layout a binary tree (2).` {
    }

    @Test
    /** Yet another layout strategy is shown in the illustration opposite.
     *  The method yields a very compact layout while maintaining a certain symmetry in every node.
     *  Find out the rules and write the corresponding method.
     *  Hint: Consider the horizontal distance between a node and its successor nodes.
     *  How tight can you pack together two subtrees to construct the combined binary tree?
     *  Use the same conventions as in problem P64 and P65. Note: This is a difficult problem. Don't give up too early!
     *
     *  http://aperiodic.net/phil/scala/s-99/p66.gif
     *
     *  scala> Node('a', Node('b', End, Node('c')), Node('d')).layoutBinaryTree3
     *  res0: PositionedNode[Char] = T[2,1]('a T[1,2]('b . T[2,3]('c . .)) T[3,2]('d . .))
     *  Which layout do you like most?
     */
    def `P66 (***) Layout a binary tree (3).` {
    }

    @Test
    /** Somebody represents binary trees as strings of the following type (see example opposite):
     *  a(b(d,e),c(,f(g,)))
     *  Write a method which generates this string representation, if the tree is given as usual (in Nodes and Ends).
     *  Use that method for the Tree class's and subclass's toString methods.
     *  Then write a method (on the Tree object) which does this inverse; i.e. given the string representation, construct the tree in the usual form.
     *
     *  http://aperiodic.net/phil/scala/s-99/p67.gif
     *
     *  For simplicity, suppose the information in the nodes is a single letter and there are no spaces in the string.
     *
     *  scala> Node('a', Node('b', Node('d'), Node('e')), Node('c', End, Node('f', Node('g'), End))).toString
     *  res0: String = a(b(d,e),c(,f(g,)))
     *
     *  scala> Tree.fromString("a(b(d,e),c(,f(g,)))")
     *  res1: Node[Char] = a(b(d,e),c(,f(g,)))
     */
    def `P67 (**) A string representation of binary trees.` {
    }

    @Test
    /** We consider binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67.
     *  a) Write methods preorder and inorder that construct the preorder and inorder sequence of a given binary tree, respectively.
     *  The results should be lists, e.g. List('a','b','d','e','c','f','g') for the preorder sequence of the example in problem P67.
     *
     *  scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").preorder
     *  res0: List[Char] = List(a, b, d, e, c, f, g)
     *
     *  scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").inorder
     *  res1: List[Char] = List(d, b, e, a, c, g, f)
     *  b) If both the preorder sequence and the inorder sequence of the nodes of a binary tree are given, then the tree is determined unambiguously.
     *  Write a method preInTree that does the job.
     *
     *  scala> Tree.preInTree(List('a', 'b', 'd', 'e', 'c', 'f', 'g'), List('d', 'b', 'e', 'a', 'c', 'g', 'f'))
     *  res2: Node[Char] = a(b(d,e),c(,f(g,)))
     */
    def `P68 (**) Preorder and inorder sequences of binary trees.` {
    }

    @Test
    /** We consider again binary trees with nodes that are identified by single lower-case letters, as in the example of problem P67.
     *  Such a tree can be represented by the preorder sequence of its nodes in which dots (.) are inserted where an
     *  empty subtree (End) is encountered during the tree traversal.
     *  For example, the tree shown in problem P67 is represented as "abd..e..c.fg...".
     *  First, try to establish a syntax (BNF or syntax diagrams) and then write two methods, toDotstring and fromDotstring, which do the conversion in both directions.
     *  scala> Tree.string2Tree("a(b(d,e),c(,f(g,)))").toDotstring
     *  res0: String = abd..e..c.fg...
     *
     *  scala> Tree.fromDotstring("abd..e..c.fg...")
     *  res1: Node[Char] = a(b(d,e),c(,f(g,)))
     */
    def `P69 (**) Dotstring representation of binary trees.` {
    }
}