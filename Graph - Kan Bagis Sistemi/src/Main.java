
import java.util.*;

public class Main
{

    public static void main(String[] args)
    {

        ArrayList<Person> arrList = new ArrayList<>();
        PriorityQueueWithHeap alicilar = new PriorityQueueWithHeap();
        Graph graph = new Graph();

        Scanner sc = new Scanner(System.in);
        String message = "\n1 : Kullanıcı ekleme\n"
                + "2 : 2 Kullanıcı arası kimlik numarası ile kan bağış kontrolu\n"
                + "3 : 2.seçenek için oluşan Çizgeyi yazdırma\n"
                + "4 : Kanlar arası bağlantı Çizgesini yazdır\n"
                + "5 : Sitemdeki tüm kullanıcılar için oluşan Çizgeyi yazdır\n"
                + "6 : Kan bağışı bekleyen kuyruğu yazdır\n"
                + "q : Çıkış Yap.";

        System.out.println("Hoşgeldiniz...");
        while (true)
        {
            System.out.println(message);
            System.out.print("Seçiminiz : ");
            String secim = sc.nextLine();

            if (secim.equals("q"))
            {
                System.out.println("Programdan çıkılıyor...");
                break;
            }
            else if (secim.equals("1"))
            {
                System.out.print("Kimlik Numaranız : ");
                String kimlik = sc.nextLine().trim();
                
                if(kimlik.isEmpty())
                {
                    System.out.println("Hatalı giriş yaptınız!!!");
                    continue;
                }

                System.out.print("Kan Grubunuz (ab+,0+,b- şeklinde yazınız.) : ");
                String kanGrubu = sc.nextLine().trim().toUpperCase();

                if (kanGrubu.isEmpty())
                {
                    System.out.println("Hatalı giriş yaptınız!!!");
                    continue;
                }

                String rh = String.valueOf(kanGrubu.charAt(kanGrubu.length() - 1));

                kanGrubu = kanGrubu.substring(0, kanGrubu.length() - 1);

                if (!rh.equalsIgnoreCase("-") && !rh.equalsIgnoreCase("+"))
                {
                    System.out.println("Kan bilgisinde hata var yeniden deneyin!");
                    continue;
                }

                if (!kanGrubu.equalsIgnoreCase("a") && !kanGrubu.equalsIgnoreCase("b") && !kanGrubu.equalsIgnoreCase("ab") && !kanGrubu.equalsIgnoreCase("0"))
                {
                    System.out.println("Kan bilgisinde hata var yeniden deneyin!");
                    continue;
                }

                System.out.print("Kan Alıcı için 1 Kan bağışı için 0 : ");
                String aliciVerici = sc.nextLine();

                Boolean alici, verici, hiv, hepatitB;

                if (aliciVerici.equals("0"))
                { //Kan veren
                    verici = true;
                    alici = false;

                    System.out.print("HIV hastalığınız var mı? varsa 1 yoksa 0 : ");
                    String hivVarmi = sc.nextLine();

                    if (hivVarmi.equals("1"))
                    {
                        hiv = true;
                    }
                    else
                    {
                        hiv = false;
                    }

                    System.out.print("Hepatit B hastalığınız var mı? varsa 1 yoksa 0 : ");
                    String hepatitBVarmi = sc.nextLine();

                    if (hepatitBVarmi.equals("1"))
                    {
                        hepatitB = true;
                    }
                    else
                    {
                        hepatitB = false;
                    }

                    if (hepatitB || hiv)
                    {
                        System.out.println("Hastalık barındırdığınız için kan veremezsiniz!!!");
                        System.out.println("Kan alabilir şekilde kaydedildiniz.");

                        alici = true;
                        verici = false;
                    }
                    else
                    {
                        System.out.println("Kaydedildi!");
                    }
                }
                else if (aliciVerici.equals("1"))
                { //Kan alan
                    alici = true;
                    verici = false;

                    System.out.print("HIV hastalığınız var mı? varsa 1 yoksa 0 : ");
                    String hivVarmi = sc.nextLine();

                    if (hivVarmi.equals("1"))
                    {
                        hiv = true;
                    }
                    else
                    {
                        hiv = false;
                    }

                    System.out.print("Hepatit B hastalığınız var mı? varsa 1 yoksa 0 : ");
                    String hepatitBVarmi = sc.nextLine();

                    if (hepatitBVarmi.equals("1"))
                    {
                        hepatitB = true;
                    }
                    else
                    {
                        hepatitB = false;
                    }

                    System.out.println("Kaydedildi!");
                }
                else
                {
                    System.out.println("Hatalı Giriş Yaptınız yeniden deneyin!");
                    continue;
                }

                Person p = new Person(kimlik, kanGrubu.toUpperCase(), rh, alici, verici, hiv, hepatitB);

                if (alici)
                {
                    alicilar.add(p);
                }
                arrList.add(p);

            }
            else if (secim.equals("2"))
            {
                if (arrList.isEmpty())
                {
                    System.out.println("Sisteme kayıtlı kimse yok önce en az iki kişi kaydediniz.");
                }
                else if (arrList.size() == 1)
                {
                    System.out.println("Sistemde sadece bir kişi var!!");
                }
                else
                {
                    Person p1 = null, p2 = null;
                    System.out.println("Lutfen kan ilişkisni kontrol etmek isteğiniz\nilk kişinin kimlik numarasını giriniz!");
                    System.out.print("1 : ");
                    String kimlik1 = sc.nextLine().trim();

                    System.out.println("İkinci kişinin kimlik numarasını giriniz!");
                    System.out.print("2 : ");
                    String kimlik2 = sc.nextLine().trim();

                    for (int i = 0; i < arrList.size(); i++)
                    {
                        if (kimlik1.equals(arrList.get(i).kimlik))
                        {
                            p1 = arrList.get(i);
                        }

                        if (kimlik2.equals(arrList.get(i).kimlik))
                        {
                            p2 = arrList.get(i);
                        }
                    }

                    if (p1 == null)
                    {
                        System.out.println(kimlik1 + " Sistemde bulunamadı!");
                    }

                    if (p2 == null)
                    {
                        System.out.println(kimlik2 + " Sistemde bulunamadı!");
                    }

                    if (p1 == null || p2 == null)
                    {
                        System.out.println("Kimlik numaralarını kontrol ederek yeniden deneyiniz!!!");
                        continue;
                    }

                    if (p1.alici && p2.alici)
                    {
                        System.out.println("Her iki insan da alıcı olduğu için çizgeye kaydedilmedi.");
                    }
                    else if (p1.verici && p2.verici)
                    {
                        System.out.println("Her iki insan da verici olduğu için çizgeye kaydedilmedi.");
                    }
                    else
                    {
                        if (p1.alici)
                        {//p1 alıcı
                            int index = graph.btg.findIndex(p1.kan);
                            Blood arr[] = graph.btg.convertToArray(index);
                            boolean okey = false;

                            for (int i = 0; i < arr.length; i++)
                            {
                                if (arr[i].type.equals(p2.kanGrubu))
                                {
                                    if (arr[i].rh.equals(p2.rh))
                                    {
                                        okey = true;
                                    }
                                }
                            }

                            if (okey)
                            {
                                System.out.println(p2.kanGrubu + p2.rh + " Kan grubu " + p1.kanGrubu + p1.rh + " kan grubuna kan verebilir.");
                                System.out.println(kimlik2 + " TC li kişi " + kimlik1 + " TC li kişiye kan verebilir.");
                                System.out.println("Çizgeye Eklendi.");

                                graph.addNewEdge(p2);
                                graph.addNewEdge(p1);
                            }
                            else
                            {
                                System.out.println(p2.kanGrubu + p2.rh + " Kan grubu " + p1.kanGrubu + p1.rh + " kan grubuna kan veremez.");
                                System.out.println(kimlik2 + " TC li kişi " + kimlik1 + " TC li kişiye kan veremez.");
                                System.out.println("Çizgeye Eklenmedi.");
                            }
                        }
                        else
                        {//p2 alıcı
                            int index = graph.btg.findIndex(p2.kan);
                            Blood arr[] = graph.btg.convertToArray(index);
                            boolean okey = false;

                            for (int i = 0; i < arr.length; i++)
                            {
                                if (arr[i].type.equals(p1.kanGrubu))
                                {
                                    if (arr[i].rh.equals(p1.rh))
                                    {
                                        okey = true;
                                    }
                                }
                            }

                            if (okey)
                            {
                                System.out.println(p1.kanGrubu + p1.rh + " Kan grubu " + p2.kanGrubu + p2.rh + " kan grubuna kan verebilir.");
                                System.out.println(kimlik1 + " TC li kişi " + kimlik2 + " TC li kişiye kan verebilir.");
                                System.out.println("Çizgeye Eklendi...");

                                graph.addNewEdge(p1);
                                graph.addNewEdge(p2);
                            }
                            else
                            {
                                System.out.println(p1.kanGrubu + p1.rh + " Kan grubu " + p2.kanGrubu + p2.rh + " kan grubuna kan veremez.");
                                System.out.println(kimlik1 + " TC li kişi " + kimlik2 + " TC li kişiye kan veremez.");
                                System.out.println("Çizgeye Eklenmedi.");
                            }
                        }
                    }
                }
            }
            else if (secim.equals("3"))
            {
                if (!graph.isEmpty())
                {
                    graph.print();
                }
                else
                {
                    System.out.println("Çizge şu an boş.");
                    System.out.println("2. seçeneği kullanarak doldurabilirsiniz.");
                }
            }
            else if (secim.equals("4"))
            {
                graph.btg.print();
            }
            else if (secim.equals("5"))
            {
                if (arrList.isEmpty())
                {
                    System.out.println("Sistem şu an boş.");
                }
                else
                {
                    Graph tempGraph = new Graph();

                    for (int i = 0; i < arrList.size(); i++)
                    {
                        tempGraph.addNewEdge(arrList.get(i));
                    }

                    System.out.println();
                    tempGraph.print();
                }
            }
            else if (secim.equals("6"))
            {
                if (alicilar.currentIndex != 0)
                {
                    System.out.println("En az sayıda kan grubundan alma değerine göre sıralandı");
                    alicilar.printWithOrder();
                }
                else
                {
                    System.out.println("Kuyruk şuan boş.");
                }
            }
            else
            {
                System.out.println("Hatalı bir giriş yaptınız tekrar deneyiniz...");
            }
        }
    }
}
