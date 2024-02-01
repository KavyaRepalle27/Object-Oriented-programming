package tree;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;



public class TreeNodeTest {

    tree.TreeNode<String> root;

   
    @Test
    public void testPrintInorder() {
        // Create a sample tree
        tree.TreeNode<Integer> root = new tree.TreeNode<>(1);
        root.left = Optional.of(new tree.TreeNode<>(2));
        root.right = Optional.of(new tree.TreeNode<>(3));
        root.left.get().left = Optional.of(new tree.TreeNode<>(4));
        root.left.get().right = Optional.of(new tree.TreeNode<>(5));

        // Test printInorder
        assertEquals("42513", root.printInorder());
    }



    @Test
    public void testPrintInorderSingleNode() {
        // Create a tree with a single node
        tree.TreeNode<Integer> singleNodeTree = new tree.TreeNode<>(1);

        // Test printInorder on a single node tree
        assertEquals("1", singleNodeTree.printInorder());
    }

      

    @Test
    public void testPrintPostorder() {

        root = new tree.TreeNode<>("A");
        root.left= Optional.of(new tree.TreeNode<>("B"));
        root.right=Optional.of(new tree.TreeNode<>("C"));
        root.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        root.left.get().right=Optional.of(new tree.TreeNode<>("E"));
        String expectedPostorder = "DEBCA";

        String actualPostorder = root.printPostorder();

        assertEquals(expectedPostorder, actualPostorder);
    }
    @Test
    public void testPreOrder(){
        root = new tree.TreeNode<>("A");
        root.left= Optional.of(new tree.TreeNode<>("B"));
        root.right=Optional.of(new tree.TreeNode<>("C"));
        root.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        root.left.get().right=Optional.of(new tree.TreeNode<>("E"));
        String expectedPreorder = "ABDEC";
        String actualPreorder = root.printPreorder();
        assertEquals(expectedPreorder, actualPreorder);
    }

    @Test
    public void testSize() {
        root = new tree.TreeNode<>("A");
        root.left= Optional.of(new tree.TreeNode<>("B"));
        root.right=Optional.of(new tree.TreeNode<>("C"));
        root.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        root.left.get().right=Optional.of(new tree.TreeNode<>("E"));
        int expectedSize = 5;
        int actualSize = root.size();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testHeight() {
        root = new tree.TreeNode<>("A");
        root.left= Optional.of(new tree.TreeNode<>("B"));
        root.right=Optional.of(new tree.TreeNode<>("C"));
        root.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        root.left.get().right=Optional.of(new tree.TreeNode<>("E"));
       
        int expectedHeight = 3;
        int actualHeight = root.height();
        assertEquals(expectedHeight, actualHeight);
    }
   
    @Test 
    public void testMirror() {
        TreeNode<Integer>rooNode = new TreeNode<>(1);
        rooNode.left = Optional.of(new TreeNode<>(3));
        rooNode.right = Optional.of(new TreeNode<>(2));
        rooNode.right.get().left = Optional.of(new TreeNode<>(5));
        rooNode.right.get().right = Optional.of(new TreeNode<>(4));
        assertEquals("13254", rooNode.printPreorder());

        rooNode.mirror();
        assertEquals("12453", rooNode.printPreorder());
                
        root = new tree.TreeNode<>("A");
        root.left= Optional.of(new tree.TreeNode<>("B"));
        root.right=Optional.of(new tree.TreeNode<>("C"));
        root.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        root.left.get().right=Optional.of(new tree.TreeNode<>("E"));
       
        tree.TreeNode<String> TreeNode = root;
        
        TreeNode.mirror();

        tree.TreeNode<String> expectedRoot = new tree.TreeNode<>("A");
        expectedRoot.left= Optional.of(new tree.TreeNode<>("C"));
        expectedRoot.right=Optional.of(new tree.TreeNode<>("B"));
        expectedRoot.right.get().left=Optional.of(new tree.TreeNode<>("E"));
        expectedRoot.right.get().right=Optional.of(new tree.TreeNode<>("D"));
      
       
        assertTrue( expectedRoot.sameTree(TreeNode));
    }
      

    @Test
    public void testDoubleTree() {
        tree.TreeNode<Integer>  root = new tree.TreeNode<>(2);
        root.left = Optional.of(new tree.TreeNode<>(1));
        root.right = Optional.of(new tree.TreeNode<>(3));
        root.left.get().left = Optional.of(new tree.TreeNode<>(0));
        root.left.get().right = Optional.of(new tree.TreeNode<>(4));
        root.right.get().right = Optional.of(new tree.TreeNode<>(5));

      
        assertEquals("210435", root.printPreorder());
        root.doubleTree();
        assertEquals("221100443355", root.printPreorder());


      
    }

   
   

    @Test 

     public void testSameTree() {
        root = new tree.TreeNode<>("A");
        root.left= Optional.of(new tree.TreeNode<>("B"));
        root.right=Optional.of(new tree.TreeNode<>("C"));
        root.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        root.left.get().right=Optional.of(new tree.TreeNode<>("E"));
        tree.TreeNode<String> expectedRoot = new tree.TreeNode<>("A");
        expectedRoot.left= Optional.of(new tree.TreeNode<>("B"));
        expectedRoot.right=Optional.of(new tree.TreeNode<>("C"));
        expectedRoot.left.get().left=Optional.of(new tree.TreeNode<>("D"));
        expectedRoot.left.get().right=Optional.of(new tree.TreeNode<>("E"));
        
    



        assertTrue(root.sameTree(expectedRoot));

    }
}

