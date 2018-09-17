# Decrease and Conquer

Decrease: Reduce problem instance to smaller instance of the same problem and extend solution.

Conquer: Problem by Solving Smaller instance of the problem.

Extend: Solution of smaller instance to obtain solution to original problem.


Sometimes called as, incremental or inductive approach.

#### Example: Binary Search

# Implementations of Decrease and Conquer

	Top-down approach : It always leads to the recursive implementation of the problem.
	Bottom-up approach : It is usually implemented in iterative way, starting with a solution to the smallest instance of the problem.

# Variations of Decrease and Conquer :

There are three major variations of decrease-and-conquer:

	Decrease by a constant
	Decrease by a constant factor
	Variable size decrease

# Decrease by a Constant : 

In this variation, the size of an instance is reduced by the same constant on each iteration of the algorithm. Typically, this constant is equal to one, although other constant size reductions do happen occasionally. 

Below are example problems :

	Insertion sort
	Graph search algorithms: DFS, BFS
	Topological sorting
	Algorithms for generating permutations, subsets

# Decrease by a Constant factor : 

This technique suggests reducing a problem instance by the same constant factor on each iteration of the algorithm. In most applications, this constant factor is equal to two. A reduction by a factor other than two is especially rare.

Decrease by a constant factor algorithms are very efficient especially when the factor is greater than 2 as in the fake-coin problem. 

Below are example problems :

	Binary search
	Fake-coin problems
	Russian peasant multiplication

# Variable-Size-Decrease : 

In this variation, the size-reduction pattern varies from one iteration of an algorithm to another.
As, in problem of finding gcd of two number though the value of the second argument is always smaller on the right-handside than on the left-hand side, it decreases neither by a constant nor by a constant factor. 

Below are example problems :

	Computing median and selection problem.
	Interpolation Search
	Euclid’s algorithm

There may be a case that problem can be solved by decrease-by-constant as well as decrease-by-factor variations, but the implementations can be either recursive or iterative. The iterative implementations may require more coding effort, however they avoid the overload that accompanies recursion.


# Reference:

https://www.geeksforgeeks.org/decrease-and-conquer/
