/** 

Approach

1. Reverse List
2. Add 1 to first (actually last element).
3. If (there is a carry) move head to next and add until carry is 0.
4. If in the end carry is 1, add a new_node and append to the last element (Actually first element)
5. Reverse the list

Example: 

I. 

1 => 2 => 4

1. 4 => 2 => 1
2. 5 => 2 => 1
3. Reverse and return (since carry is 0)

II.

9 => 9 => 9

1. 9 => 9 => 9 (Reverse)
2. 0 => 9 => 9 (Carry = 1)
3. 0 => 0 => 9 (Carry  = 1)
4. 0 => 0 => 0 (Carry = 1)
5. 0 => 0 => 0 => 1 (new_node)
6. Reverse and return


*/