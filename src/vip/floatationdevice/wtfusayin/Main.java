package vip.floatationdevice.wtfusayin;
import java.util.Scanner;
import java.util.Random;
import java.util.NoSuchElementException;
public class Main
{
    final static Random r=new Random();
    final static Scanner i=new Scanner(System.in);
    static int a;
    static StringBuilder pre=new StringBuilder();
    static StringBuilder post=new StringBuilder();
    public static void main(String args[])
    {
        try
        {
            if(args.length==0)
            {
                for(;pre.append(i.nextLine()).length()!=0;)
                {
                    post.setLength(0);
                    for(;pre.length()!=0;)
                    {
                        a=r.nextInt(pre.length());
                        post.append(pre.charAt(a));
                        pre.delete(a,a+1);
                    }
                    System.out.println(post.toString());
                }
            }else
            {
                for(String s:args){pre.append(s).append(' ');}
                pre.delete(pre.length()-1,pre.length());
                for(;pre.length()!=0;)
                {
                    a=r.nextInt(pre.length());
                    post.append(pre.charAt(a));
                    pre.delete(a,a+1);
                }
                System.out.println(post.toString());
            }
        }catch(NoSuchElementException e){}
    }
}
