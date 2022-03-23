package pers.hubery.accountcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pers.hubery.accountcenter"})
public class AccountcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountcenterApplication.class, args);
    }

}
