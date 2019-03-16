object Solution {
    def sortArrayByParity(A: Array[Int]): Array[Int] = {
         A.groupBy(_ % 2 != 0).values.flatten.toArray
    }
}