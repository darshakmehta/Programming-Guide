	// Add your code here
    Difference(int []elements) {
        this.elements = elements;
        maximumDifference = 0;
    }
    public void computeDifference() {
        for(int i = 0; i < elements.length; i++) {
            for(int j = 0; j < elements.length - 1; j++) {
            maximumDifference = Math.max(maximumDifference, 
                                         Math.abs(elements[i] - elements[j]));    
            }
        }
        
    }