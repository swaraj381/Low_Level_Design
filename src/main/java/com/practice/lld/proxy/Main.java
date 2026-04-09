package com.practice.lld.proxy;

public class Main {
    public static void main(String[] args) {
        User admin = new User("Alice", Role.ADMIN);
        User user = new User("Bob", Role.USER);
        User targetUser = new User("John", Role.USER);

        UserService realService = new UserServiceImpl();

        UserService proxy = new UserServiceProxy(realService);

        proxy.getUser(admin, targetUser);
        proxy.deleteUser(admin, targetUser);

        proxy.getUser(user, targetUser);
        proxy.getUser(user, targetUser);
    }
}
