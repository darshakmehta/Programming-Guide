/**
 * Given two lists V1 and V2 of sizes n and m respectively. Return the list of elements common to both the lists and
 * return the list in sorted order. Duplicates may be there in the output list.
 *
 * Input:
 * 5
 * 3 4 2 2 4
 * 4
 * 3 2 2 7
 *
 * Output:
 * 2 2 3
 */

public static ArrayList<Integer> common_element(ArrayList<Integer>v1,ArrayList<Integer>v2) {
    int n1 = v1.size();
    int n2 = v2.size();
    int[]arr1 = new int[n1];
    int[]arr2 = new int[n2];

    for(int i = 0 ; i < n1; i++){
        arr1[i] = v1.get(i).intValue();
    }

    for(int i = 0; i < n2; i++){
        arr2[i] = v2.get(i).intValue();
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    ArrayList<Integer> result = new ArrayList<Integer>();

    int i = 0, j = 0, k = 0;

    while (i < n1 && j < n2) {
        if (arr1[i] == arr2[j]) {
            result.add(arr1[i]);
            i++; j++;
        } else if (arr1[i] < arr2[j]) {
            i++;
        } else {
            j++;
        }
    }

    return result;
}
