package com.jiege.web;



import com.jiege.pojo.User;
import com.jiege.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = service.register(user);
        if(username == "" || password== ""){
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("����");
        }else if(flag){
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("ע��ɹ�");
        }else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("�û��Ѵ���");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
