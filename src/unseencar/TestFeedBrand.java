/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unseencar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class TestFeedBrand {

    public static void main(String[] args) {

        try {
            Document doc = Jsoup.connect("http://www.unseencar.com/carbrand.php")
                    .timeout(10 * 1000)
                    .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36")
                    .get();
//            
            Elements b = doc.select("div.boxBrand > div.aBrand");
            for(Element e : b){
                System.out.println(e.select("a").attr("href"));
                System.out.println(e.select("a").text());
            }
           

        } catch (IOException ex) {
            Logger.getLogger(FeedBrandUnSeen.class.getName()).log(Level.SEVERE, null, ex);
        }



//        String s = "2013 BMW Z4 E89 (ปี 09-16) sDrive20i 2.0 Convertible";
//        String result = "";
//
//        List<Integer> index = new ArrayList<Integer>();
//        int subStart = -1, subEnd = -1;
//
//        boolean isRead = true;
//        for (int i = 0; i < s.length(); i++) {
//            String tt = String.valueOf(s.charAt(i));
//
//            if (tt.equals("(")) {
//                isRead = false;
//            }
//            if (tt.equals(")")) {
//                isRead = true;
//
//            }
//            if (isRead) {
//                if (tt.equals(" ")) {
//                    index.add(i);
//                }
//            }
//        }
//        
//        int last = 0;
//        int idKey=0;
//        for (int i = 0; i < s.length(); i++) {           
//               if(i == index.get(idKey)){
//                   idKey++;
//                   if(idKey > index.size()-1){
//                       idKey = index.size()-1;
//                   } 
//               }else {
//                   if(i != idKey){  
//                    result += s.charAt(i);
//                   }
//               }
//        }
//        System.out.println(result);

    }
}
