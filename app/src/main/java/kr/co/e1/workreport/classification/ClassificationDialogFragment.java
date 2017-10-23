package kr.co.e1.workreport.classification;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import hugo.weaving.DebugLog;
import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2017. 10. 23
 */

public class ClassificationDialogFragment extends DialogFragment {
  @NonNull @Override @DebugLog public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).
        setTitle("Add a picture to your aircraft:")
        .setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
          @Override public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          }
        })
        .setNegativeButton(getString(android.R.string.cancel),
            new DialogInterface.OnClickListener() {
              @Override public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
              }
            });

    //custom view

    View rootView = LayoutInflater.from(getContext())
        .inflate(R.layout.dialog_fragment_classification_code, null);
    ButterKnife.bind(this, rootView);

    //colorChecked = new ArrayList<>(12);
    //colors = new ArrayList<>(12);
    //
    //String[] cItems = {getString(R.string.red),getString(R.string.green), getString(R.string.blue),getString(R.string.yellow),
    //    getString(R.string.azur),getString(R.string.black),getString(R.string.white),getString(R.string.gray),getString(R.string.brown),
    //    getString(R.string.pink),getString(R.string.purple)};
    //
    //items = new ArrayList<>(Arrays.asList(cItems));
    //
    ////inizializzo i check a false
    //for (int i = 0; i< items.size(); i++)
    //  colorChecked.add(true);
    //
    //recyclerView = (RecyclerView)rootView.findViewById(R.id.recColors);
    //adapter = new RecyclerColorsDialogAdapter(getActivity(),colors,colorChecked,items);
    //
    //
    //
    //
    //recyclerView.setHasFixedSize(true);
    //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    //recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
    //recyclerView.setAdapter(adapter);
    builder.setView(rootView);
    AlertDialog alertDialog = builder.create();
    return builder.create();
  }

  @BindView(R.id.picker) DatePicker picker;

  @Nullable @Override @DebugLog
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override @DebugLog public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }
}
