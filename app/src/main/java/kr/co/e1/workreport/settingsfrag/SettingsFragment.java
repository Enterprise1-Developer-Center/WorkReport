package kr.co.e1.workreport.settingsfrag;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 10. 30
 */

public class SettingsFragment extends PreferenceFragment {

  public static SettingsFragment newInstance(Bundle args) {
    SettingsFragment f = new SettingsFragment();
    return f;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    addPreferencesFromResource(R.xml.preferences);

    findPreference("password_key").setOnPreferenceClickListener(preference -> {

      return false;
    });
  }
}
