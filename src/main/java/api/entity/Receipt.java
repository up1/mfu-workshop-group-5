package api.entity;

import java.util.Date;

public class Receipt {
    private double receipt_id;
    private double member_id;
    private Date date_time;
    private double total;
    private String shop_name;

    public double getReceiptId(){
        return receipt_id;
    }

    public void setReceiptId(double receipt_id){
        this.receipt_id = receipt_id;
    }

    public double getMemberId(){
        return member_id;
    }

    public void setMemberId(double member_id){
        this.member_id = member_id;
    }

    public Date getDateTime(){
        return date_time;
    }

    public void setDateTime(Date date_time){
        this.date_time = date_time;
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;
    }

    public String getShopName(){
        return shop_name;
    }

    public void setShopName(String shop_name){
        this.shop_name = shop_name;
    }
}