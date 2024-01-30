package org.example.Servise.ServiseImpl;

import org.example.Servise.EmailServise;
import org.example.Servise.UserServise;
import org.example.domain.User;

import java.util.ResourceBundle;


public class UserServiseImpl implements UserServise {
    @Override
    public User login(String username, String password) {
        User user = USER_LIST.stream()
                .filter(user1 -> user1.getPassword().equals(password) && user1.getUsername().equals(username))
                .findFirst().orElse(null);
        if (user != null) {
            System.out.println("Succesfuly !!!");
        } else {
            System.out.println("No such enter");
        }
        return user;
    }

    @Override
    public void register(String username, String password, String email) {
        EmailServise emailServise = new EmailServiseImpl();
        User user = USER_LIST.stream()
                .filter(user1 -> user1.getPassword().equals(password) && user1.getUsername().equals(username))
                .findFirst().orElse(null);
        if ((user == null) && emailServise.Email("begmatovsamandar9@gmail", email, "oxra xndh wcci xxvw")) {
            user = user.builder()
                    .username(username)
                    .password(password)
                    .email(email)
                    .build();
            USER_LIST.add(user);
        }
        else{
            System.out.println("Already exist");
        }


    }

    @Override
    public void setPassword(String username, String newPassword) {
        final ResourceBundle resourceBundle=ResourceBundle.getBundle("email");
        EmailServise emailServise=new EmailServiseImpl();
        if (emailServise.Email("begmatovsamandar9@gmail.com","begmatovsamandar34@gmail.com" ,"oxra xndh wcci xxvw"));
    }
}
