static class TestDataEmptyArray {
    public static int[] get_array() {
        // complete this function
        int arr[] = {};
        return arr;
    }
}

static class TestDataUniqueValues {
    public static int[] get_array() {
        // complete this function
        int a[] = {2, 1, 3, 4, 5};
        return a;
    }

    public static int get_expected_result() {
        // complete this function
        return 1;  
    }
}
 
static class TestDataExactlyTwoDifferentMinimums {
   
    public static int[] get_array() {
        // complete this function
       int a[] = {1, 2, 1};
        return a;
    }

    public static int get_expected_result() {
        // complete this function
        return 0;   
    }
}