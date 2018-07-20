/*
 * Complete the reverseString function
 * Use console.log() to print to stdout.
 */
function reverseString(s) {
    try {
        let arr = s.split("");
        let reverseArray = arr.reverse();
        let joinArray = arr.join("");
        s = joinArray;
        
    } catch (e) {
        console.log(e.message);    
    } finally {
        console.log(s);
    }
}