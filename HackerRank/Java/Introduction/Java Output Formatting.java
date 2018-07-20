import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                String n = "";
                //Complete this line
                for(int j = 0; j < s1.length(); j++) {
                    System.out.print(s1.charAt(j));
                }
                for(int j = s1.length(); j < 15; j++) {
                    System.out.print(" ");
                }
                if(x >= 100) {
                    n = x + "";
                } else if(x >= 10){
                    n = "0" + x;
                } else {
                    n = "0" + x + "0";
                }
                System.out.println(n);
            }
            System.out.println("================================");

    }
}



