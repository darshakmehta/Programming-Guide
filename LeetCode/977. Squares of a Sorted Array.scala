object Solution {
    def sortedSquares(A: Array[Int]): Array[Int] = {
        var nonNegIndex = 0
        while(nonNegIndex < A.length && A(nonNegIndex) < 0) nonNegIndex += 1
        var i = nonNegIndex
        var j = nonNegIndex - 1
        
        Array.tabulate(A.length) { _ =>
            if(j < 0 || i < A.length && A(i) < -A(j)) {
                val result = A(i) * A(i)
                i += 1
                result
            } else {
                val result = A(j) * A(j)
                j -= 1
                result
            }
        }
    }
}

//https://leetcode.com/problems/squares-of-a-sorted-array/discuss/227197/Elegant-Scala-Solution