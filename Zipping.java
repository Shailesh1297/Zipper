/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zipping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.zip.DeflaterOutputStream;

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

        FileInputStream fis = new FileInputStream(fPath);
        String temp = fPath;
        String temp1 = null;
        StringTokenizer st = new StringTokenizer(temp, "\\");
        while ((st.hasMoreTokens())) {
            temp1 = st.nextToken();
        }
        System.out.println(temp1);
        temp = temp.replace(temp1, "");
        System.out.println(temp);
        FileOutputStream fos = new FileOutputStream(temp + "\\zip.txt");
        DeflaterOutputStream dos = new DeflaterOutputStream(fos);
        int data;
        while ((data = fis.read()) != -1) {
            dos.write(data);
        }
        fis.close();
        dos.close();
    }
}
