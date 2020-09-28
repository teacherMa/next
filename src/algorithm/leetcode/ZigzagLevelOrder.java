package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;
        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.remove();
                if (reverse) {
                    row.add(0, node.val);
                } else {
                    row.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            reverse = !reverse;
            result.add(row);
        }
        return result;
    }
}
