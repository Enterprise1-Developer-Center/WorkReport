package kr.co.e1.workreport.common.model;

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
  private String proj_cd = "0";
  private String mcls_cd = "0";
  private String lcls_cd = "0";

  public static List<ReportEntry> createReportEntrys(ReportContent content) {
    final List<ReportEntry> entries = new ArrayList<>();

    entries.add(new ReportEntry().setType(ReportType.DATE)
        .setContents(content.getWork_ymd()));

    entries.add(new ReportEntry().setType(ReportType.DEPT).setContents(content.getDept_nm()));

    entries.add(new ReportEntry().setType(ReportType.NAME).setContents(content.getUser_nm()));

    entries.add(new ReportEntry().setType(ReportType.START_TIME).setContents(content.getS_time()));

    entries.add(new ReportEntry().setType(ReportType.END_TIME).setContents(content.getE_time()));

    entries.add(
        new ReportEntry().setType(ReportType.WORKING_TIME).setContents(content.getExtra_time()));

    entries.add(new ReportEntry().setType(ReportType.DETAIL_WORK)
        .setContents(content.getMcls().getDetail())
        .setMcls_cd(content.getMcls().getMcls_cd()));

    entries.add(new ReportEntry().setType(ReportType.PROJECT)
        .setContents(content.getProj().getProj_nm())
        .setProj_cd(content.getProj().getProj_cd()));

    entries.add(
        new ReportEntry().setType(ReportType.MODIFIED_TIME).setContents(content.getUpd_time()));

    return entries;
  }
}
