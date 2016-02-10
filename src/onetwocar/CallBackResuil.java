/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onetwocar;

import java.util.List;
import model.BrandModel;

/**
 *
 * @author humnoy
 */
public interface CallBackResuil {
    public void onStart();
    public void onProgressBar(int size,int i);
    public void succeed(List<String> data,String pagerView);
}
