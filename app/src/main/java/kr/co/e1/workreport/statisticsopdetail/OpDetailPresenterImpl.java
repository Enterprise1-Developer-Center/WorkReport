package kr.co.e1.workreport.statisticsopdetail;

import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.statisticsopdetail.model.OpDetail;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class OpDetailPresenterImpl implements OpDetailPresenter {

  private View view;
  private BaseAdapterDataModel<OpDetail> adapterDataModel;

  OpDetailPresenterImpl(View view, BaseAdapterDataModel adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onCreated(Bundle savedInstanceState) {
    view.setRecyclerView();
    view.showProgress();
    new Handler().postDelayed(() -> {
      List<OpDetail> items = new ArrayList<>();
      for (int i = 0; i < 13; i++) {
        OpDetail t = new OpDetail();
        t.setName("홍" + i + "연");
        t.setJan("98.8");
        t.setFeb("98.8");
        t.setMar("98.8");
        t.setApr("98.8");
        t.setMay("98.8");
        t.setJun("98.8");
        t.setJul("98.8");
        t.setAug("98.8");
        t.setSep("98.8");
        t.setOct("98.8");
        t.setNov("98.8");
        t.setDec("98.8");
        t.setNowOpRatio("98.8");
        t.setYearOpRatio("98.8");
        items.add(t);
      }
      adapterDataModel.addAll(items);
      for (int i = 0; i < items.size(); i++) {
        view.refresh(i);
      }
      view.hideProgress();
    }, 1000);
    //adapterDataModel.addAll(items);
    //adapterDataModel.addAll(items);
    //view.refresh();
  }
}