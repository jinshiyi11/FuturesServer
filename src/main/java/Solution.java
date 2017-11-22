import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public int run(TreeNode root) {
        int result = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.addLast(root);
        }
        int levelCount;
        TreeNode node;
        while (queue.size() > 0) {
            result++;
            levelCount = queue.size();
            while (levelCount > 0) {
                levelCount--;
                node = queue.removeFirst();

                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left == null && right == null) {
                    return result;
                }
                if (left != null) {
                    queue.addLast(left);
                }
                if (right != null) {
                    queue.addLast(right);
                }
            }
        }

        return result;
    }
}
