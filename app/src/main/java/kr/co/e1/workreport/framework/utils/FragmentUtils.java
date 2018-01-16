package kr.co.e1.workreport.framework.utils;

import android.support.v4.app.Fragment;

/**
 * Created by jaeho on 2017. 10. 10
 */

public class FragmentUtils {

  public static boolean isSafeFragment(Fragment frag) {
    return !(frag.isRemoving()
        || frag.getActivity() == null
        || frag.isDetached()
        || !frag.isAdded()
        || frag.getView() == null);
  }
}
