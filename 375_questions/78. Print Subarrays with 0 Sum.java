/**
 * Ideone: https://ideone.com/QERqgZ
 */
class Pair {
    int first, second;
    Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public static ArrayList<Pair> findSubArrays(int[] arr, int n) {
        Map<Integer, ArrayList<Integer>> hmap = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Pair> result = new ArrayList<Pair>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                result.add(new Pair(0, i));
            }

            ArrayList<Integer> temp = new ArrayList<Integer>();
            if (hmap.containsKey(sum)) {
                temp = hmap.get(sum);

                for (int j = 0; j < temp.size(); j++) {
                    result.add(new Pair(temp.get(j) + 1, i));
                }
            }
            temp.add(i);
            hmap.put(sum, temp);
        }
        return result;
    }

    public static void print(ArrayList<Pair> result) {
        for (int i = 0; i < result.size(); i++) {
            Pair p = result.get(i);
            System.out.println("Subarray found from Index "
                    + p.first + " to " + p.second);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        int n = arr.length;

        ArrayList<Pair> result = findSubArrays(arr, n);

        // if we did not find any subarray with 0 sum,
        // then subarray does not exists
        if (result.size() == 0) {
            System.out.println("No subarray exists");
        } else {
            print(result);
        }
    }
}
