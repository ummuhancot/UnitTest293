package tdd;

/*
        ***********************************
               Banka Hesap Uygulamasi
        ***********************************
        Uygulamada yazilacak metodlar(işlevleri):
            *   Hesap Olusturma
            *   Para Cekme ( Bakiye yetersiz kontrolu, Gunluk Cekim Limiti Kontrolu, Negatif Giris kontrolu )
            *   Para Yatirma ( Negatif Giris kontrolu )
            *   Hesap Gecmisi Alabilme kontrolu
 */

import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;
    private double balance;
    private double dailyWithdrawLimit;
    private double dailyWithdrawnAmount;
    private List<String> history=new ArrayList<>();

    public BankAccount(String accountNumber, double balance, double dailyWithdrawLimit) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    public void setDailyWithdrawLimit(double dailyWithdrawLimit) {
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    public double getDailyWithdrawnAmount() {
        return dailyWithdrawnAmount;
    }

    public void setDailyWithdrawnAmount(double dailyWithdrawnAmount) {
        this.dailyWithdrawnAmount = dailyWithdrawnAmount;
    }

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    //işlevsel metodlar --> bu methodların testlerini oluşturyoruz
    //para çekme
    public Boolean withdraw(double amount){

        //4 dumu kontrol etmişiz
        if (amount>0 &&
                amount<=this.balance &&
                this.dailyWithdrawnAmount<this.dailyWithdrawLimit){// 1- Miktar pozitif olmalı, 2- Bakiye yeterli olmalı, 3- Günlük çekim limiti aşılmamalı
            this.balance -= amount;// Bakiyeden çekilen miktarı düş
            this.history.add("Para çekme : " + amount);// İşlem geçmişine para çekme işlemini ekle
            this.dailyWithdrawnAmount += amount;// Günlük çekilen miktara ekle
            return true;
        }  else if (amount<=0){ // Miktar pozitif değilse hata fırlat
            throw new RuntimeException("Miktar pozitif olmalıdır.");
        } else {
            return false;
        }

    }


    //para yatırma
    public Boolean deposit(double amount){
        if (amount>0){
            this.balance+=amount;
            this.history.add("Para yatırma : "+amount);
            return true;
        }else {
            throw new RuntimeException("Miktar pozitif olmalı!");
        }
    }



}
