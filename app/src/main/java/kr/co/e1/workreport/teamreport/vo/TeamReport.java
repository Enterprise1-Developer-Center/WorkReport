package kr.co.e1.workreport.teamreport.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 31
 */

@ToString @AllArgsConstructor public class TeamReport {
  @Getter private String name;
  @Getter private String summary;
}
