package za.ac.cput.domain;

public class WasteCollector
{
 private String collectorId;
 private String name;
 private long contactNumber;
 private  String assignedArea ;


  private WasteCollector(Builder builder){
     this.collectorId = builder.collectorId;
     this.name = builder.name;
     this.contactNumber = builder.contactNumber;
     this.assignedArea  = builder.assignedArea;

  }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAssignedArea() {
        return assignedArea;
    }

    public void setAssignedArea(String assignedArea) {
        this.assignedArea = assignedArea;
    }

    public static class Builder{
        private String collectorId;
        private String name;
        private long contactNumber;
        private  String assignedArea ;

        public Builder getCollectorId(String collectorId){
          this.collectorId =  collectorId;
          return this;
        }
        public Builder getName(String name){
           this.name = name;
           return this;
        }
        public  Builder  getContactNumber(long contactNumber){
            this.contactNumber = contactNumber;
            return this;
        }
        public Builder getAssignedArea(String assignedArea){
            this.assignedArea = assignedArea;
            return this;
        }

        public  WasteCollector build(){
            return new WasteCollector(this);
        }

    }
}
