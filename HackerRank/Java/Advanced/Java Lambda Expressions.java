   // Write your code here
 public PerformOperation isOdd() {
     return num -> (num % 2 != 0);
 }
 public PerformOperation isPrime() {
     return num -> java.math.BigInteger.valueOf(num).isProbablePrime(1);
 }
 public PerformOperation isPalindrome() {
     return num -> Integer.toString(num).equals( new StringBuilder(Integer.toString(num)).reverse().toString() );
 }
}
