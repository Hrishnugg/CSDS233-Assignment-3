public class BinarySearchTree {
    private Node treeRoot = null;
    private Node kthNode = null;
    private int nodeCount = 0;
    private boolean kthFound = false;

    public void insert(int key){
        Node newNode = new Node(key);
        if (treeRoot == null){
            treeRoot = newNode;
            return;
        }
        Node current = treeRoot;
        Node parent = null;
        // Find the position to insert by traversing down the Tree.
        while (current != null){
            parent = current;
            if (key < current.getData()){
                current = current.getlChild();
            }
            else {
                current = current.getrChild();
            }
        }
        //Parent cannot be null here, perform insertion.
        if (key < parent.getData()){
            parent.setlChild(newNode);
        }
        else {
            parent.setrChild(newNode);
        }
    }
    public void createTree(int[] values){
        //Insert all elements in the given Array one by one into the tree.
        for (int i = 0; i < values.length; i++) {
            insert(values[i]);
        }
    }
    public Node search(int key){
        Node current = treeRoot;
        while (current != null){
            if (key == current.getData()){
                return current;
            }
            if (key < current.getData()){
                current = current.getlChild();
            }
            else {
                current = current.getrChild();
            }
        }
        //We didn't find the key in the tree.
        return null;
    }
    public Node delete(int key){
        Node current = treeRoot;
        Node parent = null;
        Node deletedNode = null;
        while (current != null){
            if (key == current.getData()){
                 deletedNode = current;
                 break;
            }
            parent = current;
            if (key < current.getData()){
                current = current.getlChild();
            }
            else {
                current = current.getrChild();
            }
        }
        // Node not found case
        if (deletedNode == null){
            return null;
        }
        // Case 1 and 2: deletedNode has no children, or only one child
        if (deleteNodeOneChild(parent, deletedNode) != null){
            return deletedNode;
        }
        // Case 3: deletedNode has 2 children
        // Find inOrder successor
        Node successor = deletedNode.getrChild();
        parent = deletedNode;
        while (successor.getlChild() != null){
            parent = successor;
            successor = successor.getlChild();
        }
        // Swap values of deletedNode with successor
        int temp = deletedNode.getData();
        deletedNode.setData(successor.getData());
        successor.setData(temp);
        deletedNode = deleteNodeOneChild(parent, successor);
        return deletedNode;
    }
    private Node deleteNodeOneChild(Node parent, Node deletedNode){
        //Case 1: deletedNode has no children
        if (deletedNode.getlChild() == null && deletedNode.getrChild() == null){
            if (parent == null){
                treeRoot = null;
                return deletedNode;
            }
            if (parent.getlChild() == deletedNode){
                parent.setlChild(null);
            }
            else {
                parent.setrChild(null);
            }
            return deletedNode;
        }
        // Case 2: deletedNode has one child
        if (deletedNode.getlChild() == null || deletedNode.getrChild() == null){
            Node successor = deletedNode.getlChild();
            if (successor == null){
                successor = deletedNode.getrChild();
            }
            if (parent.getlChild() == deletedNode){
                parent.setlChild(successor);
            }
            else {
                parent.setrChild(successor);
            }
            return deletedNode;
        }
        return null;
    }
    public void inorderRec(){
        inOrderTraverse(treeRoot);
        // Add a new line after printing all the tree nodes.
        System.out.println();
    }
    private void inOrderTraverse(Node root){
        if(root == null){
            return;
        }
        inOrderTraverse(root.getlChild());
        //Print the key.
        System.out.printf("%d ", root.getData());
        inOrderTraverse(root.getrChild());
    }
    public void preorderRec(){
        preOrderTraverse(treeRoot);
        // Add a new line after printing all the tree nodes.
        System.out.println();
    }
    private void preOrderTraverse(Node root){
        if(root == null){
            return;
        }
        //Print the key.
        System.out.printf("%d ", root.getData());
        preOrderTraverse(root.getlChild());
        preOrderTraverse(root.getrChild());
    }
    public void postorderRec(){
        postOrderTraverse(treeRoot);
        // Add a new line after printing all the tree nodes.
        System.out.println();
    }
    private void postOrderTraverse(Node root){
        if(root == null){
            return;
        }
        postOrderTraverse(root.getlChild());
        postOrderTraverse(root.getrChild());
        //Print the key.
        System.out.printf("%d ", root.getData());
    }
    public Node kthSmallest(int k){
        kthNode = null;
        nodeCount = 0;
        kthFound = false;
        kthSmallestRec(treeRoot, k);
        return kthNode;
    }
    private void kthSmallestRec(Node root, int k){
        // InOrderTraverse till the kth Node.
        if(root == null || kthFound){
            return;
        }
        kthSmallestRec(root.getlChild(), k);
        // See if we have hit kth Node.
        nodeCount++;
        if (nodeCount == k){
            kthNode = root;
            kthFound = true;
            return;
        }
        kthSmallestRec(root.getrChild(), k);
    }

}
