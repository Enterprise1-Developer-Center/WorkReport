package kr.co.e1.workreport.framework.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by jaeho on 2017. 10. 11
 */

public class SystemUtility {

  public static void hideKeyboard(Context context, View view) {
    if (view != null) {
      InputMethodManager imm =
          (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
  }

  public static void showSoftKeyboard(Context context, View view) {
    if (view != null) {
      if (view.requestFocus()) {
        InputMethodManager imm =
            (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
      }
    }
  }
}
