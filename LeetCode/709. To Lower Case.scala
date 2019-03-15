object Solution {
    def toLowerCase(str: String): String = {
        str.map(c => if (c >= 65 & c <= 90) (c + 32).asInstanceOf[Char] else c)
    }
}