package jianzhioffer;

public class AVLTreeDemo {


    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 6, 5, 7, 8};
        TreeNode root = new TreeNode(4);
        for (int i = 1; i < arr.length; i++) {
            creat(arr[i], root);
        }
//        search(root);

        System.out.println(findNum(root,6));
    }

    public static void creat(int val, TreeNode root) {
        if (val <= root.val) {
            if (root.left == null) {
                TreeNode node = new TreeNode(val);
                root.left = node;
            } else {
                creat(val, root.left);
            }
        }
        if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else creat(val, root.right);
        }
    }

    public static void search(TreeNode node) {
        if (node.left != null) {
            search(node.left);
        }
        if (node != null)
            System.out.print(node.val + "\t" );

        if (node.right != null)
            search(node.right);

    }

    public static TreeNode findNum(TreeNode node, int target) {
        if (node == null) {
            return null;
        } else {
            if (node.val == target) {
                return node;
            } else if (node.val < target) {
                return findNum(node.right, target);
            } else return findNum(node.left, target);

        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    //该根结点树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height() + 1, right == null ? 0 : right.height()) + 1;
    }

    //左子树高度
    public int leftHeight() {
        if (this.left == null)
            return 0;
        return this.left.height();
    }

    //右子树高度
    public int rightHeight() {
        if (this.right == null)
            return 0;
        return this.right.height();
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}