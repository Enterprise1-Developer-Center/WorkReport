package kr.co.e1.workreport.framework;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;

/**
 * Created by jaeho on 2017. 9. 25
 */

public abstract class BaseFragment extends Fragment {
  private Unbinder unbinder;
  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(getLayoutResID(), container, false);
  }

  protected abstract int getLayoutResID();

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
  }
}
