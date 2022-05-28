package com.hsp.house;

/**
 * @author MakarovD
 * @date 2022/5/28
 */
public class HouseService {
    private House[] houses;
    private int houseNum;
    private int idCount;
//    private int len;

    public HouseService(int n) {
        this.houses = new House[n];
        houses[0] = new House(0, "house1","111","beijing",300,"no");
        houseNum = 1;
        idCount = 0;
//        len = n;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    public House[] list(){
        return houses;
    }

    public boolean addHouse(String name,String tel,String address,int rent,String stats) {
        if (houseNum==houses.length){
            System.out.println("error: houseNum==houses.length");
            return false;
        }
        idCount++;
        House house = new House(idCount, name, tel, address, rent, stats);
        houses[houseNum] = house;
        houseNum++;
        return true;
    }

    public House find(int findId) {
        for (int i = 0; i < houseNum; i++){
            if (findId == houses[i].getId()){
                return houses[i];
            }
        }

        return null;
    }

    public boolean delete(int deleteId){
        House house = find(deleteId);
        if (house==null){
            return false;
        }

        int index = -1;
        for (int i = 0; i<houseNum; i++){
            if (house==houses[i]){
                index  = i;
            }
        }

        for (int i = index; i<houseNum-1; i++){
            houses[i] = houses[i+1];
        }

        houseNum--;

        return true;
    }

    public boolean update(House house,String name,String tel,String address,int rent,String stats){
        if (house==null){
            return false;
        }
        house.setName(name);
        house.setTel(tel);
        house.setAddress(address);
        house.setRent(rent);
        house.setStats(stats);
        return true;
    }
}
