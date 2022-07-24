package manager;

import dao.UserDao;

import java.sql.SQLException;
import java.util.Scanner;

public class UserManager {
    static Scanner sc=new Scanner(System.in);
    static UserDao ud=new UserDao();
    public static boolean userlogin(String username,String pass) throws SQLException, ClassNotFoundException {

//        boolean a=ud.userLogin(username,pass);

        return true;
    }


}
