int[] constructArray(int size) {
    int[] result = new int[size];
    int k = 0;
    int i = 1;
    int j = size;
    
    while(k < size) {
        result[k++] = i++;
        if(k<size)
            result[k++] = j--;
    }
    return result;
}
