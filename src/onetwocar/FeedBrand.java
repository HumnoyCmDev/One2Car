
package onetwocar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import model.BrandModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class FeedBrand extends SwingWorker<Void, Void> {
   
    private List<BrandModel> brandModels;
    private CallBackResuilBrand resuilBrand;
    private String[] obj_list_brand;
   public FeedBrand(CallBackResuilBrand resuilBrand){
       this.resuilBrand = resuilBrand;
       resuilBrand.onStart();
   }

    @Override
    protected void done() {
        super.done();
       resuilBrand.succeed(obj_list_brand,brandModels);   
    }

    @Override
    protected Void doInBackground() throws Exception {    
        Document doc = Jsoup.connect("http://www.one2car.com/brand/")
                    .userAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36")
                    .get(); 
               
        brandModels = new ArrayList<>();
        if (doc != null) {
            Elements make_drop_down = doc.select("select#make_drop_down");
            Elements option = make_drop_down.select("option");
            obj_list_brand = new String[option.size()];

            for (int i = 1; i < obj_list_brand.length; i++) {
                BrandModel model = new BrandModel();
                obj_list_brand[i] = option.get(i).text();
                model.setBrang(option.get(i).text());
                model.setValuse(option.get(i).attr("value"));
                
                brandModels.add(model);
                resuilBrand.onProgressBar(obj_list_brand.length,i);
                
            }
        }
            
       throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
