package kr.co.e1.workreport.project.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 29
 */

@ToString @AllArgsConstructor public class Project {
  @Getter private int id;
  @Getter private String name;
}
