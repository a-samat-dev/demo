package com.example.demo;

public class Runner {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(-10);
        root.left = new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.left.left = new TreeNode<>(12);
        root.left.right = new TreeNode<>(11);
        root.right.left = new TreeNode<>(15);
        root.right.right = new TreeNode<>(7);

//        -10
//        9     20
//     12  11  15  7
//        32 - 10 + 42 =
        int res = maxPathSum(root);
        System.out.println(max);
    }

    public static int maxPathSum(TreeNode<Integer> root) {
        rec(root);

        return max;
    }

    private static int rec(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int sum = root.data;
        int leftSum = rec(root.left);

        if (sum + leftSum > sum) {
            sum += leftSum;
        }

        int rightSum = rec(root.right);
        if (sum + rightSum > sum) {
            sum += rightSum;
        }

        max = Math.max(max, sum);

        return sum;
    }

    static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
