class SumInLeavesVisitor extends TreeVis {
    private int result = 0;
    
    public int getResult() {
      	//implement this
        return result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private long result = 1;
    private final int M = 1000000007;
    
    public int getResult() {
      	//implement this
        return (int) result;
    }

    public void visitNode(TreeNode node) {
      	//implement this
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
      	//implement this
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafEvenDepthSum = 0;
    private int greenLeavesSum = 0;
    
    public int getResult() {
      	//implement this
        return Math.abs(nonLeafEvenDepthSum - greenLeavesSum);
    }

    public void visitNode(TreeNode node) {
    	//implement this
        if (node.getDepth() % 2 == 0) {
            nonLeafEvenDepthSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
    	//implement this
        if (leaf.getColor() == Color.GREEN) {
            greenLeavesSum += leaf.getValue();
        }
    }
}

public class Solution {
    private static int [] values;
    private static Color [] colors;
    private static HashMap<Integer, HashSet<Integer>> map;
    
    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        Scanner sc = new Scanner(System.in);
        int numNodes = sc.nextInt();
        values = new int[numNodes];
        colors = new Color[numNodes];
        map = new HashMap<>(numNodes);
        for(int i = 0; i < numNodes; i++) {
            values[i] = sc.nextInt();
        }
        for (int i = 0; i < numNodes; i++) {
            colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }
        
        /* Save edges */
        for (int i = 0; i < numNodes - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            /* Edges are undirected: Add 1st direction */
            HashSet<Integer> uNeighbors = map.get(u);
            if (uNeighbors == null) {                
                uNeighbors = new HashSet<>();
                map.put(u, uNeighbors);
            }
            uNeighbors.add(v);
            
            /* Edges are undirected: Add 2nd direction */
            HashSet<Integer> vNeighbors = map.get(v);
            if (vNeighbors == null) {
                vNeighbors = new HashSet<>();
                map.put(v, vNeighbors);
            }
            vNeighbors.add(u);
            }
            sc.close();
             /* Handle 1-node tree */
            if (numNodes == 1) {
                return new TreeLeaf(values[0], colors[0], 0);
            }

            /* Create Tree */
            TreeNode root = new TreeNode(values[0], colors[0], 0);
            addChildren(root, 1);
            return root;
       
    }
    
    

    /* Recursively adds children of a TreeNode */
    private static void addChildren(TreeNode parent, Integer parentNum) {
        /* Get HashSet of children and loop through them */
        for (Integer treeNum : map.get(parentNum)) {
            map.get(treeNum).remove(parentNum); // removes the opposite arrow direction
            
            /* Add child */
            HashSet<Integer> grandChildren = map.get(treeNum);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            Tree tree;
            if (childHasChild) {
                tree = new TreeNode(values[treeNum - 1], colors[treeNum - 1], parent.getDepth() + 1);
            } else {
                tree = new TreeLeaf(values[treeNum - 1], colors[treeNum - 1], parent.getDepth() + 1);
            }
            parent.addChild(tree);

            /* Recurse if necessary */
            if (tree instanceof TreeNode) {
                addChildren((TreeNode) tree, treeNum);
            }
        }
    }
/***

Source: https://www.hackerrank.com/challenges/java-vistor-pattern/forum/comments/259575

***/
