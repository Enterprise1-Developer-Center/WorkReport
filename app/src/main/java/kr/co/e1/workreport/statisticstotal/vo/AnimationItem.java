package kr.co.e1.workreport.statisticstotal.vo;

import android.support.annotation.AnimRes;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 11. 10
 */

@AllArgsConstructor public class AnimationItem {
  @Getter private final String name;
  @Getter private final @AnimRes int resId;
}
