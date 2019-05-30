package com.homelab.romrominitializr.playaround_test_bank_acc_saving;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
    @Id
    private long id;
    @Column(name="ACC_NUMBER")
    private long accNumber;
    @Column(name="HOLDER")
    private String nameHolder;

    public BankAccount() {
        super();
    }

    public BankAccount(long accNumber, String nameHolder) {
        this.accNumber = accNumber;
        this.nameHolder = nameHolder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }

    public String getNameHolder() {
        return nameHolder;
    }

    public void setNameHolder(String nameHolder) {
        this.nameHolder = nameHolder;
    }
}

