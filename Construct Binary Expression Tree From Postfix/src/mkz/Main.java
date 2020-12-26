package mkz;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please, enter the expression correctly : ");
        String operation = sc.nextLine();

        CalculatePostfix cp = new CalculatePostfix(operation);
        BinaryTree bt = new BinaryTree();

        bt.constructTree(cp);
        cp.printPostfix();
        bt.displayTree();
        
        System.out.println("Result : " + bt.getResult());
    }

}