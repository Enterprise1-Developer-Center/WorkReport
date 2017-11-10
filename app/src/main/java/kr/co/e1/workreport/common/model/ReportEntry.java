package kr.co.e1.workreport.common.model;

import kr.co.e1.workreport.common.Report;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by jaeho on 2017. 11. 10
 */

@AllArgsConstructor @Getter public class ReportEntry {
  private Report entry;
  private String contents;
}
