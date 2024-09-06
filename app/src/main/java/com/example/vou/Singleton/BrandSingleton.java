package com.example.vou.Singleton;

import com.example.vou.Model.Brand;

import java.util.List;

public class BrandSingleton {
    private static BrandSingleton instance;
    private List<Brand> brandList;
    private BrandSingleton() {}

    public static BrandSingleton getInstance() {
        if (instance == null) {
            instance = new BrandSingleton();
        }
        return instance;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}
