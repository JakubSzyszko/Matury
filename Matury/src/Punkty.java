import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Punkty
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //Zad 4.1
        Scanner scanner=new Scanner(new File("punkty.txt"));
        int I = 0;
        int II = 0;
        int III = 0;
        int IV = 0;

        while (scanner.hasNextLine())
        {
         String split=scanner.nextLine();
         String[] s = split.split(" ");
         double x = Double.parseDouble(s[0]);
         double y = Double.parseDouble(s[1]);

         if (x>0)
         {
             if (y>0)I++;
             if (y<0)IV++;
         }

         if (x<0)
         {
             if (y > 0) II++;
             if (y < 0) III++;
         }
        }

        PrintWriter zapis = new PrintWriter("wyniki.txt");
        zapis.println(I+" "+II+" "+III+" "+IV);
        zapis.close();

        //Zad 4.2
        Scanner scanner1=new Scanner(new File("okregi.txt"));
        ArrayList<Okrag> list=new ArrayList<>();
        int il=0;

        while (scanner1.hasNextLine())
        {
            String split=scanner1.nextLine();
            String[] s=split.split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);

            if (y==r||y*(-1)==r)
            {
                list.add(new Okrag(x,y,r));
                il++;
            }

        }

        Collections.sort(list,new Sortbyy());
        Collections.sort(list,new Sortbyx());
        PrintWriter zapis2 = new PrintWriter("wyniki2.txt");

        for (int i=0; i<list.size(); i++)
            zapis2.println(list.get(i));

        zapis2.println(il);
        zapis2.close();

        //Zad 4.3 (1/2*|xA*yB-yA*xB|)
        Scanner scanner2=new Scanner(new File("punkty.txt"));

        double xstart,ystart,xA,yA,xB,yB;
        double pole=1;

        String split1=scanner2.nextLine();
        String[] s1 = split1.split(" ");
        double x1 = Double.parseDouble(s1[0]);
        double y1 = Double.parseDouble(s1[1]);

        xstart=x1;
        ystart=y1;
        xA=x1;
        yA=y1;

        while (scanner2.hasNextLine())
        {
            if (!scanner2.hasNextLine())
            {
                pole=pole+((1/2)*Math.abs((xstart*yA) - (ystart*xA)));
            }
            String split=scanner2.nextLine();
            String[] s=split.split(" ");
            double x = Double.parseDouble(s[0]);
            double y = Double.parseDouble(s[1]);
            xB=x;
            yB=y;
            pole=pole+(Math.abs((xA*yB)-(xB*yA))/2);
            xA=xB;
            yA=yB;
        }
        String s = pole + "";
        s = s.substring(0, s.indexOf('.'));
        PrintWriter zapis3 = new PrintWriter("wyniki3.txt");
        zapis3.println(s);
        zapis3.close();
    }
}

class Okrag
{
    int x;
    int y;
    int r;

    public Okrag(int x,int y,int r)
    {
        this.x=x;
        this.y=y;
        this.r=r;
    }

    public String toString()
    {
       return this.x+" "+this.y+" "+this.r;
    }
}

class Sortbyx implements Comparator<Okrag>
{
    public int compare(Okrag a,Okrag b)
    {
        return a.x - b.x;
    }
}
class Sortbyy implements Comparator<Okrag>
{
    public int compare(Okrag a,Okrag b)
    {
        return a.y - b.y;
    }
}


