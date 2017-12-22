package kr.co.e1.workreport.framework.abs;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by jaeho on 2017. 12. 22
 */

public abstract class OnSimpleItemSelectedListener implements AdapterView.OnItemSelectedListener {

  @Override public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    onItemSelected(position, id);
  }

  @Override public void onNothingSelected(AdapterView<?> parent) {

  }

  public abstract void onItemSelected(int position, long id);
}
