package com.learn.controller;

import com.learn.dao.LoginDao;
import com.learn.dao.daoIplm.LoginDaoImpl;
import com.learn.entities.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    LoginDao loginDAO = null;

    public LoginController() {
        loginDAO = new LoginDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Login login = new Login();
        login.setEmail(request.getParameter("email"));
        login.setPassword(request.getParameter("password"));

        String result=loginDAO.loginCheck(login);

        if(result.equals("true")){
            session.setAttribute("email",login.getEmail());
            response.sendRedirect("EmployeeController?action=list");
        }

        if(result.equals("false")){
            response.sendRedirect("index.jsp?status=false");
        }

        if(result.equals("error")){
            response.sendRedirect("index.jsp?status=error");
        }
    }
}
