package kr.co.e1.workreport.main.adapter;

import kr.co.e1.workreport.framework.adapter.BaseAdapterView;

/**
 * Created by jaeho on 2017. 11. 16
 */

public interface MainAdapterView extends BaseAdapterView {
  void refresh(int position);
  void refreshRemove();
}
