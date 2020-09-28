package binarytreedemos;

public class ListNode {
    Node root;
    public static void main(String[] args) {
        ListNode head = new ListNode();
        Node node = new Node();
        int[] arr = new int[]{30,52,54,55,56,56,1,11,13,13,23,60,60,68,69,77,77,87,88,93};
        for (int i = 0; i < arr.length; i++) {
            head.sortedTree(arr[i], head.root,i);
        }
        head.printTree(head.root);;
        System.out.println(findByvalue(11,head.root));
    }

    public void sortedTree(int x, Node node,int position) {
        if (this.root == null) {
            node = new Node();
            node.setVal(x);
            node.left = null;
            node.right = null;
            this.root = node;
            return;
        } else if (x > node.getVal()) {
            if (node.right == null) {
                Node temp = new Node();
                temp.setVal(x);
                temp.setPosition(position);
                temp.left = null;
                temp.right = null;
                node.right = temp;
            } else sortedTree(x, node.right,position);
        } else if (x <= node.getVal()) {
            if (node.left == null) {
                Node temp = new Node();
                temp.setVal(x);
                temp.setPosition(position);
                temp.left = null;
                temp.right = null;
                node.left = temp;
            } else sortedTree(x, node.left,position);
        }
    }

    public void printTree(Node node) {
        if (node.left != null)
            printTree(node.left);
        System.out.print(node.getVal()+",");
        if (node.right != null)
            printTree(node.right);
    }

    public static int findByvalue(int x,Node node){
        if (node==null){
            return -1;
        }
        if (node.val==x){
            return node.getPosition();
        }
     else if (node.val>x){
            findByvalue(x,node.left);
        }
      else   if (node.val<x){
            findByvalue(x,node.right);
        }
        return -1;
    }
}
