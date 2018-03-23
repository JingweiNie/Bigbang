package market;

/**
 * Created by niejingwei on 2018/3/23.
 */

public class Goods {
    private int goods_pic;
    private String goods_describe;
    private String price;
    private String address;
    private String selfLabel_1;
    private String selfLabel_2;
    private String selfLabel_3;
    private String selfLabel_4;
    private String selfLabel_5;
    private String sysLabel_1;
    private String sysLabel_2;
    private String sysLabel_3;
    private String sysLabel_4;

    public Goods(int goods_pic, String goods_describe, String price, String address, String selfLabel_1, String selfLabel_2, String selfLabel_3, String selfLabel_4, String selfLabel_5, String sysLabel_1, String sysLabel_2, String sysLabel_3, String sysLabel_4) {
        this.goods_pic = goods_pic;
        this.goods_describe = goods_describe;
        this.price = price;
        this.address = address;
        this.selfLabel_1 = selfLabel_1;
        this.selfLabel_2 = selfLabel_2;
        this.selfLabel_3 = selfLabel_3;
        this.selfLabel_4 = selfLabel_4;
        this.selfLabel_5 = selfLabel_5;
        this.sysLabel_1 = sysLabel_1;
        this.sysLabel_2 = sysLabel_2;
        this.sysLabel_3 = sysLabel_3;
        this.sysLabel_4 = sysLabel_4;
    }

    public int getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(int goods_pic) {
        this.goods_pic = goods_pic;
    }

    public String getGoods_describe() {
        return goods_describe;
    }

    public void setGoods_describe(String goods_describe) {
        this.goods_describe = goods_describe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSelfLabel_1() {
        return selfLabel_1;
    }

    public void setSelfLabel_1(String selfLabel_1) {
        this.selfLabel_1 = selfLabel_1;
    }

    public String getSelfLabel_2() {
        return selfLabel_2;
    }

    public void setSelfLabel_2(String selfLabel_2) {
        this.selfLabel_2 = selfLabel_2;
    }

    public String getSelfLabel_3() {
        return selfLabel_3;
    }

    public void setSelfLabel_3(String selfLabel_3) {
        this.selfLabel_3 = selfLabel_3;
    }

    public String getSelfLabel_4() {
        return selfLabel_4;
    }

    public void setSelfLabel_4(String selfLabel_4) {
        this.selfLabel_4 = selfLabel_4;
    }

    public String getSelfLabel_5() {
        return selfLabel_5;
    }

    public void setSelfLabel_5(String selfLabel_5) {
        this.selfLabel_5 = selfLabel_5;
    }

    public String getSysLabel_1() {
        return sysLabel_1;
    }

    public void setSysLabel_1(String sysLabel_1) {
        this.sysLabel_1 = sysLabel_1;
    }

    public String getSysLabel_2() {
        return sysLabel_2;
    }

    public void setSysLabel_2(String sysLabel_2) {
        this.sysLabel_2 = sysLabel_2;
    }

    public String getSysLabel_3() {
        return sysLabel_3;
    }

    public void setSysLabel_3(String sysLabel_3) {
        this.sysLabel_3 = sysLabel_3;
    }

    public String getSysLabel_4() {
        return sysLabel_4;
    }

    public void setSysLabel_4(String sysLabel_4) {
        this.sysLabel_4 = sysLabel_4;
    }
}
