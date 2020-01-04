1. Read about Hash Table vs BST here https://www.geeksforgeeks.org/advantages-of-bst-over-hash-table/
2. Number of unique BSTs with n distinct keys is Catalan Number [https://www.geeksforgeeks.org/g-fact-18/]
3. Optimization to above code for two children case :
In the above recursive code, we recursively call delete() for successor. We can avoid recursive call by keeping track of parent node of successor so that we can simply remove the successor by making child of parent as NULL. We know that successor would always be a leaf node.
[https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/]
4. http://cslibrary.stanford.edu/110/BinaryTrees.html
