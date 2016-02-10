/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onetwocar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author humnoy
 */
public class FeedData extends SwingWorker<Void, Void> {
        private String pageView;
        private int start;
        private int end;
        private String url;
        private List<String> listData;
     
        private CallBackResuil backResuil;
        
        public FeedData(int start,int end,String url,CallBackResuil backResuil){
            this.start = start;
            this.end = end;
            this.url = url;
            this.backResuil = backResuil;
            backResuil.onStart();
        }
        
    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
        backResuil.succeed(listData, pageView);
    }

    
    @Override
    protected Void doInBackground() throws Exception {
        listData = new ArrayList<>();
        try {
            for (int i = start; i <= end; i++) {
                Document doc = Jsoup.connect("http://www.one2car.com/"+url+"/?page_number="+i)
//                        .timeout(10 * 1000)
                        .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36")
                        .get();
                Elements e = doc.select("div.items");
                Elements item = e.select("div.card-indicator");
                Elements header = item.select("div.card-header");


                for (Element r : header.select("h2[class=card-title pull-left wrap]")) {

                        listData.add(r.text());
                }

                pageView = doc.select("div[class=turbo-pager pull-left] > span[class=lbl]").text();
              
                backResuil.onProgressBar(end, i);
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
