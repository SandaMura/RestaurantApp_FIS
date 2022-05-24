package logIn.services;

import logIn.exceptions.loginFailed;
import logIn.model.User;

import java.util.Objects;

import static logIn.services.UserService.userRepository;

public class UserSearch {

    public static boolean searchUserCustomer(String username, String password) throws loginFailed {
     boolean found=false;
        for (User user : userRepository.find()) {
            //System.out.println
            if(user.getRole().equals("Customer"));
            {
                if (Objects.equals(username, user.getUsername()) && Objects.equals(UserService.encodePassword(username,password), user.getPassword())){
                   found=true;
                   return found;
                }


             }
    }   if(!found) throw new loginFailed();   return found;
     }


    public static boolean searchUserCook(String username, String password) throws loginFailed {
        boolean found=false;
        for (User user : userRepository.find()) {
            //System.out.println
            if(user.getRole().equals("Cook"))
            {
                if (Objects.equals(username, user.getUsername()) && Objects.equals(UserService.encodePassword(username,password), user.getPassword())){
                    found=true;
                    return found;
                }

            }
         }  if(!found) throw new loginFailed();
                 return found;
       }
public static boolean  searchUserAdmin(String username, String password) throws loginFailed {
        boolean found=false;
        for (User user : userRepository.find()) {
            //System.out.println
            if(user.getRole().equals("Admin"))
            {
                if (Objects.equals(username, user.getUsername()) && Objects.equals(UserService.encodePassword(username,password), user.getPassword())){
                    found = true;
                    return found;
                }


            }
        }
        if(!found) throw new loginFailed();
        return found;

    }

}

