
public class BinarySearchTree
{

    Node root;

    public BinarySearchTree()
    {
        this.root = null;
    }

    public void insert(int x)
    {
        this.root = this.instertRecursive(root, x);
    }

    private Node instertRecursive(Node current, int x)
    {
        if (current == null)
        {
            return new Node(x);
        }

        if (x < current.key)
        {
            current.left = instertRecursive(current.left, x);
        }
        else if (x > current.key)
        {
            current.right = instertRecursive(current.right, x);
        }

        return current;
    }

    public Node delete(int x)
    {
        return deleteRecursive(root, x);
    }

    private Node deleteRecursive(Node current, int x)
    {
        if (current == null)
        {
            return null;
        }
        
        if (x < current.key)
        {
            current.left = deleteRecursive(current.left, x);
        }
        else if(x > current.key)
        {
            current.right = deleteRecursive(current.right, x);
        }

        if (x == current.key)
        {
            if (current.left == null && current.right == null)
            {
                return null;
            }
            else if (current.left == null)
            {
                return current.right;
            }
            else if (current.right == null)
            {
                return current.left;
            }
            else
            {
                current.key = minimum(current.right);
                current.right = deleteRecursive(current.right, current.key);
            }
        }

        

        return current;
    }

    public Node search(int x)
    {
        return this.searchRecursive(root, x);
    }

    private Node searchRecursive(Node current, int x)
    {
        if (current == null || current.key == x)
        {
            return current;
        }

        if (x < current.key)
        {
            return searchRecursive(current.left, x);
        }
        else
        {
            return searchRecursive(current.right, x);
        }

    }

    public void preorderTraversal()
    {
        this.preorderTraversalRecursive(root);
    }

    private void preorderTraversalRecursive(Node current)
    {
        if (current != null)
        {
            System.out.print(current.key + " ");
            preorderTraversalRecursive(current.left);
            preorderTraversalRecursive(current.right);
        }
    }

    public void inorderTraversal()
    {
        this.inorderTraversalRecursive(root);
    }

    private void inorderTraversalRecursive(Node current)
    {
        if (current != null)
        {
            inorderTraversalRecursive(current.left);
            System.out.print(current.key + " ");
            inorderTraversalRecursive(current.right);
        }
    }

    public void postorderTraversal()
    {
        this.postorderTraversalRecursive(root);
    }

    private void postorderTraversalRecursive(Node current)
    {
        if (current != null)
        {
            postorderTraversalRecursive(current.left);
            postorderTraversalRecursive(current.right);
            System.out.print(current.key + " ");
        }
    }

    private int minimum(Node root)
    {
        return root.left == null ? root.key : minimum(root.left);
    }

    private int maximum(Node root)
    {
        return root.right == null ? root.key : maximum(root.right);
    }

    public void display()
    {
        System.out.println(root);
    }
}
