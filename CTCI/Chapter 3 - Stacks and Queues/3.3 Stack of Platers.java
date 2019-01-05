/***

TODO: 

1. Goal: SetOfStacks with initial capacity, if filled move the next element to the next stack.

Implementation:

1. So to move to the new stack, we can have ArrayList of stacks to manage the lastStack() in use.
ArrayList<Stack> stack = new ArrayList<Stack>();

2. if first stack is equal to capacity, move the new element to new stack, and the new stack reference to the above ArrayList.

3. Now to get push always, getLastStack() from ArrayList and check if it is full, if it is full, make new stack and add to ArrayList, else push the new value to getLastStack()

4. While popping check for the getLastStack(), and pop value, once you are removing last element of stack, free the stack by removing from ArrayList.


Follow up: Implement popAt(int index)

Here, index of the Stack is provided. Lets consider pop removes the top element of the first stack so we have rollover all the elements one position before, that is element at bottom of second stack will move to the top of first stack. This will have high complexity, so we can discuss trade-offs and decide to keep the stack half empty to avoid such situations.

***/