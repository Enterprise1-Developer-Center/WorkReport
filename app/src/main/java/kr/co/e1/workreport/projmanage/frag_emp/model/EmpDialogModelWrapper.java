package kr.co.e1.workreport.projmanage.frag_emp.model;

import kr.co.e1.workreport.common.model.DetailWork;
import kr.co.e1.workreport.main.dg_proje.model.Project;
import lombok.Data;

/**
 * Created by jaeho on 2018. 1. 23
 */

@Data public class EmpDialogModelWrapper {
  private User user;
  private Project project;
  private String startDate;
  private String endDate;
  private UserStats userStats;
  private DetailWork detailWork;

}
