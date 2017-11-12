package kr.co.e1.workreport.common.model;

import kr.co.e1.workreport.common.ReportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 10
 */

@ToString @AllArgsConstructor @Getter public class ReportEntry {
  private ReportType entry;
  @Setter private String contents;
}
