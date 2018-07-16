//Write your code here
Set<String> a = new HashSet<String>();
Set<String> b = new HashSet<String>();
int count = 0;
for(int i = 0; i < t; i++) {
    if(!a.contains(pair_left[i])) {
        a.add(pair_left[i]);
        b.add(pair_right[i]);
        count++;
    } else {
        if(!b.contains(pair_right[i])) {
            b.add(pair_right[i]);
            count++;
        }
    }
    System.out.println(count);
}

/*** 

Code fails for
5
a b
a b
b b
c d
e f

***/

//Correct Code

//Write your code here
Set<String> set = new HashSet<String>();
int count = 0;
for(int i = 0; i < t; i++) {
    if(!(set.contains(pair_left[i] + " " + pair_right[i]))) {
        set.add(pair_left[i] + " " + pair_right[i]);
        count++;
    }
    System.out.println(count);
}
