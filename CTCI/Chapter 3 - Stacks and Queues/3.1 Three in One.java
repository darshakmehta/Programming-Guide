/***

TODO:

Solution 1: Fixed Division

We can divide into fixed number of spaces for each stack and proceed with single array. Note: If we have prior information about Stack 1 going to get used more, we can allocated larger space to it than other stacks.

Solutio 2: Flexbile Division

Plan to have flexible stack size, by allocating space from other stacks, if needed. Also, try to wrap last stack to the beginning of the array (Circular array concept)

P.S.: If the code gets larger, try to modularized and write clean and maintainable code. Try using additional classes to separate important chunk of codes.

***/