package tree;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;



public class TreeNodeComparableTest {
    /**
     * A test class for {@link tree.TreeNodeComparable}.
     *
     */
    @Test
    public void testLookup() {
        tree.TreeNodeComparable<Integer> root = new tree.TreeNodeComparable<>(5);
        root.left = Optional.of(new tree.TreeNode<>(3));
        root.right = Optional.of(new tree.TreeNode<>(7));
        root.left.get().left = Optional.of(new tree.TreeNode<>(2));
        root.left.get().right = Optional.of(new tree.TreeNode<>(4));


        assertTrue(root.lookup(5));
        assertTrue(root.lookup(7));
    }

    @Test
    public void testInsert() {
        tree.TreeNodeComparable<Integer> root = new tree.TreeNodeComparable<>(5);
        root.insert(root,3);
        root.insert(root,7);
        root.insert(root,2);
        root.insert(root,4);

        assertTrue(root.lookup(5));
        assertTrue(root.lookup(3));
        assertTrue(root.lookup(7));
        assertTrue(root.lookup(2));
        assertTrue(root.lookup(4));
    }

    @Test
    public void testMin() {
        tree.TreeNodeComparable<Integer> root = new tree.TreeNodeComparable<>(5);
        // root.setLeft(new tree.TreeNode<>(3));
        // root.setRight(new tree.TreeNode<>(7));
        // root.getLeft().setLeft(new tree.TreeNode<>(2));
        // root.getLeft().setRight(new tree.TreeNode<>(4));
        // tree.TreeNode<Integer> tree.TreeNode = new tree.TreeNode<>(root);

        root.insert(root,3);
        root.insert(root,7);
        root.insert(root,2);
        root.insert(root,4);

        int minValue = root.min();

        assertEquals(2, minValue);
    }

    @Test
    public void testMax() {
        tree.TreeNodeComparable<Integer> root = new tree.TreeNodeComparable<>(5);
        root.insert(root,3);
        root.insert(root,7);
        root.insert(root,2);
        root.insert(root,4);

        int maxValue = root.max();
        assertEquals(7, maxValue);
    }

    @Test
    public void testIsBSTValid() {
        // Create a valid binary search tree
        tree.TreeNodeComparable<Integer> root = new tree.TreeNodeComparable<>(5);
        root.insert(root,3);
        root.insert(root,7);
        root.insert(root,2);
        root.insert(root,4);

        // Check if the tree is a valid binary search tree
        assertTrue(root.isBST());
    }

}
