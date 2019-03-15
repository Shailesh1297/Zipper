package zipping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.zip.InflaterInputStream;

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

        
        String temp = fPath;
        String temp1 = null;
        StringTokenizer st = new StringTokenizer(temp, "\\");
        while ((st.hasMoreTokens())) {
            temp1 = st.nextToken();
        }
        System.out.println(temp1);
        temp = temp.replace(temp1, "");
        System.out.println(temp);
        FileInputStream fis = new FileInputStream(fPath);
        FileOutputStream fos = new FileOutputStream(temp + "\\unzip.txt");
        InflaterInputStream iis = new InflaterInputStream(fis);
        int data;
        while ((data = iis.read()) != -1) {
            fos.write(data);
        }
        fos.close();
        iis.close();
    }
}
