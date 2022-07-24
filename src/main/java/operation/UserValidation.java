package operation;

import entity.User;
//import sun.security.util.Password;

import java.util.List;
import java.util.stream.Collectors;

public class UserValidation {
    public boolean userValidation(List<User> l1,String username,String password) throws NullPointerException
    {
        boolean b=true;
//        if(password.isEmpty()|| username.isEmpty() || l1.isEmpty())
//        {
//            NullPointerException n=new NullPointerException("entering null value");
//            throw n;
//        }
        List<User> result=l1.stream().filter(m->m.getUsername().equals(username) && m.getPassword().equalsIgnoreCase(password)).collect(Collectors.toList());
        if(result.isEmpty())
        {
            return false;
        }
        return b;

    }
}
