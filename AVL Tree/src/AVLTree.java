
public class AVLTree
{

    private Node root;

    public AVLTree()
    {
        this.root = null;
    }

    void insert(int x)
    {
        this.root = insertRecursive(root, x);
    }

    private Node insertRecursive(Node current, int x)
    {
        if (current == null)
        {
            return new Node(x);
        }

        if (x > current.key)
        {
            current.right = insertRecursive(current.right, x);
        }
        else if (x < current.key)
        {
            current.left = insertRecursive(current.left, x);
        }
        else
        {
            return current;
        }

        current.degree = updateDegree(current);
        current = checkBalance(current);

        return current;
    }

    public void delete(int x)
    {
        this.root = deleteRecursive(root, x);
    }

    private Node deleteRecursive(Node current, int x)
    {
        if (current == null)
        {
            return null;
        }

        if (x > current.key)
        {
            current.right = deleteRecursive(current.right, x);
        }
        else if (x < current.key)
        {
            current.left = deleteRecursive(current.left, x);
        }
        else if (x == current.key)
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
                current.key = getMinimumKey(current.right);
                current.right = deleteRecursive(current.right, current.key);
            }
        }

        current.degree = updateDegree(current);
        current = checkBalance(current);

        return current;
    }

    private Node checkBalance(Node x)
    {
        int balance = getBalance(x);

        if (balance > 1)
        {
            int subBalance = getBalance(x.left); // left - right > 0 we took x.left as subBalance
            if (subBalance >= 0) // 2, 1, 0 for deletion we added 0 extra 
            {
                return rightRotate(x);
            }
            else if (subBalance < 0) // 2, -1
            {
                x.left = leftRotate(x.left);
                return rightRotate(x);
            }
        }
        else if (balance < -1)
        {
            int subBalance = getBalance(x.right);
            if (subBalance <= 0) // -2, -1, 0
            {
                return leftRotate(x);
            }
            else if (subBalance > 0) // -2, 1
            {
                x.right = rightRotate(x.right);
                return leftRotate(x);
            }
        }

        return x;
    }

    private Node leftRotate(Node curr)
    {
        Node rightNode = curr.right;
        Node tempNode = rightNode.left; //backup

        curr.right = tempNode;
        rightNode.left = curr;

        curr.degree = updateDegree(curr);
        rightNode.degree = updateDegree(rightNode);

        return rightNode;
    }

    private Node rightRotate(Node curr)
    {
        Node leftNode = curr.left;
        Node tempNode = leftNode.right; // backup

        curr.left = tempNode;
        leftNode.right = curr;

        curr.degree = updateDegree(curr);
        leftNode.degree = updateDegree(leftNode);

        return leftNode;
    }

    private int getMinimumKey(Node x)
    {
        while (x.left != null)
        {
            x = x.left;
        }

        return x.key;
    }

    private int getMaximumDegree(Node x)
    {
        int left = getDegree(x.left);
        int right = getDegree(x.right);
        return (left > right) ? left : right;
    }

    private int getDegree(Node x) // same as getHeight
    {
        if (x == null)
        {
            return 0;
        }

        return x.degree;
    }

    private int updateDegree(Node x)
    {
        return 1 + getMaximumDegree(x);
    }

    private int getBalance(Node x)
    {
        if (x == null)
        {
            return 0;
        }

        return getDegree(x.left) - getDegree(x.right);
    }

    public void displayTree()
    {
        System.out.println("Tree : ");
        System.out.println(this.root);
    }
}
