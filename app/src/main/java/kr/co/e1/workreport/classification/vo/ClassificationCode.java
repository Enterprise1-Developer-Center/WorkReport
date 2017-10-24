package kr.co.e1.workreport.classification.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 10. 24
 */

@ToString @AllArgsConstructor public class ClassificationCode {
  @Getter private String code;
  @Getter private String bigClass;
  @Getter private String smallClass;
  @Getter private String description;
  @Getter private String detailWork;
}
