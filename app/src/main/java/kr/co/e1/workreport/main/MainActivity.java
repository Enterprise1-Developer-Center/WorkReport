package kr.co.e1.workreport.main;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import butterknife.OnClick;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResourceRequest;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.inject.Inject;
import kr.co.e1.workreport.R;
import kr.co.e1.workreport.framework.BaseActivity;
import kr.co.e1.workreport.login.LoginFragment;

public class MainActivity extends BaseActivity
    implements NavigationView.OnNavigationItemSelectedListener, MainPresenter.View,
    HasSupportFragmentInjector {
  @Inject MainPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter.onCreate(savedInstanceState);

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .replace(R.id.fragment_container, LoginFragment.newInstance(null))
          .addToBackStack(null)
          .commit();
    }
  }

  @Override public void setListener() {
    ActionBarDrawerToggle toggle =
        new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawer.setDrawerListener(toggle);
    toggle.syncState();

    navigationView.setNavigationItemSelectedListener(this);
  }

  @OnClick({
      R.id.date_rootview, R.id.group_rootview, R.id.person_rootview, R.id.start_time_rootview,
      R.id.end_time_rootview, R.id.code_rootview, R.id.project_rootview, R.id.last_edit_rootview
  }) void onClick(View view) {
    if (view.getId() == R.id.date_rootview) {
      javaAdapterUsers();
    } else if (view.getId() == R.id.group_rootview) {
      getUser();
    } else if (view.getId() == R.id.person_rootview) {
      createUser();
    }
  }

  private void createUser() {
    try {
      // Path Parameters (user id)
      URI adapterPath = new URI("/adapters/JavaSQL/");

      WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.POST);
      // Query Parameters
      //request.setQueryParameter("age", "36");

      // Header Parameters
      //request.addHeader("birthdate", "820601");

      // Form Parameters
      //HashMap<String, String> formParams = new HashMap<>();
      //formParams.put("height", "167");
      HashMap<String, String> formParams = new HashMap<>();
      formParams.put("userId", "enterprise1");
      formParams.put("userPw", "enterprise1");
      // Send
      request.send(formParams, new WLResponseListener() {
        public void onSuccess(WLResponse response) {
          String responseText = response.getResponseText();

          Log.d("InvokeSuccess", responseText);
        }

        public void onFailure(WLFailResponse response) {
          String errorMsg = response.getErrorMsg();
          Log.d("InvokeFail", errorMsg);
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  private void getUser() {
    try {
      // Path Parameters (user id)
      URI adapterPath = new URI("/adapters/JavaSQL/" + "mobile");

      WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.GET);
      // Query Parameters
      //request.setQueryParameter("age", "36");

      // Header Parameters
      //request.addHeader("birthdate", "820601");

      // Form Parameters
      //HashMap<String, String> formParams = new HashMap<>();
      //formParams.put("height", "167");

      // Send
      request.send(new WLResponseListener() {
        public void onSuccess(WLResponse response) {
          String responseText = response.getResponseText();
          String resultText = "";

          try {
            resultText += "Name = "
                + response.getResponseJSON().getString("first")
                + " "
                + response.getResponseJSON().getString("middle")
                + " "
                + response.getResponseJSON().getString("last")
                + "\n";
            resultText += "Age = " + response.getResponseJSON().getInt("age") + "\n";
            resultText += "Height = " + response.getResponseJSON().getString("height") + "\n";
            resultText += "Birthdate = " + response.getResponseJSON().getString("birthdate");
          } catch (org.json.JSONException e) {
            e.printStackTrace();
          }

          Log.d("InvokeSuccess", responseText + "\n" + resultText);
          Log.d("InvokeSuccess2", response.getResponseJSON().toString());
          //updateTextView(resultText);
          //Toast.makeText(MainActivity.this, resultText, Toast.LENGTH_SHORT).show();
        }

        public void onFailure(WLFailResponse response) {
          //String responseText = response.getResponseText();
          String errorMsg = response.getErrorMsg();
          Log.d("InvokeFail", errorMsg);
            /*
            Toast.makeText(MainActivity.this, "Failed to Invoke Adapter Procedure",
                Toast.LENGTH_SHORT).show();
            */
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  private void javaAdapterUsers() {
    try {
      // Path Parameters (First Name, Middle Name and Last Name)
      URI adapterPath = new URI("/adapters/JavaAdapter/users/" + "OH" + "/" + "JAE" + "/" + "HO");

      WLResourceRequest request = new WLResourceRequest(adapterPath, WLResourceRequest.POST);
      // Query Parameters
      request.setQueryParameter("age", "36");

      // Header Parameters
      request.addHeader("birthdate", "820601");

      // Form Parameters
      HashMap<String, String> formParams = new HashMap<>();
      formParams.put("height", "167");

      // Send
      request.send(formParams, new WLResponseListener() {
        public void onSuccess(WLResponse response) {
          String responseText = response.getResponseText();
          String resultText = "";

          try {
            resultText += "Name = "
                + response.getResponseJSON().getString("first")
                + " "
                + response.getResponseJSON().getString("middle")
                + " "
                + response.getResponseJSON().getString("last")
                + "\n";
            resultText += "Age = " + response.getResponseJSON().getInt("age") + "\n";
            resultText += "Height = " + response.getResponseJSON().getString("height") + "\n";
            resultText += "Birthdate = " + response.getResponseJSON().getString("birthdate");
          } catch (org.json.JSONException e) {
          }

          Log.d("InvokeSuccess", responseText + "\n" + resultText);
          //updateTextView(resultText);
          //Toast.makeText(MainActivity.this, resultText, Toast.LENGTH_SHORT).show();
        }

        public void onFailure(WLFailResponse response) {
          //String responseText = response.getResponseText();
          String errorMsg = response.getErrorMsg();
          Log.d("InvokeFail", errorMsg);
            /*
            Toast.makeText(MainActivity.this, "Failed to Invoke Adapter Procedure",
                Toast.LENGTH_SHORT).show();
            */
        }
      });
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override public void onBackPressed() {
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
        getSupportFragmentManager().popBackStack();
      } else {
        super.onBackPressed();
      }
    }
  }

  @SuppressWarnings("StatementWithEmptyBody") @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    presenter.onNavigationItemSelected(item.getItemId());
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  @Inject DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return fragmentDispatchingAndroidInjector;
  }
}