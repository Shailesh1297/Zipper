/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author UCHIHA
 */
public class Option extends JPanel implements ActionListener {
    
    JButton compress,decompress;
    JLabel name;
    
     Console cons;
    public Option(Console c)
    {
        cons=c;
        Box horiz1=Box.createVerticalBox();
             Box h0=Box.createHorizontalBox();
             name=new JLabel("Zipper");
             name.setFont(new Font("Cooper",Font.BOLD,30));
            
             h0.add(name);
             horiz1.add(h0);
             
        Box horiz2=Box.createVerticalBox();
        compress=new JButton("COMPRESS");
            Box h1=Box.createHorizontalBox();
          //  h1.add(Box.createHorizontalStrut(0));
            h1.add(compress);
            horiz2.add(h1);
        
        Box horiz3=Box.createVerticalBox();
         decompress=new JButton("DE-COMPRESS");
          Box h2=Box.createHorizontalBox();
         //   h2.add(Box.createHorizontalStrut(0));
            h2.add(decompress);
            horiz3.add(h2);
       
        
        Box horiz4=Box.createVerticalBox();
           Box h3=Box.createHorizontalBox();
           h3.add(new JLabel("@CodeShala"));
           h3.add(Box.createHorizontalStrut(230));
           h3.add(new JLabel("v0.0"));
        horiz4.add(h3);
        
        Box vert=Box.createVerticalBox();
         
        vert.add(horiz1);
        vert.add(Box.createVerticalStrut(20));
         vert.add(horiz2);
        vert.add(Box.createVerticalStrut(10));
         vert.add(horiz3);
       vert.add(Box.createVerticalStrut(10));
        vert.add(horiz4);
         
       
         this.add(vert);//adding content to JPanel
         compress.addActionListener(this);
         decompress.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
         String s=ae.getActionCommand();
      
      if(s.equals("COMPRESS")) cons.cl.show(cons.c,"COMPRESSOR");//compress option is clicked
     
      if(s.equals("DE-COMPRESS"))cons.cl.show(cons.c,"DECOMPRESSOR");//decompress option is clicked
           
      
    }
    
}
