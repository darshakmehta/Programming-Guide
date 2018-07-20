public class Solution {
// Write your code here.
Stack<Character> stacky;
Queue<Character> queuey;

public Solution() {
    stacky = new Stack<Character>();
    queuey = new LinkedList<Character>();
}
public void pushCharacter(char c) {
    stacky.push(c);
}
public void enqueueCharacter(char c) {
    queuey.add(c);
}

public char popCharacter() {
    return (char) stacky.pop();
}

public char dequeueCharacter() {
    return (char) queuey.remove();
}
