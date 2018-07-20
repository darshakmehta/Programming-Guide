
let getMaxLessThanK = ((n, k) => {
    let max = 0;
 
    for(let i = 1; i < n; i++) {
        for(let j = i + 1; j <= n; j++ ) {
            let x = i & j;
            
            if(x > max && x < k) {
                max = x;
            }
        }
    }
    return max;
})