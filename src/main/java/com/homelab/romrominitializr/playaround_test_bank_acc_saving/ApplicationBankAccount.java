package com.homelab.romrominitializr.playaround_test_bank_acc_saving;

import com.homelab.romrominitializr.RomrominitializrApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationBankAccount {
    public static void main(String[] args) {
        SpringApplication.run(RomrominitializrApplication.class, args);
    }

    @Bean
    public boolean saveBankAcc(BankAccountRepo bankAccountRepo){
        bankAccountRepo.save(new BankAccount(938475615243948L, "Oleg Mongol"));
        return true;
    }

}
