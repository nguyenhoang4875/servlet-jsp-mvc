package com.learn.dao.daoIplm;

import com.learn.dao.LoginDao;
import com.learn.entities.Login;
import com.learn.jdbc.ConnectionProvider;
import com.learn.jdbc.ConnectionProviderImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDaoImpl implements LoginDao {
    private ConnectionProvider connectionProvider;
    public LoginDaoImpl() {
        connectionProvider = new ConnectionProviderImpl();
    }

        @Override
        public String loginCheck(Login loginBean) {
            String query="select * from tbl_login where email=? and password=?";

            try{
                Connection con=connectionProvider.getConnection();
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,loginBean.getEmail());
                ps.setString(2,loginBean.getPassword());

                ResultSet rs=ps.executeQuery();

                if(rs.next()){
                    return "true";
                }
                else{
                    return "false";
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            return "error";
        }

}
