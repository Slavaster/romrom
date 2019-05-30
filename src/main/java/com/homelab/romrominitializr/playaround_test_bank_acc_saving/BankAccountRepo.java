package com.homelab.romrominitializr.playaround_test_bank_acc_saving;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepo extends JpaRepository<BankAccount,Integer> {
}
