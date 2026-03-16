package za.ac.cput.domain;

public class PrivateCollector {

    private String privateCollectorID;
    private String companyName;
    private double monthlyPrice;
    private double commissionRate;

    private PrivateCollector() {}

    private PrivateCollector(Builder builder) {
        this.privateCollectorID = builder.privateCollectorID;
        this.companyName = builder.companyName;
        this.monthlyPrice = builder.monthlyPrice;
        this.commissionRate = builder.commissionRate;
    }

    public String getPrivateCollectorID() {
        return privateCollectorID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void collectWaste(Report report) {
        System.out.println("Collecting waste for report: " + report);
    }

    public double calculateFee() {
        return monthlyPrice;
    }

    public double calculateCommission() {
        return monthlyPrice * commissionRate;
    }

    @Override
    public String toString() {
        return "PrivateCollector{" +
                "privateCollectorID='" + privateCollectorID + '\'' +
                ", companyName='" + companyName + '\'' +
                ", monthlyPrice=" + monthlyPrice +
                ", commissionRate=" + commissionRate +
                '}';
    }

    public static class Builder {

        private String privateCollectorID;
        private String companyName;
        private double monthlyPrice;
        private double commissionRate;

        public Builder setPrivateCollectorID(String privateCollectorID) {
            this.privateCollectorID = privateCollectorID;
            return this;
        }

        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public Builder setMonthlyPrice(double monthlyPrice) {
            this.monthlyPrice = monthlyPrice;
            return this;
        }

        public Builder setCommissionRate(double commissionRate) {
            this.commissionRate = commissionRate;
            return this;
        }

        public PrivateCollector build() {
            return new PrivateCollector(this);
        }
    }
}