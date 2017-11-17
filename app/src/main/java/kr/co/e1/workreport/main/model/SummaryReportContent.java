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
  private String lcls_cd;
  private String mcls_cd;
  private String detail;
  private String proj_cd;
  private String s_time;
  private String e_time;
  private String upd_time;
  private String user_id;
  private String work_ymd;

  public SummaryReportContent(List<ReportEntry> items) {
    lcls_cd = items.get(ReportType.DETAIL_WORK.getPosition()).getLcls_cd();
    mcls_cd = items.get(ReportType.DETAIL_WORK.getPosition()).getMcls_cd();
    detail = items.get(ReportType.DETAIL_WORK.getPosition()).getContents();
    proj_cd = items.get(ReportType.PROJECT.getPosition()).getProj_cd();
    s_time = items.get(ReportType.START_TIME.getPosition()).getContents();
    e_time = items.get(ReportType.END_TIME.getPosition()).getContents();
    upd_time = items.get(ReportType.MODIFIED_TIME.getPosition()).getContents();
    user_id = PreferencesUtils.getUserId();
    String dateIncludeDayOfWeek = items.get(ReportType.DATE.getPosition()).getContents();
    work_ymd = DateUtils.getExcludeDayOfWeek(dateIncludeDayOfWeek);
  }
}
