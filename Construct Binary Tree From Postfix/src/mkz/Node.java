package mkz;

public class Node
{

    String value;
    Node left, right;

    public Node(String value)
    {
        this.value = value;
        this.left = this.right = null;
    }

    @Override
    public String toString()
    {
        return "[" + value + "," + (left == null ? "<>" : "L" + left) + "," + (right == null ? "<>" : "R" + right) + "]";
    }
}
