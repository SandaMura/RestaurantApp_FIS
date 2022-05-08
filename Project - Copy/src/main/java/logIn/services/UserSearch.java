package logIn.services;

import logIn.exceptions.loginFailed;
import logIn.model.User;
import logIn.services.UserService;


import java.util.Objects;

import static logIn.services.UserService.userRepository;

public class UserSearch {

    public static boolean searchUserCustomer(String username, String password) throws loginFailed {
     boolean found=false;
        for (User user : userRepository.find()) {
            //System.out.println
            if(user.getRole().equals("Customer"));
            {
                if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword())){
                   found=true;
                }

                throw new loginFailed(username);
             }
    }   if(found==false) throw new loginFailed;if(found==true) return true;
     }


    public static boolean searchUserCook(String username, String password) throws loginFailed {
        boolean found=false;
        for (User user : userRepository.find()) {
            //System.out.println
            if(user.getRole().equals("Cook");
            {
                if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword())){
                    found=true;
                }

                throw new loginFailed(username);
            }
         }  if(found==false) throw new loginFailed;if(found==true) return true;
}

public static boolean  searchUserAdmin(String username, String password) throws loginFailed {
        boolean found=false;
        for (User user : userRepository.find()) {
            //System.out.println
            if(user.getRole().equals("Admin");
            {
                if (Objects.equals(username, user.getUsername()) && Objects.equals(password, user.getPassword())){
                    found=true;
                }

                throw new loginFailed(username);
            }
        }  if(found==false) throw new loginFailed;if(found==true) return true;
    }