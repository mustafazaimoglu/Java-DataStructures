
public class Person
{

    static int totalNumber = 0;
    String kimlik;
    String kanGrubu;
    String rh;
    int number;
    Blood kan;
    boolean alici;
    boolean verici;
    boolean hiv;
    boolean hepatitB;

    public Person(String kimlik, String kanGrubu, String rh, boolean alici, boolean verici, boolean hiv, boolean hepatitB)
    {
        this.number = totalNumber;
        this.kimlik = kimlik.trim();
        this.kanGrubu = kanGrubu.trim().toUpperCase();
        this.rh = rh.trim();
        kan = new Blood(kanGrubu, rh);
        this.hiv = hiv;
        this.hepatitB = hepatitB;
        this.alici = alici;
        this.verici = verici;

        totalNumber++;
    }

    @Override
    public String toString()
    {
        return "{" + kimlik + ", " + kanGrubu + rh + ", " + (this.alici ? "alan" : "veren") + "}";
    }

}
