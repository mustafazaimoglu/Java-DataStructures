
public class Blood
{

    String type;
    String rh;

    public Blood(String type, String rh)
    {
        this.type = type.trim().toUpperCase();
        this.rh = rh.trim().toUpperCase();
    }

    @Override
    public String toString()
    {
        return "{" + type + rh + "} ";
    }

}
