
public class Main
{

    public static void main(String[] args)
    {
        AVLTree avl = new AVLTree();

        avl.insert(33);
        avl.displayTree();
        avl.insert(13);
        avl.displayTree();
        avl.insert(53);
        avl.displayTree();
        avl.insert(21);
        avl.displayTree();
        avl.insert(11);
        avl.displayTree();
        avl.insert(61);
        avl.displayTree();
        avl.insert(8);
        avl.displayTree();
        avl.insert(9);
        avl.displayTree();
        avl.delete(13);
        avl.displayTree();
    }
}
