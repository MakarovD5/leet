package com.hsp.house;

import java.util.Scanner;

/**
 * @author MakarovD
 * @date 2022/5/28
 */
public class HouseView {
    private boolean loop;
    private Scanner scan;
    private char key;
    private HouseService houseService = new HouseService(2);
    public void view() {
        loop = true;
        do {
            System.out.println("---------------House System------------------");
            System.out.println("           1. new house");
            System.out.println("           2. find house");
            System.out.println("           3. delete house");
            System.out.println("           4. update house");
            System.out.println("           5. list house");
            System.out.println("           6. exit");
            System.out.println("--------------------------------------------");

            System.out.print("input(1-6):");
            key = Utility.readMenuSelection();

            switch (key) {
                case '1':
                    addView();
                    break;
                case '2':
                    findView();
                    break;
                case '3':
                    deleteView();
                    break;
                case '4':
                    updateView();
                    break;
                case '5':
                    listView();
                    break;
                case '6':
                    char confirm = Utility.readConfirmSelection();
                    if (confirm=='Y'){
                        loop = false;
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + key);
            }
        }while (loop);

        System.out.println("---------------exit----------------");
    }

    private void listView() {
        int houseNum = houseService.getHouseNum();
        House[] houselist = houseService.list();

        System.out.println("---------------House list------------------");
        System.out.println("id\thostname\ttel\taddress\trent\tstats");
        for (int i = 0; i<houseNum; i++){
            System.out.println(houselist[i]);
        }
    }

    private void addView() {
        System.out.println("---------------House add------------------");
        System.out.printf("name:");
        String name = Utility.readString(9);
        System.out.printf("tel:");
        String tel = Utility.readString(12);
        System.out.printf("address:");
        String address = Utility.readString(20);
        System.out.printf("rent:");
        int rent = Utility.readInt();
        System.out.printf("stats:");
        String stats = Utility.readString(10);
        boolean b = houseService.addHouse(name, tel, address, rent, stats);
        if (b){
            System.out.println("---------------add completed------------------");
        }else {
            System.out.println("---------------add failed------------------");
        }
    }

    private void findView() {
        System.out.println("---------------House find------------------");
        System.out.printf("find id:");
        int findId = Utility.readInt();
        House house = houseService.find(findId);
        if (house==null){
            System.out.println("---------------find failed------------------");
            return;
        }
        System.out.println("id\thostname\ttel\taddress\trent\tstats");
        System.out.println(house);
    }

    private void deleteView() {
        System.out.println("---------------House delete------------------");
        System.out.printf("delete id(-1 exit):");
        int deleteId = Utility.readInt();
        if (deleteId == -1){
            return;
        }
        char confirm = Utility.readConfirmSelection();
        if (confirm == 'N'){
            return;
        }

        boolean deleteConfirm = houseService.delete(deleteId);
        if (deleteConfirm){
            System.out.println("---------------House delete completed------------------");
        }else {
            System.out.println("---------------House delete failed------------------");
        }
    }

    private void updateView() {
        System.out.println("---------------House update------------------");
        System.out.printf("update id(-1 exit):");
        int updateId = Utility.readInt();
        if (updateId == -1){
            return;
        }

        House house = houseService.find(updateId);
        if (house==null){
            System.out.println("error:house not exist");
            return;
        }

        System.out.printf("name("+house.getName()+"):");
        String name = Utility.readString(10,house.getName());
        System.out.printf("tel("+house.getTel()+"):");
        String tel = Utility.readString(10,house.getTel());
        System.out.printf("address("+house.getAddress()+"):");
        String address = Utility.readString(10,house.getAddress());
        System.out.printf("rent("+house.getRent()+"):");
        int rent = Utility.readInt(house.getRent());
        System.out.printf("stats("+house.getStats()+"):");
        String stats = Utility.readString(10,house.getStats());

        if (houseService.update(house,name,tel,address,rent,stats)){
            System.out.println("---------------House update completed------------------");
        }else {
            System.out.println("---------------House update faile------------------");
        }
    }

}
