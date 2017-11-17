package kr.co.e1.workreport.main.model;

import java.util.List;
import kr.co.e1.workreport.common.DateUtils;
import kr.co.e1.workreport.common.PreferencesUtils;
import kr.co.e1.workreport.common.ReportType;
import kr.co.e1.workreport.common.model.ReportEntry;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 16
 */

@ToString @Getter public class SummaryReportContent {
  private String majorCode;
  private String smallCode;
  private String work;
  private String projectCode;
  private String startTime;
  private String endTime;
  private String updateTime;
  private String userId;
  private String date;

  public SummaryReportContent(List<ReportEntry> items) {
    majorCode = items.get(ReportType.DETAIL_WORK.getPosition()).getLcls_cd();
    smallCode = items.get(ReportType.DETAIL_WORK.getPosition()).getMcls_cd();
    work = items.get(ReportType.DETAIL_WORK.getPosition()).getContents();
    projectCode = items.get(ReportType.PROJECT.getPosition()).getProj_cd();
    startTime = items.get(ReportType.START_TIME.getPosition()).getContents();
    endTime = items.get(ReportType.END_TIME.getPosition()).getContents();
    updateTime = items.get(ReportType.MODIFIED_TIME.getPosition()).getContents();
    userId = PreferencesUtils.getUserId();
    String dateIncludeDayOfWeek = items.get(ReportType.DATE.getPosition()).getContents();
    date = DateUtils.getExcludeDayOfWeek(dateIncludeDayOfWeek);
  }
}
