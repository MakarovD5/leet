package com.hsp.house;

/**
 * @author MakarovD
 * @date 2022/5/28
 */
public class House {
    private int id;
    private String name;
    private String tel;
    private String address;
    private int rent;
    private String stats;

    public House(int id, String name, String tel, String address, int rent, String stats) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.rent = rent;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id +
                "\t" + name +
                "\t\t\t" + tel +
                "\t" + address +
                "\t" + rent +
                "\t\t" + stats;
    }
}
