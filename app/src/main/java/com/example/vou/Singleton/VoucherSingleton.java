package com.example.vou.Singleton;

import com.example.vou.Model.Voucher;

import java.util.ArrayList;
import java.util.List;

public class VoucherSingleton {
    private static VoucherSingleton instance;
    List<Voucher> voucherList;
    List<Voucher> myVoucherList = new ArrayList<>();
    List<Voucher> historyVoucherList = new ArrayList<>();

    public VoucherSingleton(){}

    public static VoucherSingleton getInstance(){
        if(instance == null){
            instance = new VoucherSingleton();
        }
        return instance;
    }

    public Voucher getVoucher(int voucherId){
        for(int i = 0; i < voucherList.size(); i++){
            if(voucherList.get(i).getId() == voucherId){
                return voucherList.get(i);
            }
        }
        return null;
    }

    public List<Voucher> getVoucherList() {
        return voucherList;
    }

    public void setVoucherList(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }

    public List<Voucher> getMyVoucherList() {
        return myVoucherList;
    }

    public void setMyVoucherList(List<Voucher> myVoucherList) {
        this.myVoucherList = myVoucherList;
    }

    public List<Voucher> getHistoryVoucherList() {
        return historyVoucherList;
    }

    public void setHistoryVoucherList(List<Voucher> historyVoucher) {
        this.historyVoucherList = historyVoucher;
    }

    public void addMyVoucher(int voucherId){
        for(int i = 0; i < voucherList.size(); i++){
            if(voucherList.get(i).getId() == voucherId){
                myVoucherList.add(voucherList.get(i));
                return;
            }
        }
    }

    public void addVoucherFromGame(int voucherId){
        for(int i = 0; i < voucherList.size(); i++){
            if(voucherList.get(i).getId() == voucherId){
                for(int j = 0; j < myVoucherList.size(); j++){
                    if(myVoucherList.get(j).getId() == voucherId){
                        if(myVoucherList.get(j).getType() == 2){
                            int availablePieces = myVoucherList.get(j).getAvailablePieces();
                            myVoucherList.get(j).setAvailablePieces(availablePieces + 1);
                        }
                        else {
                            return;
                        }
                    }
                }
                myVoucherList.add(voucherList.get(i));
                return;
            }
        }
    }



    public void addHistoryVoucher(int voucherId){
        for(int i = 0; i < voucherList.size(); i++){
            if(voucherList.get(i).getId() == voucherId){
                historyVoucherList.add(voucherList.get(i));
                return;
            }
        }
    }
}
