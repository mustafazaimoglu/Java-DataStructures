package mkz;

public class Operator
{

    private char type;
    private int priority;

    public Operator(char type, int priority)
    {
        this.type = type;
        this.priority = priority;
    }

    public char getType()
    {
        return type;
    }

    public void setType(char type)
    {
        this.type = type;
    }

    public int getPriority()
    {
        return priority;
    }

    public void setPriority(int priority)
    {
        this.priority = priority;
    }

}
