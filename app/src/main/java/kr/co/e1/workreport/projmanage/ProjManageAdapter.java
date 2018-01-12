package kr.co.e1.workreport.projmanage;

/**
 * Created by jaeho on 2018. 1. 12..
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ProjManageAdapter extends FragmentPagerAdapter {
  List<Fragment> items = new ArrayList<>();

  public ProjManageAdapter(FragmentManager fm, List<Fragment> items) {
    super(fm);
    this.items.addAll(items);
  }

  @Override public Fragment getItem(int position) {
    // getItem is called to instantiate the fragment for the given page.
    // Return a PlaceholderFragment (defined as a static inner class below).
    return items.get(position);
  }

  @Override public int getCount() {
    return items.size();
  }
}