package kr.co.e1.workreport.statisticstotal;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseFragment;

/**
 * Created by jaeho on 2017. 10. 31
 */

public class TotalFragment extends BaseFragment implements TotalFragmentPresenter.View {

  @BindView(R.id.profits_textview) TextView profitsTextview;
  @BindView(R.id.invest_textview) TextView investTextview;
  @BindView(R.id.loss_textview) TextView lossTextview;
  @BindView(R.id.support_textview) TextView supportTextview;
  @BindView(R.id.educate_textview) TextView educateTextview;
  @BindView(R.id.vacation_textview) TextView vacationTextview;
  @BindView(R.id.sum_textview) TextView sumTextview;
  @BindView(R.id.progress_bar) ProgressBar progressBar;
  @Inject TotalFragmentPresenter presenter;

  public static TotalFragment newInstance() {
    return new TotalFragment();
  }

  @Override protected int getLayoutResID() {
    return R.layout.fragment_total;
  }

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean isDagger() {
    return true;
  }

  @Override public void showProgress() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override public void showProfits(String value) {
    profitsTextview.setText(value);
  }

  @Override public void showInvest(String value) {
    investTextview.setText(value);
  }

  @Override public void showLoss(String value) {
    lossTextview.setText(value);
  }

  @Override public void showSupport(String value) {
    supportTextview.setText(value);
  }

  @Override public void showEducate(String value) {
    educateTextview.setText(value);
  }

  @Override public void showVacation(String value) {
    vacationTextview.setText(value);
  }

  @Override public void showSum(String value) {
    sumTextview.setText(value);
  }
}
