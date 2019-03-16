/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipper;
import java.util.zip.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author Nitin
 */
public class Unzipping {
     String fPath;

    public Unzipping(String x) {
        fPath = x;
    }

    void unzip() throws FileNotFoundException, IOException {

      //unzipping files using inflater class of java  
        String temp = fPath;
        String temp1 = null;
           String sub1=temp.substring(temp.lastIndexOf("\\")+1,temp.lastIndexOf("("));
        String sub2=temp.substring(temp.lastIndexOf("(")+1,temp.lastIndexOf(")"));
     
        StringTokenizer st = new StringTokenizer(temp, "\\");
        while ((st.hasMoreTokens())) {
            temp1 = st.nextToken();
        }
    
        temp = temp.replace(temp1, "");
    
        FileInputStream fis = new FileInputStream(fPath);
        FileOutputStream fos = new FileOutputStream(temp +sub1+"."+sub2);
        InflaterInputStream iis = new InflaterInputStream(fis);
        int data;
        while ((data = iis.read()) != -1) {
            fos.write(data);
        }
        fos.close();
        iis.close();
        File f=new File(fPath);
        f.delete();
        
    }
    
}
