
public class Computer implements Comparable<Computer>
{

    private int frequency;
    private int ram;
    private int hdd;

    public Computer(int frequency, int ram, int hdd)
    {
        this.frequency = frequency;
        this.ram = ram;
        this.hdd = hdd;
    }
    
    @Override
    public int compareTo(Computer c)
    {
        if (this.frequency > c.getFrequency())
        {
            return 1;
        }
        else if (this.frequency < c.getFrequency())
        {
            return -1;
        }
        else
        {
            if (this.ram > c.getRam())
            {
                return 1;
            }
            else if (this.ram < c.getRam())
            {
                return -1;
            }
            else
            {
                if (this.hdd > c.getHdd())
                {
                    return 1;
                }
                else if (this.hdd < c.getHdd())
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }
    }

    public int getFrequency()
    {
        return frequency;
    }

    public void setFrequency(int frequency)
    {
        this.frequency = frequency;
    }

    public int getRam()
    {
        return ram;
    }

    public void setRam(int ram)
    {
        this.ram = ram;
    }

    public int getHdd()
    {
        return hdd;
    }

    public void setHdd(int hdd)
    {
        this.hdd = hdd;
    }

    @Override
    public String toString()
    {
        return "[" + this.frequency + " MHZ, " + this.ram + " GB, " + this.hdd + " GB]";
    }

}
