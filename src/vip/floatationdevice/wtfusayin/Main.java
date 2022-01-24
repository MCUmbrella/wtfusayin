package vip.floatationdevice.wtfusayin;
import java.util.Scanner;

import java.util.Random;
import java.util.NoSuchElementException;
public class Main
{
    final static Random r=new Random();
    final static Scanner i=new Scanner(System.in);
    static int a;
    public static StringBuilder pre=new StringBuilder();
    public static StringBuilder post=new StringBuilder();
    
    public static void destroy(StringBuilder old, StringBuilder processed)
    {
        for(;old.length()!=0;)
        {
            a=r.nextInt(old.length());
            processed.append(old.charAt(a));
            old.delete(a,a+1);
        }
    }
    
    public static void main(String args[])
    {
        if(args.length==1&&args[0].equals("-g"))
        {//Graphical mode (GUI)
            new GUI().setVisible(true);
        }
        else if(args.length>=1&&args[0].equals("-c"))
        {//Common mode (CLI)
            try
            {
                if(args.length==1)
                {
                    for(;pre.append(i.nextLine()).length()!=0;)//TODO: Use ^D to end input in CLI
                    {
                        post.setLength(0);
                        destroy(pre,post);
                        System.out.println(post.toString());
                    }
                }else
                {
                    for(int i=1;i!=args.length;i++){pre.append(args[i]).append(' ');}
                    pre.delete(pre.length()-1,pre.length());
                    destroy(pre,post);
                    System.out.println(post.toString());
                }
            }catch(NoSuchElementException e){}
        }
        else
        {
            System.out.println("wtfusayin.jar <-g>||<-c [string]>");
        }
    }
}
