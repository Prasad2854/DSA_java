import java.util.*;

public class BST {
  Node root;
  class Node{
    int value;
    Node right;
    Node left;
    
    Node(int value){
      this.value = value;
    }
  }
    
    public boolean insert(int value){
      Node newNode = new Node(value);
      if(root == null){
        root = newNode;
        return true;
      }
      
      Node temp = root;
      while (true){
        if(temp.value > value){
          if(temp.left == null){
            temp.left = newNode;
            return true;
          }
          temp = temp.left;
        }else{
          if(temp.right == null){
            temp.right = newNode;
            return true;
          }
          temp = temp.right;
        }
      } 
      
    }
    
  //bfs 
  public ArrayList<Integer> bfs(){
    Node currentNode = root;
    Queue<Node> queue = new LinkedList<>();
    ArrayList<Integer> results = new ArrayList<>();
    queue.add(currentNode);
    while(queue.size() > 0){
      currentNode = queue.remove();
      results.add(currentNode.value);
      
      if(currentNode.left != null){
        queue.add(currentNode.left);
      }
      
      if(currentNode.right != null){
        queue.add(currentNode.right);
      }
      
    }
    return results;
    
  }
  
  //root - left - right
  public ArrayList<Integer> dfspPreorder(){
    ArrayList<Integer> results = new ArrayList<>();
    class Traverse{
      Traverse(Node currentNode){
        results.add(currentNode.value);
        
        if(currentNode.left != null){
          new Traverse(currentNode.left);
        }
        
        if(currentNode.right != null){
          new Traverse(currentNode.right);
        }
      }
    }
    new Traverse(root);
    return results;
    
  }
  //left - root - right
    public ArrayList<Integer> dfspInorder(){
    ArrayList<Integer> results = new ArrayList<>();
    class Traverse{
      Traverse(Node currentNode){
        
        if(currentNode.left != null){
          new Traverse(currentNode.left);
        }
        
        results.add(currentNode.value);
        if(currentNode.right != null){
          new Traverse(currentNode.right);
        }
      }
    }
    new Traverse(root);
    return results;
    
  }
  

  //left - right - root
   public ArrayList<Integer> dfsPostorder(){
    ArrayList<Integer> results = new ArrayList<>();
    class Traverse{
      Traverse(Node currentNode){
        
        if(currentNode.left != null){
          new Traverse(currentNode.left);
        }
        
        if(currentNode.right != null){
          new Traverse(currentNode.right);
        }
        results.add(currentNode.value);
      }
    }
    new Traverse(root);
    return results;
    
  }
  
  public int treeHeight(){
    return treeHeight(root);
  }

  public int treeHeight(Node root){
    if(root == null){
      return - 1;
    }else{
      int leftSide = treeHeight(root.left);
      int rightSide = treeHeight(root.right);
      
      return Math.max(leftSide, rightSide)+1; // +1 is for root node
      
    }
  }

  public  int diameter(Node node){
    if(node == null){
      return 0;
    }
    int leftDiameter = diameter(node.left);
    int leftHeight = treeHeight(node.left);
    int rightDiameter = diameter(node.right);
    int rigtHeight = treeHeight(node.right);

    int self = leftHeight +rigtHeight +1;
    return Math.max(self, Math.max(rightDiameter, leftDiameter));
  }



public int countNodes(){
  return countNodes(root);
}

public int countNodes(Node node){
  if(node == null) return 0;

  else{
    int lCount = countNodes(node.left);
    int rCount = countNodes(node.right);

    return lCount + rCount + 1;// +1 is for root node
  }
}
 
public boolean isIdentical(Node root, Node subRoot){
  if(root == null && subRoot == null){
    return true;
  }
  else if(root == null || subRoot == null || root.value != subRoot.value){
    return false;
  }
   if(!isIdentical(root.left, subRoot.left)){
    return false;
  }
  if(!isIdentical(root.right, subRoot.right)){
    return false;
  }
  return true;
}

//this function is used for finding the starting of substree which is equal to tree(root)
public boolean isSubTree(Node root, Node subroot){ 
  if(root == null){
    return false;
  }

  if(root.value == subroot.value){
    if(isIdentical(root, subroot)){
      return true;
    }
  }

  return isSubTree(root.left, subroot) || isSubTree(root.right, subroot);
}

public void kLevel(Node root, int level, int k){
    if(root  == null){
    return;
   }

    if(level == k){
        System.out.print(root.value+" ");
        return;
    }

    kLevel(root.left, level+1, k);
    kLevel(root.right, level+1, k);
}
  int sum = 0;
  public int returnSumTree(Node root){
    if(root == null) return 0;
    else{
       sum =  returnSumTree(root.left) + returnSumTree(root.right);
    }
    return sum;
  }

  
  
    public static void main(String[] args) {
      BST b = new BST();
      // b.insert(20);
      // b.insert(13);
      // b.insert(34);
      // b.insert(14);
      // b.insert(12);
      // b.insert(45);
      // b.insert(17);
      b.insert(1);
      b.insert(2);
      b.insert(3);
      b.insert(4);
      b.insert(5);
      b.insert(6);
      b.insert(7);

      // System.out.println(b.root.right.value);
      // System.out.println(b.dfspPreorder());
      // System.out.println(b.dfspInorder());
      //  System.out.println(b.dfsPostorder());
      //  System.out.println(b.treeHeight());
      //  System.out.println(b.countNodes());
      //  System.out.println(b.diameter());
      // b.kLevel(b.root, 1, 3);
      System.out.println(b.returnSumTree(b.root));
      
  }
}