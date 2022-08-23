package com.jiege.web;

import com.alibaba.fastjson.JSON;
import com.jiege.pojo.Brand;
import com.jiege.pojo.PageBen;
import com.jiege.service.BrandService;
import com.jiege.service.impl.BrandServiceImpl;
import org.apache.ibatis.annotations.Insert;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectByPageServlet")
public class SelectByPageServlet extends HttpServlet {
    private BrandService brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBen<Brand> pageBen = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBen);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
