/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unseencar;

import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import model.BrandModel;
import onetwocar.CallBackResuilBrand;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author humnoy
 */
public class FeedBrandUnSeen extends SwingWorker<Void, Void>{
    private List<BrandModel> brandModels;
    private CallBackResuilBrand resuilBrand;
    private String[] obj_list_brand;
    
    public FeedBrandUnSeen(CallBackResuilBrand resuilBrand){
        this.resuilBrand = resuilBrand;
    }
    
    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
    resuilBrand.succeed(obj_list_brand, brandModels);
    }
    
    

    @Override
    protected Void doInBackground() throws Exception {
        
        
          Document doc = Jsoup.connect("http://www.unseencar.com/carbrand.php")
                    .timeout(10 * 1000)
                    .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36")
                    .get();
            
          brandModels = new ArrayList<>();
        if (doc != null) {
            Elements b = doc.select("div.boxBrand > div.aBrand");
            int i = 0;
            for(Element e : b){
                BrandModel bm = new BrandModel();
                obj_list_brand[i] = e.select("a").text(); i++;
               bm.setBrang(e.select("a").text());
               bm.setValuse(e.select("a").attr("href"));
               brandModels.add(bm);
//                System.out.println(e.select("a").attr("href"));
//                System.out.println(e.select("a").text());
            }
        
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
