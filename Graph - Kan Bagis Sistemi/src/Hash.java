
public class Hash
{

    public static int code(Blood blood)
    {
        // En az sayıda kan grubundan alma değerine göre sıralandı.
        /*
        0- sadece 0- den
        ab+ ise tüm gruplardan alabildiği hesaba katılmıştır.
        */

        int result = 256; // sıralamanın yön değiştirmesi için yapıldı.
        int rhAsciiValue;
        int typeAsciiValue = 0;

        if (blood.type.length() > 1)
        {
            typeAsciiValue += (int) blood.type.charAt(0);
            typeAsciiValue += (int) blood.type.charAt(1);
        }
        else
        {
            typeAsciiValue += (int) blood.type.charAt(0);
        }

        rhAsciiValue = 100 - (int) blood.rh.charAt(0);
        // - = 45 , + = 43 negatifin daha kucuk olması için 100 den çıkardım.

        return result - (rhAsciiValue + typeAsciiValue);
    }
}
