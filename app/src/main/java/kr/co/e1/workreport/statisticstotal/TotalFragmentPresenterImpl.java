package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.os.Handler;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;
import kr.co.e1.workreport.statisticstotal.model.TotalSummary;

/**
 * Created by jaeho on 2017. 11. 2
 */

public class TotalFragmentPresenterImpl implements TotalFragmentPresenter {

  private View view;
  private BaseAdapterDataModel<TotalSummary> adapterDataModel;

  TotalFragmentPresenterImpl(View view, BaseAdapterDataModel adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.showProgress();
    view.setRecyclerView();

    new Handler().postDelayed(() -> {
      List<TotalSummary> items = new ArrayList<>();
      items.add(new TotalSummary("Profits", 1207));
      items.add(new TotalSummary("Invest", 340));
      items.add(new TotalSummary("Loss", 0));
      items.add(new TotalSummary("Support", 8));
      items.add(new TotalSummary("Educate & Proposal", 138));
      items.add(new TotalSummary("Vacation & Etc", 71));
      items.add(new TotalSummary("SUM", 1424));
      adapterDataModel.addAll(items);

      for (int i = 0; i < items.size(); i++) {
        view.refresh(i);
      }

      view.hideProgress();
    }, 1000);

    /*
          view.showProfits("1197");
      view.showInvest("340");
      view.showLoss("0");
      view.showSupport("8");
      view.showEducate("138");
      view.showVacation("71");
      view.showSum("1414");
      view.hideProgress();

    */
  }

  @Override public void onClick(int id) {
    if (id == R.id.detail_button) view.showMessage(R.string.coming_soon);
  }
}
