package kr.co.e1.workreport.common.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.common.DateUtils;
import kr.co.e1.workreport.common.ReportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jaeho on 2017. 11. 10
 */

@ToString @AllArgsConstructor @Getter public class ReportEntry {
  private ReportType type;
  @Setter private String contents;

  public static List<ReportEntry> createReportEntrys(ReportContent content) {
    final List<ReportEntry> entries = new ArrayList<>();

    entries.add(new ReportEntry(ReportType.DATE, DateUtils.getIncludeDayOfWeek(content.getDate())));
    entries.add(new ReportEntry(ReportType.DEPT, content.getDeptName()));
    entries.add(new ReportEntry(ReportType.NAME, content.getUserName()));
    entries.add(new ReportEntry(ReportType.START_TIME, content.getSTime()));
    entries.add(new ReportEntry(ReportType.END_TIME, content.getETime()));
    entries.add(new ReportEntry(ReportType.WORKING_TIME, content.getExtraTime()));
    entries.add(new ReportEntry(ReportType.DETAIL_WORK,
        content.getDetailWork().getCode() + " / " + content.getDetailWork().getDetail()));
    String project =
        TextUtils.isEmpty(content.getProjects().getName()) ? "" : content.getProjects().getName();
    entries.add(new ReportEntry(ReportType.PROJECT, project));
    entries.add(new ReportEntry(ReportType.MODIFIED_TIME, content.getUpdTime()));

    return entries;
  }
}
