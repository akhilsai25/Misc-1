/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 // This uses a queue to go through the list and traverse on each depth
 // At each depth in bfs, if its integer we multiply with depth or else if its list we iterate and add all the elements back to queue to go over them in next depth
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList();
        queue.addAll(nestedList);
        //queue.add(nestedList);
        int depth = 1, total = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                NestedInteger ne = queue.poll();
                if(ne.isInteger()) {
                    total+=depth*ne.getInteger();
                } else {
                    queue.addAll(ne.getList());
                }
            }
            depth++;
        }
        return total;
    }
}
