package com.practice.lld.proxy;

public interface UserService {
    void getUser(User caller, User target);
    void deleteUser(User caller, User target);
}
