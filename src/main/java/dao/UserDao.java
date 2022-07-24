package dao;

import entity.User;
import connection.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao  {

    public static List<User> userLogin(String uname, String pass) throws SQLException, ClassNotFoundException {
        Connection con = Connector.getConnection();
        List<User> res= new ArrayList<>();
        Statement s=con.createStatement();
        String query="select * from user1 Where username=? and pass=?";

        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,uname);
        ps.setString(2,pass);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            int userid=rs.getInt(1);
            String usernm= rs.getString(2);
            String password=rs.getString(3);
            User u=new User(userid,usernm,password);
            res.add(u);
        }
        return res;
    }

    public static void createSignup(String name,String pass) throws SQLException, ClassNotFoundException {
        Connection con = Connector.getConnection();
        String query="insert into user1(username,pass) values(?,?)";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,name);
        ps.setString(2,pass);

        int count=ps.executeUpdate();
        System.out.println(count+" records affected");

        System.out.println("signup successfully");


    }

    public static boolean checkUsername(String name) throws SQLException, ClassNotFoundException {
        Connection con=Connector.getConnection();
        List<User> res= new ArrayList<>();
        String query="select * from user1 where username=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    public static int getUserid(String uname,String pas) throws SQLException, ClassNotFoundException {
        int id=0;
        Connection con=Connector.getConnection();
        String query="select * from user1 where username=? and pass=?";
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,uname);
        ps.setString(2,pas);

        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            int userid=rs.getInt(1);
            id=userid;
        }
        System.out.println(id);
        return id;


    }


}
