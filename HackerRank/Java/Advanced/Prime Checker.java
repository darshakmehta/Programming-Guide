import static java.lang.System.in;  //Important step for getting rid of BufferedReader compile time error
class Prime {
    public void checkPrime(int ...a) { //use of varags
        for(int i : a) {
           BigInteger b = BigInteger.valueOf(i);
           boolean flag = b.isProbablePrime(5); //increase the certainty to pass all the test cases
            if(flag)
                System.out.print(i + " ");
        }
        System.out.println();
    }
}