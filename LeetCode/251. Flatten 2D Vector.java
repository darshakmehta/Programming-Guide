public class Vector2D {
    private Iterator<List<Integer>> outer;
    private Iterator<Integer> inner;
 
    public Vector2D(List<List<Integer>> vec2d) {
        outer = vec2d.iterator();
        inner = Collections.emptyIterator(); //inner = outer.iterator(); wrong: if outer is null, then exception
    }
 
    public int next() {
        return inner.next();
    }
 
    public boolean hasNext() {
        if (inner.hasNext()) {
            return true;
        }
        if (!outer.hasNext()) {
            return false;
        }
        inner = outer.next().iterator();
        while(!inner.hasNext() && outer.hasNext()) {
            inner = outer.next().iterator();
        }
        return inner.hasNext();
    }
}
 
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */