package com.example.apprunner.DB;

public class UploadPaymentDB {
    private String date;
    private String time;
    private String bank;
    private int id_user;
    private int id_add;
    private String image_link;

    public UploadPaymentDB(int id_user,int id_add,String image_link,String date,String time,String bank){
        this.id_user = id_user;
        this.id_add = id_add;
        this.image_link = image_link;
        this.date = date;
        this.time = time;
        this.bank = bank;
    }

}
