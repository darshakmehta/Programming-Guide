object Solution {
    def numJewelsInStones(J: String, S: String): Int = {
        var res = 0;
        
        for(s <- S.toList) {
            if(J.toList contains s) res = res + 1
        }
        
        res
    }
}