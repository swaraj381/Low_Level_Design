package com.practice.lld.proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void getUser(User caller, User target){
        System.out.println(caller.getName() + " fetched user details for: " + target.getName());
    }

    @Override
    public  void deleteUser(User caller, User target){
        System.out.println(caller.getName() + " deleted user: " + target.getName());
    }
}
