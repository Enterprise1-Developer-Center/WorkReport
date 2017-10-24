package kr.co.e1.workreport.classification;

import android.os.Bundle;
import kr.co.e1.workreport.classification.vo.ClassificationCode;
import kr.co.e1.workreport.framework.adapter.BaseAdapterDataModel;

/**
 * Created by jaeho on 2017. 10. 24
 */

public class ClassificationPresenterImpl implements ClassificationPresenter {

  private ClassificationPresenter.View view;
  private BaseAdapterDataModel<ClassificationCode> adapterDataModel;

  ClassificationPresenterImpl(ClassificationPresenter.View view,
      BaseAdapterDataModel adapterDataModel) {
    this.view = view;
    this.adapterDataModel = adapterDataModel;
  }

  @Override public void onActivityCreate(Bundle savedInstanceState) {
    view.setRecyclerView();

    //Request data;
    adapterDataModel.add(new ClassificationCode("11", "Profits", "Outside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("12", "Profits", "Inside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("13", "Profits", "Project Support",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("22", "Invest", "Outside Project",
        "외부 프로젝트로 계약기간 이외의 기간이거나 수익발생이 안되는 경우이지만 회사 전략상 필요하다고 판단되어 승인된 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("11", "Profits", "Outside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("12", "Profits", "Inside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("13", "Profits", "Project Support",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("22", "Invest", "Outside Project",
        "외부 프로젝트로 계약기간 이외의 기간이거나 수익발생이 안되는 경우이지만 회사 전략상 필요하다고 판단되어 승인된 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("11", "Profits", "Outside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("12", "Profits", "Inside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("13", "Profits", "Project Support",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("22", "Invest", "Outside Project",
        "외부 프로젝트로 계약기간 이외의 기간이거나 수익발생이 안되는 경우이지만 회사 전략상 필요하다고 판단되어 승인된 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("11", "Profits", "Outside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("12", "Profits", "Inside Project",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("13", "Profits", "Project Support",
        "외부 프로젝트로 정식계약에의해 진행 되며 계약기간동안 프로젝트를 수행하고 있는 프로젝트나 유지보수", "유저입력"));
    adapterDataModel.add(new ClassificationCode("22", "Invest", "Outside Project",
        "외부 프로젝트로 계약기간 이외의 기간이거나 수익발생이 안되는 경우이지만 회사 전략상 필요하다고 판단되어 승인된 프로젝트나 유지보수", "유저입력"));
    view.refresh();
  }
}