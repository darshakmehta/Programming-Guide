function regexVar() {
    /*
     * Declare a RegExp object variable named 're'
     * It must match ALL occurrences of numbers in a string.
     */
    
    let re = new RegExp('[0-9]+','g');
    /*
     * Do not remove the return statement
     */
    return re;
}