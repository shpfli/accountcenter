package pers.hubery.accountcenter;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hubery
 */
@MapperScans({
        @MapperScan(basePackages = "pers.hubery.accountcenter.infra.dal.mapper", sqlSessionFactoryRef = "accountcenterSqlSessionFactory")
})
@SpringBootApplication(scanBasePackages = {"pers.hubery.accountcenter"})
public class AccountcenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountcenterApplication.class, args);
    }

}
