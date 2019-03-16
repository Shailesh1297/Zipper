/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import java.util.*;
import java.util.zip.*;
import java.io.*;
/**
 *
 * @author Nitin
 */
public class Zipping {
     String fPath;

    public Zipping(String x) {
        fPath = x;
    }

    void zip() throws FileNotFoundException, IOException {
         //program to compress text files using deflater class
        FileInputStream fis = new FileInputStream(fPath);
        String temp = fPath;
        String sub=temp.substring(temp.lastIndexOf("\\"),temp.lastIndexOf("."));
  
        String temp1 = null;
        StringTokenizer st = new StringTokenizer(temp, "\\");
        while ((st.hasMoreTokens())) {
            temp1 = st.nextToken();
        }
     
        temp = temp.replace(temp1, "");
   
        FileOutputStream fos = new FileOutputStream(temp + "\\"+sub);
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);
        int data;
        while ((data = fis.read()) != -1) {
            dos.write(data);
        }
        fis.close();
        dos.close();
        File f=new File(fPath);
        f.delete();
    }
}
