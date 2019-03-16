/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import javax.swing.*;
import java.awt.event.*;

import java.io.*;
/**
 *
 * @author UCHIHA
 */
public class DeCompressor extends JPanel implements ActionListener {
    
     JButton unzip,cancel,choose;
  JLabel file,head,fn;
  String fname;
  Console cons;
  int flag;
  public  DeCompressor(Console c)
    {
        cons=c;
        
       //BOX LAYOUT
       
        Box horiz1=Box.createVerticalBox();//first horizontal box
            
                Box h0=Box.createHorizontalBox();
                 head=new JLabel("UNZIP FILE");
                h0.add(head);
                horiz1.add(h0);
             
             
             Box horiz2=Box.createVerticalBox(); //second horizontal box
             choose=new JButton("Choose");
             fn=new JLabel("nofile");
                     Box h1=Box.createHorizontalBox();
                     h1.add(choose);
                     h1.add(fn);
                      horiz2.add(h1);
           
                
             Box horiz3=Box.createVerticalBox();// third vertical box
                unzip=new JButton("UNZIP");
                cancel=new JButton("CANCEL");
                 Box h2=Box.createHorizontalBox();     
                  h2.add(unzip);
                  h2.add(Box.createHorizontalStrut(40));
                  h2.add(cancel);
                  horiz3.add(h2);

                  
                  
              Box vert=Box.createVerticalBox();//vertical box
                  vert.add(horiz1);
                  vert.add(Box.createVerticalStrut(30));
                  vert.add(horiz2);
                  vert.add(Box.createVerticalStrut(30));
                  vert.add(horiz3);
                  
              this.add(vert);//adding elements to Jpanel
                  
                  choose.addActionListener(this);
                  unzip.addActionListener(this);
                  cancel.addActionListener(this);
        
    }
   //open a file Chooser
public  void open()
  {
      JFileChooser jfc=new JFileChooser();
       int i=jfc.showOpenDialog(this);
    
       if(i==JFileChooser.APPROVE_OPTION)
       {
           File f=jfc.getSelectedFile();
           fname=f.getPath();
           fn.setText(fname);
        
       }else
       {
             fname=null;
           
       }
       
  }

 //method to decompress
   public int decompress(String fname)
  {
      try{
          Unzipping unzipo=new Unzipping(fname);
          unzipo.unzip();
           
          
       }catch(IOException ie)
       {
           System.out.print(ie);
           return 0;
       }
      return 1;
  }
  
   @Override
    public void actionPerformed(ActionEvent ae)
    {
        String s=ae.getActionCommand();
      
      if(s.equals("Choose")) this.open();
      
    
        if(s.equals("UNZIP"))
      {
          if(fname!=null) 
          {
              flag=this.decompress(fname);
              if(flag==1)
              {
                  cons.cl.show(cons.c,"MESSAGE");
              }
          }
      }
        
      if(s.equals("CANCEL")) cons.cl.show(cons.c,"OPTION");
      
    }
    
}
