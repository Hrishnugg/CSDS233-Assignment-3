public class Main {
    public static void main(String[] args) {
        System.out.println("Binary Search Tree Creation with initial values: 7, 12, 4, 9, 2, 15, 18, 6" );
        BinarySearchTree bst = new BinarySearchTree();
        int[] intitalValues = {7, 12, 4, 9, 2, 15, 18, 6};
        bst.createTree(intitalValues);
        System.out.println("In order traversal of created tree");
        bst.inorderRec();
        System.out.println("Pre order traversal of created tree");
        bst.preorderRec();
        System.out.println("Post order traversal of created tree");
        bst.postorderRec();
        // Insert values into the tree
        bst.insert(17);
        System.out.println("In order traversal after inserting 17");
        bst.inorderRec();
        bst.insert(3);
        System.out.println("In order traversal after inserting 3");
        bst.inorderRec();
        System.out.println("Find kth smallest node in the tree");
        Node kth = bst.kthSmallest(4);
        System.out.println("4th smallest:" + kth.getData());
        kth = bst.kthSmallest(6);
        System.out.println("6th smallest:" + kth.getData());
        System.out.println("Deleting 12 from the tree");
        bst.delete(12);
        System.out.println("In order traversal after deletion");
        bst.inorderRec();
        System.out.println("Deleting 2 from the tree");
        bst.delete(2);
        System.out.println("In order traversal after deletion");
        bst.inorderRec();
        System.out.println("Deleting 9 from the tree");
        bst.delete(9);
        System.out.println("In order traversal after deletion");
        bst.inorderRec();
    }
}