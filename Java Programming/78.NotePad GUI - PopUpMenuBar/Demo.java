import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class PopUpMenuDemo {
    JFrame jf;
    JPopupMenu mnu;
    JMenuItem mcut,mcopy,mpaste;
    JTextArea jt;
    JScrollPane js;
    PopUpMenuDemo()
    {
        jf = new JFrame("NotePad");
        jf.setVisible(true);
        jf.setSize(500,500);
        jt = new JTextArea();
        js=new JScrollPane(jt);
        jf.add(js);
        jt.setSize(jf.getWidth(),jf.getHeight());
        jf.validate(); jf.repaint();
        
        mnu = new JPopupMenu();
        mcut = new JMenuItem("Cut");
        mcopy = new JMenuItem("Copy");
        mpaste = new JMenuItem("Paste");

        jt.setFont(new Font("Arial",Font.BOLD,25));
    

        mnu.add(mcut);
        mnu.add(mcopy);
        mnu.add(mpaste);

        mcut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                jt.cut();
            }
        });
        mcopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                jt.copy();
            }
        });
        mpaste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae)
            {
                jt.paste();
            }
        });
        
        jt.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me)
            {
                if(me.getButton()==MouseEvent.BUTTON3)
                {
                    mnu.show(jt,me.getX(),me.getY());            
                }
            }
        });
    }
    public static void main(String[] args) {
        new PopUpMenuDemo();
    }
}