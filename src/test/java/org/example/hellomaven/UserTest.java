package org.example.hellomaven;

import entity.User;
import operation.UserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class UserTest {
    UserValidation uv=new UserValidation();
    ArrayList<User> list=new ArrayList<>();
    User u1,u2;
    @BeforeEach
    public void setup()
    {

        u1=new User(1,"king","king@123");
        u2=new User(2,"Raj","raj@123");
        list.add(u1);
        list.add(u2);
    }

    @Test
    public void userValidation()
    {
        assertEquals(true,uv.userValidation(list,"king","king@123"));
        assertEquals(false,uv.userValidation(list,"kingsaa","king@123"));
//        assertNotNull("entering null value",uv.userValidation(list,"","king@123"));

    }
}
