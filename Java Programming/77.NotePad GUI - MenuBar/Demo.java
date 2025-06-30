import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


class MyFrame{
            JFrame jf;
            JTextArea ta;
            JMenuBar jb;
            JMenu mnufile;
            JMenu mnucolor;
            JMenuItem mnuopen,mnusave;
            JCheckBoxMenuItem mnuback,mnufore;
            File f=null;
            MyFrame(){
                        jf=new JFrame("Untitled");
                        jf.setVisible(true);
                        jf.setSize(500,500);
                        jf.setLayout(null);
                        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        ta=new JTextArea();
                        ta.setBounds(0,0,jf.getWidth(),jf.getHeight());
                        jf.add(ta);
                        ta.setFont(new Font("Arail",Font.BOLD,20));
                        jb=new JMenuBar();
                        jf.setJMenuBar(jb);
                        mnufile=new JMenu("File");//second parameter optional(shortkut)
                        mnucolor=new JMenu("Color");
                        jb.add(mnufile);
                        jb.add(mnucolor);
                        mnuopen=new JMenuItem("Open File");mnufile.add(mnuopen);
                        mnusave=new JMenuItem("Save File");mnufile.add(mnusave);
                        mnuback=new JCheckBoxMenuItem("Background");mnucolor.add(mnuback);
                        mnufore=new JCheckBoxMenuItem("Foreground");mnucolor.add(mnufore);
                        mnuopen.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent ae){
                                                JFileChooser jc=new JFileChooser();
                                                int option=jc.showOpenDialog(jf);
                                                if(option==JFileChooser.APPROVE_OPTION){
                                                            f=jc.getSelectedFile();
                                                            jf.setTitle(jc.getName(f));
                                                            try{
                                                            FileInputStream fin=new FileInputStream(f);
                                                            byte b[]=new byte[(int)f.length()];
                                                            fin.read(b);
                                                            ta.setText(new String(b));
                                                            jf.getContentPane().repaint(); 
                                                            }catch(Exception e){}
                                                }
                                    }
                        });
                        mnusave.addActionListener(new ActionListener(){
                                    public void actionPerformed(ActionEvent ae){
                                                JFileChooser jc=new JFileChooser();
                                                if(f==null){
                                                            int option=jc.showSaveDialog(jf);
                                                            if(option==JFileChooser.APPROVE_OPTION){
                                                                        f=jc.getSelectedFile();
                                                                        jf.setTitle(jc.getName(f));
                                                                        try{
                                                                        FileWriter fout=new FileWriter(f);
                                                                        fout.write(ta.getText());
                                                                        fout.close();
                                                                        }catch(Exception e){System.out.println(e);}
                                                            }
                                                }
                                                else{
                                                            try{
                                                            FileWriter fout=new FileWriter(f);
                                                            fout.write(ta.getText());
                                                            fout.close();
                                                            }catch(Exception e){System.out.println(e);}
                                                }
                                    }
                        });
                        mnufore.addItemListener(new ItemListener(){
                                    public void itemStateChanged(ItemEvent ie){
                                                if(mnufore.getState()==true)
                                                            ta.setForeground(Color.red);
                                                else
                                                            ta.setForeground(Color.black);
                                                jf.getContentPane().repaint(); 
                                    }
                        });
                        mnuback.addItemListener(new ItemListener(){
                                    public void itemStateChanged(ItemEvent ie){
                                                if(mnuback.getState()==true)
                                                            ta.setBackground(Color.lightGray);
                                                else
                                                            ta.setBackground(Color.white);
                                                jf.getContentPane().repaint(); 
                                    }
                        });
                        jf.getContentPane().repaint(); 
            }
            public static void main(String args[]){
                        SwingUtilities.invokeLater(new Runnable(){
                                    public void run(){
                                                new MyFrame();
                                    }
                        });
            }
}
