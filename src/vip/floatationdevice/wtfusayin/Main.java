package vip.floatationdevice.wtfusayin;
import java.util.*;
public class Main
{
    final static Random r=new Random();
    final static Scanner i=new Scanner(System.in);
    static int a;
    static StringBuilder pre = new StringBuilder();
    static StringBuilder post=new StringBuilder();
    public static void main(String args[])
    {
        if(args.length==0)
        {
            for(System.out.print("? ");pre.append(i.nextLine()).length()!=0;)
            {
                post.setLength(0);
                for(;pre.length()!=0;)
                {
                    a=r.nextInt(pre.length());
                    post.append(pre.charAt(a));
                    pre.delete(a,a+1);
                }
                System.out.print(post.toString()+"\n? ");
            }
        }else
        {
            for(String s:args){pre.append(s).append(' ');}
            for(;pre.length()!=0;)
            {
                a=new Random().nextInt(pre.length());
                post.append(pre.charAt(a));
                pre.delete(a,a+1);
            }
            System.out.println(post.toString());
        }
    }
}
