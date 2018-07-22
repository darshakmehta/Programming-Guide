import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<Integer>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
           
            deque.add(num);
            set.add(num);
            
            if(deque.size() == m) {
                if(set.size() > max)
                    max = set.size();
                int first = (int) deque.remove();
                if(!deque.contains(first))
                    set.remove(first);
            }
            if(max == m) //Very important optimization
                break;
        }
        System.out.println(max);
    }
}