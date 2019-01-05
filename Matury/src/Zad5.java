import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Zad5
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Zad 5.1
        Scanner scanner=new Scanner(new File("rejestrator.txt"));
        int i=1;
        int godz10,godz1,min10,min1,sec10,sec1;
        PrintWriter zapis = new PrintWriter("wyniki5.txt");
        zapis.println("Zad5.1");
        while (scanner.hasNextLine())
        {
          String ciag=scanner.nextLine();
          if (i%1111==0)
          {
              godz10=Integer.parseInt(ciag.substring(0,3),2);
              godz1=Integer.parseInt(ciag.substring(4,7),2);
              min10=Integer.parseInt(ciag.substring(8,11),2);
              min1=Integer.parseInt(ciag.substring(12,15),2);
              sec10=Integer.parseInt(ciag.substring(16,19),2);
              sec1=Integer.parseInt(ciag.substring(20,23),2);
              zapis.println(godz10+""+godz1+":"+min10+""+min1+":"+sec10+""+sec1);
          }
          i++;
        }

        //Zad 5.2
        Scanner scanner2=new Scanner(new File("rejestrator.txt"));
        zapis.println("");
        zapis.println("Zad 5.2");

        while (scanner2.hasNextLine())
        {
            String ciag=scanner2.nextLine();

            godz10=Integer.parseInt(ciag.substring(0,3),2);
            godz1=Integer.parseInt(ciag.substring(4,7),2);
            min10=Integer.parseInt(ciag.substring(8,11),2);
            min1=Integer.parseInt(ciag.substring(12,15),2);
            sec10=Integer.parseInt(ciag.substring(16,19),2);
            sec1=Integer.parseInt(ciag.substring(20,23),2);
            if (godz10==sec1&&godz1==sec10&&min10==min1)
            {
                zapis.println(godz10+""+godz1+":"+min10+""+min1+":"+sec10+""+sec1);
            }
        }

        //Zad5.3
        zapis.println("");
        zapis.println("Zad 5.3");
        Scanner scanner3=new Scanner(new File("rejestrator.txt"));
        ArrayList list=new ArrayList();

        while (scanner3.hasNextLine())
        {
            String ciag=scanner3.nextLine();
            String czas;

            godz10=Integer.parseInt(ciag.substring(0,3),2);
            godz1=Integer.parseInt(ciag.substring(4,7),2);
            min10=Integer.parseInt(ciag.substring(8,11),2);
            min1=Integer.parseInt(ciag.substring(12,15),2);
            sec10=Integer.parseInt(ciag.substring(16,19),2);
            sec1=Integer.parseInt(ciag.substring(20,23),2);
            if (godz10==1&&godz1==2&&0<=min10&&min10<=1)
            {
                czas=godz10+""+godz1+":"+min10+""+min1+":"+sec10+""+sec1;
                list.add(czas);
            }
        }
        Collections.sort(list);
        String godzina,godzina2;
        int ilosc=1;
        godzina= (String) list.get(0);
        list.remove(0);
        while (!list.isEmpty())
        {
            godzina2=(String) list.get(0);
            list.remove(0);
            if (godzina2.equals(godzina))
            {
                ilosc++;
            }else
                {
                    if (ilosc==3)
                    {
                        zapis.println(godzina);
                    }
                    ilosc=1;
                    godzina=godzina2;
                }
        }

        //Zad 5.4
        zapis.println("");
        zapis.println("Zad 5.4");
        Scanner scanner4=new Scanner(new File("rejestrator.txt"));
        int[] iloscigodzin=new int[24];

        while (scanner4.hasNextLine())
        {
            String ciag=scanner4.nextLine();

            godz10=Integer.parseInt(ciag.substring(0,3),2);
            godz1=Integer.parseInt(ciag.substring(4,7),2);
            int suma=(godz10*10)+godz1;
            iloscigodzin[suma]++;
        }
        for (int a=0;a<iloscigodzin.length;a++)
        {
            zapis.println("Ilosc godzin "+a+": "+iloscigodzin[a]);
        }

        zapis.close();
    }
}
