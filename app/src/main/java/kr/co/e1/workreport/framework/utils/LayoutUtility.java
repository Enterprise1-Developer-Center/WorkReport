package kr.co.e1.workreport.framework.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;

/**
 * Created by jaeho on 2017. 11. 18
 */

public class LayoutUtility {

  public static @DrawableRes int getSelectableItemBackground(Context context) {
    TypedValue outValue = new TypedValue();
    context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
    return outValue.resourceId;
  }

  public static ColorStateList getColorStateList(Context context, @ColorRes int resId) {
    return ColorStateList.valueOf(ContextCompat.getColor(context, resId));
  }

  public static int getColor(Context context, @ColorRes int resId) {
    return ContextCompat.getColor(context, resId);
  }
}
