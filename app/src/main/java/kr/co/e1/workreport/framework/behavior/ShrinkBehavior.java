package kr.co.e1.workreport.framework.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/**
 * Created by jaeho on 2017. 10. 20
 */

public class ShrinkBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

  public ShrinkBehavior() {
  }

  public ShrinkBehavior(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  @Override public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child,
      View dependency) {
    return dependency instanceof Snackbar.SnackbarLayout;
  }

  @Override
  public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child,
      View dependency) {
    float translationY = getFabTranslationYForSnackbar(parent, child);
    float percentComplete = -translationY / dependency.getHeight();
    float scaleFactor = 1 - percentComplete;

    child.setScaleX(scaleFactor);
    child.setScaleY(scaleFactor);
    return false;
  }

  private float getFabTranslationYForSnackbar(CoordinatorLayout parent, FloatingActionButton fab) {
    float minOffset = 0;
    final List<View> dependencies = parent.getDependencies(fab);
    for (int i = 0, z = dependencies.size(); i < z; i++) {
      final View view = dependencies.get(i);
      if (view instanceof Snackbar.SnackbarLayout && parent.doViewsOverlap(fab, view)) {
        minOffset = Math.min(minOffset, view.getTranslationY() - view.getHeight());
      }
    }

    return minOffset;
  }
}