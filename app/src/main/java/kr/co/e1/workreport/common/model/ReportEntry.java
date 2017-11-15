package kr.co.e1.workreport.common.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import kr.co.e1.workreport.common.DateUtils;
import kr.co.e1.workreport.common.ReportType;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Created by jaeho on 2017. 11. 10
 */

@ToString @Data @Accessors(chain = true) public class ReportEntry {
  private ReportType type;
  private String contents;
  private int code = -1;

  public static List<ReportEntry> createReportEntrys(ReportContent content) {
    final List<ReportEntry> entries = new ArrayList<>();

    entries.add(new ReportEntry().setType(ReportType.DATE)
        .setContents(DateUtils.getIncludeDayOfWeek(content.getDate())));

    entries.add(new ReportEntry().setType(ReportType.DEPT).setContents(content.getDeptName()));

    entries.add(new ReportEntry().setType(ReportType.NAME).setContents(content.getUserName()));

    entries.add(new ReportEntry().setType(ReportType.START_TIME).setContents(content.getSTime()));

    entries.add(new ReportEntry().setType(ReportType.END_TIME).setContents(content.getETime()));

    entries.add(
        new ReportEntry().setType(ReportType.WORKING_TIME).setContents(content.getExtraTime()));

    String detailWork =
        content.getDetailWork().getCode() + " / " + content.getDetailWork().getDetail();

    entries.add(new ReportEntry().setType(ReportType.DETAIL_WORK).setContents(detailWork).setCode(content.getDetailWork().getCode()));

    String project = TextUtils.isEmpty(content.getProjects().getName()) ? ""
        : content.getProjects().getName();

    entries.add(new ReportEntry().setType(ReportType.PROJECT).setContents(project));

    entries.add(
        new ReportEntry().setType(ReportType.MODIFIED_TIME).setContents(content.getUpdTime()));

    return entries;
  }
}
