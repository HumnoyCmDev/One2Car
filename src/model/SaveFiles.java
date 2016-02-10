/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SaveFiles {
    
    public void writeTextFile(List<String> list,String FileName,int page){
        FileWriter w = null;
        try {
            File logFile = new File(System.getProperty("user.home")+ File.separator + "Desktop"+ File.separator +"outPutOne2Car",FileName+" หน้าที่ "+page+".txt");
            logFile.getParentFile().mkdirs();
            System.out.println(logFile.getCanonicalPath());

              w = new FileWriter(logFile);
            for (String r : list) {
                w.write("\n"+r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                w.close();
            } catch (Exception e) {
            }
        }
    }
}
