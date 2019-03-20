object Solution {
    def commonChars(A: Array[String]): List[String] = {
        A.foldLeft(A.head)(_.intersect(_)).toList.map(_.toString)        
    }
}