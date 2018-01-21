package api.entity;

public class User {
    private double member_id;
    private String member_name;
    private double member_wallet;

    public double getMemberId() {
        return member_id;
    }

    public void setMemberId(double member_id) {
        this.member_id = member_id;
    }

    public double getMemberWallet() {
        return member_wallet;
    }

    public void setMemberWallet(double member_wallet) {
        this.member_wallet = member_wallet;
    }

    public String getMemberName() {
        return member_name;
    }

    public void setMemberName(String member_name) {
        this.member_name = member_name;
    }

}
