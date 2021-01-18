class StockSpanner {

    int value;
    int span;
    Stack<StockSpanner> stack;

    public StockSpanner() {
        stack = new Stack<StockSpanner>();
    }

    public StockSpanner(int value, int span) {
        this.value = value;
        this.span = span;
    }

    public int next(int price) {

        int current_span = 1;
        while (!this.stack.isEmpty() && stack.peek().value <= price) {
            current_span += this.stack.pop().span;
        }

        stack.push(new StockSpanner(price, current_span));

        return stack.peek().span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
