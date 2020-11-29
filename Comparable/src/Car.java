
public class Car implements Comparable<Car>
{
    private int engine;
    private int hp;
    private String brand;

    public Car(int engine, int hp, String brand)
    {
        this.engine = engine;
        this.hp = hp;
        this.brand = brand;
    }

    public int getEngine()
    {
        return engine;
    }

    public void setEngine(int engine)
    {
        this.engine = engine;
    }

    public int getHp()
    {
        return hp;
    }

    public void setHp(int hp)
    {
        this.hp = hp;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }
        
    @Override
    public int compareTo(Car c)
    {
        if(this.hp > c.getHp())
        {
            return 1;
        }
        else if(this.hp < c.getHp())
        {
            return -1;
        }
        else
        {
            if(this.engine > c.getEngine())
            {
                return 1;
            }
            else if(this.engine < c.getEngine())
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
