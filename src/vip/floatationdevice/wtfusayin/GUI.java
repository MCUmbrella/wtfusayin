package vip.floatationdevice.wtfusayin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import static vip.floatationdevice.wtfusayin.Main.post;
import static vip.floatationdevice.wtfusayin.Main.destroy;

public class GUI extends JFrame
{
    static final JTextArea in=new JTextArea();
    static final JButton process=new JButton("PROCESS");
    static final JTextArea out=new JTextArea("* This is output area\n\nHelp:\n  - Press [F1] or the \"PROCESS\" button to process the input\n  - Press F1 again to switch back to input area\n\nMade by MCUmbrella\nhttps://github.com/MCUmbrella/wtfusayin");
    private static final long serialVersionUID = 2L;
    static final Random r=new Random();
    static GUI ins;
    static final String title[]=
    {
        "What the f*ck are you saying",
        "String Destroyer™ GUI version 1.0.1",
        "blahblahblahbla bla blala blah bla blablah",
        "BOO PEE BOO HEY",
        "LAMBDA-FREE: No '->' in source code!",
        "Why not try long pressing F1",
        "Powered by Java™",
        "锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟铰凤拷",
        "Human language to enchanting table translator",
        "null",
        "bruh",
        "https://github.com/MCUmbrella/wtfusayin",
        "The funny",
        "Get real"
    };
    private static final ActionListener AL=new ActionListener()
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
            ins.setTitle(title[r.nextInt(title.length)]);
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
        ins=this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}catch(Throwable ex){}
        setTitle(title[r.nextInt(title.length)]);
        setSize(640, 480);
        
        in.setLineWrap(true);
        out.setLineWrap(true);

        GridBagLayout gbl=new GridBagLayout();
        GridBagConstraints c=new GridBagConstraints();
        setLayout(gbl);
        
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
