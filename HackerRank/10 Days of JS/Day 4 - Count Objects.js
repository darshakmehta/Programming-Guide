/*
 * Return a count of the total number of objects 'o' satisfying o.x == o.y.
 * 
 * Parameter(s):
 * objects: an array of objects with integer properties 'x' and 'y'
 */
function getCount(objects) {
    let count = 0;
    for(let obj of objects) {
        //console.log(obj.x);
        if(obj.x == obj.y) {
            count++;
        }
    }
    return count;
}