/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unseencar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author humnoy
 */
public class TestFeedUrl {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://www.unseencar.com/bmw/")
                    .timeout(10 * 1000)
                    .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36")
                    .get();
            
            Elements tb = doc.select("table");
            for(int i=3; i < tb.size();i++){
                Elements tr = tb.get(i).select("tr");
                for(Element a : tr.select("td")){
                    if(!a.select("a").attr("href").isEmpty()){
                        System.out.println(a.select("a").attr("href"));
                    }
                }
            }
            

        } catch (IOException ex) {
            Logger.getLogger(TestFeedUrl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
