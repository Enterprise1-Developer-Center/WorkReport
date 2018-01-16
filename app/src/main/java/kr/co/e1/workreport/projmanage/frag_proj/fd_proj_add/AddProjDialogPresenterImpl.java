package kr.co.e1.workreport.projmanage.frag_proj.fd_proj_add;

import kr.co.e1.workreport.R;

/**
 * Created by jaeho on 2018. 1. 16
 */

public class AddProjDialogPresenterImpl implements AddProjDialogPresenter {

  private AddProjDialogPresenter.View view;

  public AddProjDialogPresenterImpl(AddProjDialogPresenter.View view) {
    this.view = view;
  }

  @Override public void onClick(int id) {
    switch (id) {
      case R.id.start_date_edittext:
        break;
      case R.id.end_date_edittext:
        break;
      case R.id.dept_cd_edittext:
        break;
    }
  }
}