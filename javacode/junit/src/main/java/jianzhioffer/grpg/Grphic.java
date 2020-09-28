package jianzhioffer.grpg;


import java.util.ArrayList;
import java.util.List;

public class Grphic {


    public Node cloneGraph(Node node) throws CloneNotSupportedException {
        if (node == null)
            return null;
        Toole toole=new Toole();
        toole.node=node;
        Toole t= (Toole) toole.clone();

        return t.node;
    }


    class Toole implements Cloneable {
        Node node ;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    private void gteAll(Node node1, Node node) {
        if (node.neighbors != null) {

        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


}
