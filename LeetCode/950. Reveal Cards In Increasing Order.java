class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] result = new int[deck.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for ( int i = 0; i < deck.length; i++ ) {
            queue.add(i);
        }
        
        for ( int i = 0; i < deck.length; i++ ) {
            result[queue.poll()] = deck[i];
            queue.add(queue.poll());
        }
        
        return result;
    }
}
