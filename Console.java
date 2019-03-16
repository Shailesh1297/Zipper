/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author UCHIHA
 */
public class Console extends JFrame {
    
    Container c;
    CardLayout cl;
    
   public Console()
    {
        c=this.getContentPane();
        cl=new CardLayout();//display one panel at at time
         c.setLayout(cl); 
         
         //objects of Jpanels
         Option o=new Option(this);
         Compressor cmp=new Compressor(this);
        DeCompressor dcmp=new DeCompressor(this);
        Message msg=new Message(this);
        
        //adding Jpanel to CardLayout with respective names
         c.add("OPTION",o);       
        c.add("COMPRESSOR",cmp);
         c.add("DECOMPRESSOR",dcmp);
         c.add("MESSAGE",msg);
        
        
        
    }
    
}
