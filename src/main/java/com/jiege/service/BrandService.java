package com.jiege.service;

import com.jiege.pojo.Brand;
import com.jiege.pojo.PageBen;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    void add(Brand brand);
    void deleteById(int ids[]);
    PageBen<Brand> selectByPage(int currentPage,int pageSize);
}
