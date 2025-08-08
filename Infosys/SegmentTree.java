package Infosys;

public class SegmentTree {
    
    Node root;
    private class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }


    }

    public SegmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end){
        //leaf node condition
        if(start == end){
            Node leafNode = new Node(start, end);
            leafNode.data = arr[start];
            return leafNode;
        }

        Node node = new Node(start, end);
        int mid = (start + end)/2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid+1, end);

        node.data = node.left.data + node.right.data;
        return node;
    }

    public int query(Node node, int qsi, int qei) {
      if (node.startInterval >= qsi && node.endInterval <= qei) {
          return node.data;
      } else if (node.startInterval > qei || node.endInterval < qsi) {
          return 0;
      } else {
          return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
      }
  }


    public void update(int index, int value) {
        this.root.data = update(this.root, index, value);
      }
      //2 -> 10
      private int update(Node node, int index, int value) {
        if (index >= node.startInterval&& index <= node.endInterval){
          if(index == node.startInterval && index == node.endInterval) {
            node.data = value;
            return node.data;
          } else {
            int leftAns = update(node.left, index, value);
            int rightAns = update(node.right, index, value);
            node.data = leftAns + rightAns;
            return node.data;
          }
        }
        return node.data;
      }

    public static void main(String[] args){
        int[] arr = {3, 4, 5, 6, 7};
        SegmentTree s = new SegmentTree(arr);
        System.err.println(s.query(s.root, 2, 6));

    }
}
