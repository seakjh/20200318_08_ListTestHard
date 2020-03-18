package com.example.a20200318_08_listtesthard.datas;

import java.io.Serializable;

public class Room implements Serializable {

    private int price;
    private String address;
    private int floor;
    private String explanation;

    public String getFloorToString() {
        //        층수를 가공
        String floorstr = "";
//        층 > 0 층 == 0 , 그외 층 < 0
        if(this.floor > 0){
            floorstr = String.format("%d층", this.floor);
        }
        else if (this.floor == 0){
//            0 => 반지하
            floorstr = "반지하";
        }
        else {
//            -1 => 지하 1층으로 가공
            floorstr = String.format("지하 %d층", this.floor*-1);
        }

        return floorstr;
    }

    public String getFormattedPrice() {
//        상황에따라 ?억 ?천
//        나눠서 가공

        if(this.price >= 10000){
            int billion = this.price / 10000;
            int thousand = this.price % 10000;

            return String.format("%d억 %,d만원", billion, thousand);
        }
        else {
            return String.format("%,d만원", this.price);
        }

    }

    public Room(int price, String address, int floor, String explanation) {
        this.price = price;
        this.address = address;
        this.floor = floor;
        this.explanation = explanation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
