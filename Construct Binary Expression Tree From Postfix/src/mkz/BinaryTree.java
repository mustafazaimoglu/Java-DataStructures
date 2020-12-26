package mkz;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree
{

    Node root;

    public BinaryTree()
    {
        root = null;
    }

    public void constructTree(CalculatePostfix cp)
    {
        int i;
        ArrayList<String> postfix = cp.calculatePostix();
        Stack<Node> stack = new Stack<>();

        for (i = 0; i < postfix.size(); i++)
        {
            if (!cp.operatorCheck(postfix.get(i).charAt(0)))
            {
                stack.add(new Node(postfix.get(i)));
            }
            else
            {
                Node arr[] = new Node[2];
                arr[0] = stack.pop();
                arr[1] = stack.pop();

                Node newNode = new Node(postfix.get(i));
                newNode.right = arr[0];
                newNode.left = arr[1];

                stack.push(newNode);
            }
        }

        root = stack.pop();
    }

    public double getResult()
    {
        Node temp = this.root;

        return getResultRec(temp);
    }

    private double getResultRec(Node current)
    {
//      displayTree();  // to see the solving steps you can uncomment this
        if (current.left != null && current.right != null)
        {
            getResultRec(current.right);
            getResultRec(current.left);

            if (current.left.left == null && current.left.right == null && current.right.left == null && current.right.right == null)
            {
                switch (current.value)
                {
                    case "+":
                        current.value = String.valueOf(Double.parseDouble(current.left.value) + Double.parseDouble(current.right.value));
                        current.left = null;
                        current.right = null;
                        break;
                    case "-":
                        current.value = String.valueOf(Double.parseDouble(current.left.value) - Double.parseDouble(current.right.value));
                        current.left = null;
                        current.right = null;
                        break;
                    case "*":
                        current.value = String.valueOf(Double.parseDouble(current.left.value) * Double.parseDouble(current.right.value));
                        current.left = null;
                        current.right = null;
                        break;
                    case "/":
                        current.value = String.valueOf(Double.parseDouble(current.left.value) / Double.parseDouble(current.right.value));
                        current.left = null;
                        current.right = null;
                        break;
                    case "^":
                        current.value = String.valueOf(Math.pow(Double.parseDouble(current.left.value), Double.parseDouble(current.right.value)));
                        current.left = null;
                        current.right = null;
                        break;
                    default:
                        System.out.println("Fault! Unknown type!!!");
                        break;
                }
            }
        }

        return Double.parseDouble(current.value);
    }

    public void displayTree()
    {
        System.out.println("\nTree : ");
        System.out.println(root);
        System.out.println();
    }

}
