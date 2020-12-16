
public class Main
{

    public static void main(String[] args)
    {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(15);
        bst.insert(48);
        bst.insert(10);
        bst.insert(12);
        bst.insert(33);
        bst.insert(27);
        bst.insert(8);
        bst.insert(38);
        bst.display();

        bst.delete(15);
        bst.display();
        
        bst.preorderTraversal();
        System.out.println();
        bst.inorderTraversal();
        System.out.println();
        bst.postorderTraversal();
        System.out.println();
        System.out.println(bst.search(48));

    }
}
