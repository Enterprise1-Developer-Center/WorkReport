package kr.co.e1.workreport.classification;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import butterknife.BindView;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.classification.adapter.ClassificationAdapter;
import kr.co.e1.workreport.framework.BaseAlertDialogFragment;
import timber.log.Timber;

/**
 * Created by jaeho on 2017. 10. 23
 */

public class ClassificationDialogFragment extends BaseAlertDialogFragment
    implements ClassificationPresenter.View {

  @Inject ClassificationPresenter presenter;

  @Override protected void onActivityCreate(Bundle savedInstanceState) {
    presenter.onActivityCreate(savedInstanceState);
  }

  @Override protected boolean getAttatchRoot() {
    return false;
  }

  @Override protected int getLayoutRes() {
    return R.layout.dialog_fragment_classification_code;
  }

  @Override protected ViewGroup getRoot() {
    return null;
  }

  @Override protected boolean isDialogCancelable() {
    return false;
  }

  @Override protected int getTitle() {
    return R.string.classification_code;
  }

  @Override protected DialogInterface.OnClickListener getOkOnClickListener() {
    return (dialog, which) -> {
      Timber.d("");
    };
  }

  @Override protected DialogInterface.OnClickListener getCancelOnClickListener() {
    return (dialog, which) -> {
      dialog.dismiss();
    };
  }

  @BindView(R.id.recyclerview) RecyclerView recyclerView;
  @Inject ClassificationAdapter adapter;

  @Override public void setRecyclerView() {
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapter.refresh();
  }
}