package tree;

import java.util.Optional;

public class TreeNodeComparable<T extends Comparable<T>> extends TreeNode<T>{

    public TreeNodeComparable(T value) {
        super(value);
    }

    public boolean lookup(T value){
        return lookupRec(this, value);
    }

    public boolean lookupRec(TreeNode<T> node, T value){
        if (node == null)
            return false;

        int cmp = value.compareTo(node.value());
        if (cmp == 0) {
            return true; // Value found
        } else if (cmp < 0) {
            if(!node.left().isEmpty())
            return lookupRec(node.left().get(), value);
        } else {
            if(!node.right().isEmpty())
            return lookupRec(node.right().get(), value);
        }
        return false;
    }


    public TreeNode<T> insert(TreeNode<T> node, T value){
        return insertRec(node, value);


    }

    private TreeNode<T> insertRec(TreeNode<T> node, T value){
        if (node == null)
            return new TreeNodeComparable<>(value);

        int cmp = value.compareTo(node.value());
        if (cmp < 0) {
            node.left = Optional.of(insertRec(!node.left().isEmpty() ? node.left().get() : null, value));
        }
        else  if(cmp>0){
            node.right = Optional.of(insertRec(!node.right().isEmpty() ? node.right().get() : null, value));

        }
        return node;
    }


    public int min(){
        TreeNode<T> presentNode = this;
        while (presentNode.left().isPresent()) {
            presentNode = presentNode.left().get();
        }
        T val = presentNode.value();
        if(val!=null){
            return Integer.parseInt(val.toString());
        }
        return 0;
    }

    public int max(){
        TreeNode<T> presentNode = this;
        while (presentNode.right().isPresent()) {
            presentNode = presentNode.right().get();
        }
       T val = presentNode.value();
        if(val!=null){
            return Integer.parseInt(val.toString());
        }
    return  -1;
    }

    public boolean isBST(){
        return isBSTRec(this, null, null);
    }

    private boolean isBSTRec(TreeNode<T> node, T min, T max) {
        if (node == null)
            return true;

        T nodeValue = node.value();
        if ((min != null && nodeValue.compareTo(min) <= 0) || (max != null && nodeValue.compareTo(max) >= 0))
            return false;

        return isBSTRec(node.left().orElse(null), min, nodeValue) && isBSTRec(node.right().orElse(null), nodeValue, max);
    }


}

