import java.util.Date;
package za.ac.cput.domain;

public class Report {
  private int reportID;
  private String reportType;
  private Date startDate;

  private Report(Builder builder){
  this.reportID = builder.reportID;
    this.reportType = builder.reportType;
    this.generatedDate = builder.generatedDate;
    this.startDate = builder.startDate;
    this.endDate = builder.endDate;
  }
  public int getReportID() {
        return reportID;
    }

    public String getReportType() {
        return reportType;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    } 
  public void viewReport() {
        System.out.println("Report ID: " + reportID);
        System.out.println("Report Type: " + reportType);
        System.out.println("Generated Date: " + generatedDate);
    }

    public static class Builder {

        private int reportID;
        private String reportType;
        private Date generatedDate;
        private Date startDate;
        private Date endDate;

        public Builder setReportID(int reportID) {
            this.reportID = reportID;
            return this;
        }

        public Builder setReportType(String reportType) {
            this.reportType = reportType;
            return this;
        }

        public Builder setGeneratedDate(Date generatedDate) {
            this.generatedDate = generatedDate;
            return this;
        }

        public Builder setStartDate(Date startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setEndDate(Date endDate) {
            this.endDate = endDate;
            return this;
        }

        public Report build() {
            return new Report(this);
        }
}
