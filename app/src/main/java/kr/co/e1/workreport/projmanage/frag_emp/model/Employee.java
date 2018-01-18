package kr.co.e1.workreport.projmanage.frag_emp.model;

import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2018. 1. 18..
 */

@Getter @ToString public class Employee {
  private String proj_cd;
  private String user_id;
  private String user_sdate;
  private String user_edate;
  private String lcls_cd;
  private String mcls_cd;
}
