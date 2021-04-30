package vip.floatationdevice.wtfusayin;
import java.util.Scanner;

import javax.swing.*;

import java.util.Random;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.NoSuchElementException;
public class Main
{
    final static Random r=new Random();
    final static Scanner i=new Scanner(System.in);
    static int a;
    static StringBuilder pre=new StringBuilder();
    static StringBuilder post=new StringBuilder();
    
    static void destroy(StringBuilder old, StringBuilder processed)
    {
        for(;old.length()!=0;)
        {
            a=r.nextInt(old.length());
            processed.append(old.charAt(a));
            old.delete(a,a+1);
        }
    }
    
    static class GUI extends JFrame
    {
        static JTextArea in=new JTextArea();
        static JButton process=new JButton("PROCESS");
        static JTextArea out=new JTextArea("* This is output area\n\nHelp:\n  - Press [F1] or the \"PROCESS\" button\n     to process the input\n  - Press F1 again to switch back to input area\n\nMade by MCUmbrella\nhttps://github.com/MCUmbrella/wtfusayin");
        private static final long serialVersionUID = 1L;
        private static final ActionListener AL = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                process.setEnabled(false);
                in.setEnabled(false);
                out.setEnabled(false);
                String inputs[]=in.getText().split("\n");
                for(int i=0;i!=inputs.length;i++)
                {
                    String h=inputs[i];
                    StringBuilder t=new StringBuilder();
                    destroy(new StringBuilder(h),t);
                    post.append(t).append("\n");
                }
                out.setText(post.toString());
                post.setLength(0);
                process.setEnabled(true);
                in.setEnabled(true);
                out.setEnabled(true);
            }
        };
        private static final KeyListener IKL=new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==112){AL.actionPerformed(null);}
            }
            @Override
            public void keyReleased(KeyEvent e){}
        };
        private static final KeyListener OKL=new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e){}
            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==112){in.grabFocus();}
            }
            @Override
            public void keyReleased(KeyEvent e){}
        };
        GUI()
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("String Destroyer GUI Version 1.0");
            setSize(640, 480);
            
            in.setLineWrap(true);
            out.setLineWrap(true);

            GridBagLayout gbl=new GridBagLayout();
            GridBagConstraints c=new GridBagConstraints();
            setLayout(gbl);
            
            JPanel q=new JPanel();
            q.add(in);
            
            c.fill=GridBagConstraints.BOTH;
            c.gridx=1;
            c.gridy=1;
            c.weightx=1;
            c.weighty=1;
            gbl.setConstraints(in,c);
            add(in);

            c.fill=GridBagConstraints.VERTICAL;
            c.gridx=2;
            c.gridy=1;
            c.weightx=0;
            c.weighty=0;
            gbl.setConstraints(process,c);
            add(process);
            
            c.fill=GridBagConstraints.BOTH;
            c.gridx=3;
            c.gridy=1;
            c.weightx=1;
            c.weighty=1;
            gbl.setConstraints(out,c);
            add(out);
            c.gridwidth=GridBagConstraints.REMAINDER;
            
            process.addActionListener(AL);
            in.addKeyListener(IKL);
            out.addKeyListener(OKL);
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
            System.out.println("wtfusayin.jar <-g>||<-c [string] >");
            //new GUI().setVisible(true);
        }
    }
}
