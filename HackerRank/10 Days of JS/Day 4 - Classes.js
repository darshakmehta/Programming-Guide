/*
 * Implement a Polygon class with the following properties:
 * 1. A constructor that takes an array of integer side lengths.
 * 2. A 'perimeter' method that returns the sum of the Polygon's side lengths.
 */

class Polygon {
    constructor(side) {
        this.side = side;

    }
    perimeter() {
       let ans = 0;
        let side = this.side;
        for(let s = 0; s < side.length; s++)
            ans+=side[s];
        return ans;
    };
}