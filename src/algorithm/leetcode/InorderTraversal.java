package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode left = current.left;
                current.left = null;
                stack.push(current);
                current = left;
            } else {
                list.add(current.val);
                if (current.right != null) {
                    current = current.right;
                } else {
                    if (stack.isEmpty()) {
                        break;
                    }
                    current = stack.pop();
                }
            }
        }
        return list;
    }


}



