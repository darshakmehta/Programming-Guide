object Solution {
    def hammingDistance(x: Int, y: Int): Int = {
        Integer.bitCount(x ^ y);
    }
}
