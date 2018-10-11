/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    var result = -1;
    var flag = false;
    if(haystack.length === 0 && needle.length === 0) {
        return 0;
    } else if (haystack.length < needle.length) {
        return result;
    } else {
        for(var i = 0; i < haystack.length; i++) {
            var k = i;
            result = i;
            for(var j = 0; j < needle.length; j++) {
                if(k < haystack.length && haystack[k] === needle[j]) {
                    k++;
                    flag = true;
                } else {
                    flag = false;
                    result = -1;
                    break;
                }
            }
            if(flag === true)
                return result;
        }
    }
    return result;
    
};