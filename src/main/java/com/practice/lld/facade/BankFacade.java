package com.practice.lld.facade;

public class BankFacade {
    private Account account;
    private Security security;
    private Funds funds;
    private Notification notification;

    public BankFacade() {
        account = new Account();
        security = new Security();
        funds = new Funds();
        notification = new Notification();
    }

    public void withdraw(String accNo, String pin, double amount) {
        System.out.println("Starting Withdrawal Process...");
        if (account.verifyAccount(accNo) && security.checkPin(pin) && funds.hasSufficientFunds(amount)) {
            funds.debit(amount);
            notification.sendNotification("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Withdrawal Failed!");
        }
    }
}
