
public class Node
{

    int key;
    Node left, right;
    int degree;

    public Node(int key)
    {
        this.key = key;
        this.degree = 1;
        this.left = this.right = null;
    }

    @Override
    public String toString()
    {
        return "[" + key + "(" + (getBalance(this)) +"b" + "'" + degree + "d" + ")" + "," + (left == null ? "<>" : "L" + left) + "," + (right == null ? "<>" : "R" + right) + "]";
    }

    int getDegree(Node x)
    {
        if (x == null)
        {
            return 0;
        }

        return x.degree;
    }

    int getBalance(Node x)
    {
        if (x == null)
        {
            return 0;
        }

        return getDegree(x.left) - getDegree(x.right);
    }
}
