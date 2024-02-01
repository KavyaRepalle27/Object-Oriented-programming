package tree;

import java.util.Optional;

public class TreeNode<T> {
    private T value;
    public Optional<TreeNode<T>> left;
    public Optional<TreeNode<T>> right;
    public TreeNode(T value) {
        this.value = value;
        this.left = Optional.empty();
        this.right = Optional.empty();
    }

    Optional<TreeNode<T>> left() { return this.left;} // TODO
    Optional<TreeNode<T>> right() {return this.right;} // TODO
    T value() {return this.value;}
    public void setLeft(Optional<TreeNode<T>> left) {
        this.left = left;
    }

    public void setRight(Optional<TreeNode<T>> right) {
        this.right = right;
    }

   

    public boolean lookup(T targetValue) {
        if(targetValue == null){
            throw new IllegalArgumentException("Target value cannot be null");
        }
            // Check if the current node has the target value
            if (this.value.equals(targetValue)) {
                return true;
            }
        
            // Check in the left subtree if it exists
            if (left.isPresent() && left.get().lookup(targetValue)) {
                return true;
            }
        
            // Check in the right subtree if it exists
            if (right.isPresent() && right.get().lookup(targetValue)) {
                return true;
            }
        
            // Target value not found in the current node or its subtrees
            return false;
        }
    

   

   

    public String printInorder(){
        return printInorder(Optional.of(this));
        // could be Optional.ofNullable(this)
    }

    private static <T> String printInorderNonNull(TreeNode<T> node) {
        return printInorder(node.left()) + node.value() + printInorder(node.right());
    }   

    static <T> String printInorder(Optional<TreeNode<T>> node) {
        if(node==null || node.isEmpty()){
            return "";
        }
    return node.map(TreeNode::printInorderNonNull)
               .orElse("");
    }

    public String printPreorder(){
    
       
        return printPreorderH(this);

    }

    public String printPreorderH(TreeNode<T> node){
        
        if (node == null) {
          return "";
        } 
         StringBuilder s = new StringBuilder();
        s.append(node.value()).toString();
    
        if(!node.left().isEmpty())
         s.append(printPreorderH(node.left().get()));
        if(!node.right().isEmpty())
         s.append(printPreorderH(node.right().get()));
         return s.toString();
    }



    private TreeNode<T> orElse(Object object) {
        return null;
    }
    public String printPostorder(){
        return printPostorderH(this);

    }

    public String printPostorderH(TreeNode<T> node){
        
        if (node == null) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        if(!node.left().isEmpty())
        s.append(printPostorderH(node.left.get()));
        if(!node.right().isEmpty())
            s.append(printPostorderH(node.right.get()));

        s.append(node.value()).toString();
        return s.toString();
    }

    public int size(){
        
        return sizeR(this);
        

    }

    private int sizeR(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        int l=0,r =0;
        if(!node.left().isEmpty())
             l =sizeR(node.left.get());
        if(!node.right().isEmpty())
             r =sizeR(node.right.get());

            return  l+r+1;
        
    
    }

    public int height(){
        return heightR(this);
        
    }

    private static <T> int heightR(TreeNode<T> treeNode) {
         if (treeNode == null) {
            return -1;
         }
        int l=0,r =0;
        if(!treeNode.left().isEmpty())
            l =heightR(treeNode.left.get());
        if(!treeNode.right().isEmpty())
            r =heightR(treeNode.right.get());

        return Math.max(l,r) + 1;
    
    }
    

    public void mirror() {
        mirrorR(this);
        
       }
    
    private  void mirrorR(TreeNode<T> node) {

            if (node == null)
                return;
        if(!node.left().isEmpty()) {
            TreeNode<T> temp = node.left().get();
            node.left = node.right;
            node.right = Optional.ofNullable(temp);

            mirrorR(node.left.get());
        }
        if(!node.right().isEmpty())
            mirrorR(node.right.get());



    }


    public void doubleTree() {
        doubleTreeR(this);
    }

    private static <T> void doubleTreeR(TreeNode<T> node) {
        if (node == null) {
            return;
        }

// Recursively apply the doubleTree operation to the right subtree
    doubleTreeR(node.right.orElse(null));

  // Create a new node with the same value as the current node
    TreeNode<T> duplicateNode = new TreeNode<>(node.value());
     duplicateNode.left = node.left;
  // Wrap the duplicateNode in an Optional and insert it as the left child of the current node
    node.left = Optional.of(duplicateNode);

  // Recursively apply the doubleTree operation to the left and right subtrees
     doubleTreeR(duplicateNode.left.orElse(null));


}

    public boolean sameTree(TreeNode<T> other) {
        // TODO 
        return sameTreeR(this, other);
       }

        private  boolean sameTreeR(TreeNode<T> node, TreeNode<T> other) {
            if (node == null && other == null
                    || (node.left().isEmpty() && other.left().isEmpty())
                    || (node.right().isEmpty() && other.right().isEmpty())) {
                return true;
            }
            return node.value().equals(other.value()) &&
                    sameTreeR(node.left().get(), other.left().get()) &&
                    sameTreeR(node.right().get(), other.right().get());

        }


    
}
