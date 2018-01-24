package kr.co.e1.workreport.projmanage.frag_emp.fd_emp_edit.model;

import kr.co.e1.workreport.projmanage.frag_emp.model.Employee;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2018. 1. 24
 */

@Data public class EditEmpNetModel {
  @Accessors(chain = true) private String proj_cd;
  @Accessors(chain = true)private String user_id;
  @Accessors(chain = true)private String user_sdate;
  @Accessors(chain = true)private String user_edate;
  @Accessors(chain = true)private String lcls_cd;
  @Accessors(chain = true)private String mcls_cd;
  @Accessors(chain = true)private String user_nm;
  @Accessors(chain = true)private String proj_nm;
  @Accessors(chain = true)private String stats;

  public void initialize(Employee item) {
    this.user_nm = item.getUser_nm();
    this.user_id = item.getUser_id();
    this.proj_cd = item.getProj_cd();
    this.proj_nm = item.getProj_nm();
    this.user_sdate = item.getUser_sdate();
    this.user_edate = item.getUser_edate();
    this.mcls_cd = item.getMcls_cd();
    this.lcls_cd = item.getLcls_cd();
  }
}
