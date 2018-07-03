import java.lang.*;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
       int t;
       Scanner sc = new Scanner(System.in);
       t = sc.nextInt();
       while(t != 0) {
           int numberOfStudent = sc.nextInt();
           int boys = sc.nextInt();
           int girls = sc.nextInt();
           int a[] = new int[numberOfStudent];
           int index = 0;
           
           if(Math.abs(boys - girls) > 1)
                System.out.println("Little Jhool wins!");
            else
                System.out.println("The teacher wins!");
           
           t--;
       }

    }
}
