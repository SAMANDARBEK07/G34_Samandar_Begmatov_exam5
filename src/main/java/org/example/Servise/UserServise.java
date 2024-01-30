package org.example.Servise;

import org.example.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface UserServise {

    List<User>USER_LIST=new ArrayList<>();
    User login(String username, String password);
    void register(String username,String password,String email);
    void setPassword(String username,String newPassword);
}
