package org.example.forkliftaccountsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaAuditing
public class ForkliftAccountSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForkliftAccountSystemApplication.class, args);
    }

}
