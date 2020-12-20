package mkz;

import java.util.ArrayList;
import java.util.Stack;

public class Calculate
{

    String expression;
    ArrayList<String> operandAndNumbers = new ArrayList<>();
    ArrayList<String> resultPostfix = new ArrayList<>();

    Operator operators[] =
    {
        new Operator('(', 0), new Operator('+', 1), new Operator('-', 1), new Operator('*', 2),
        new Operator('/', 2), new Operator('^', 3), new Operator(')', 4)
    };

    public Calculate(String expression)
    {
        this.expression = expression;
    }

    public void calculatePostix()
    {
        separate();

        Stack<String> stack = new Stack<>();

        for (String s : operandAndNumbers)
        {
            if (s.length() > 1)
            {
                try
                {
                    resultPostfix.add(String.valueOf(Double.parseDouble(s)));

                } catch (NumberFormatException ex)
                {
                    System.out.println("Fault! There is an unknown character.");
                    ex.printStackTrace();
                }
            }
            else
            {
                if (!(stack.empty()))
                {
                    int index = findOperator(s.charAt(0));

                    if (s.charAt(0) == '(')
                    {
                        stack.push(s);
                    }
                    else if (s.charAt(0) == ')')
                    {
                        while (!stack.isEmpty() && operators[findOperator(stack.peek().charAt(0))].getType() != '(')
                        {
                            String value = String.valueOf(operators[findOperator(stack.pop().charAt(0))].getType());

                            if (!value.equals("("))
                            {
                                if (!value.equals(")"))
                                {
                                    resultPostfix.add(value);
                                }
                            }
                        }
                        stack.pop();
                    }
                    else
                    {
                        while (!stack.isEmpty() && operators[findOperator(stack.peek().charAt(0))].getPriority() >= operators[index].getPriority())
                        {
                            String value = String.valueOf(operators[findOperator(stack.pop().charAt(0))].getType());

                            if (!value.equals("("))
                            {

                                resultPostfix.add(value);

                            }
                        }
                        stack.push(s);
                    }
                }
                else
                {
                    stack.push(s);
                }

            }
        }

        while (!stack.empty())
        {
            String value = stack.pop();

            if (!value.equals("("))
            {

                resultPostfix.add(value);

            }
        }

        printPostfix();
    }

    public void separate()
    {
        boolean isOperator;
        int backward = 0, i, j;
        String temp;

        for (i = 0; i < this.expression.length(); i++)
        {
            char x = expression.charAt(i);
            isOperator = operatorCheck(x);

            if (isOperator)
            {
                temp = "";
                for (j = i - backward; backward > 0; j++, backward--)
                {
                    temp += String.valueOf(expression.charAt(j));
                }

                if (temp.length() != 0)
                {
                    temp += "d"; // to convert double
                    operandAndNumbers.add(temp);
                }
                operandAndNumbers.add(String.valueOf(x));
            }
            else
            {
                backward++;
            }
        }

        if (backward > 0) // for the rest of it
        {
            temp = "";
            for (j = i - backward; backward > 0; j++, backward--)
            {
                temp += String.valueOf(expression.charAt(j));
            }

            if (temp.length() != 0)
            {
                temp += "d";
                operandAndNumbers.add(temp);
            }
        }
    }

    public boolean operatorCheck(char x)
    {
        for (Operator o : operators)
        {
            if (x == o.getType())
            {
                return true;
            }
        }

        return false;
    }
    
    void printarrayList()
    {
        operandAndNumbers.forEach(s ->
        {
            System.out.println(s + " ");
        });
    }

    void printPostfix()
    {
        System.out.println("\nPostfix : ");
        resultPostfix.forEach(s ->
        {
            System.out.print(s + " ");
        });
    }

    int findOperator(char x)
    {
        for (int i = 0; i < operators.length; i++)
        {
            if (x == operators[i].getType())
            {
                return i;
            }
        }

        return -1;
    }

}
