package pers.hubery.accountcenter.test


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.hubery.accountcenter.facade.AccountQueryFacade;
import spock.lang.Specification;
import spock.lang.Unroll;

/**
 * @author hubery
 * @version GetAccountInfoTest.java v1.0 2022-03-28 00:15
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes =[AccountcenterApplication])
public class GetAccountInfoTest extends Specification {

    @Autowired
    AccountQueryFacade accountQueryFacade;

    @Unroll
    def getAccountInfo(){

        when:
        def request = new AccountQueryRequest

        where: "测试场景"
        caseDesc | tenantId|accountBook|shardingIndex|accountNo| isSuccess
        "正常用例"|"00000000"|"DEPOSIT"|"00"|"00000000000000000000000000000000"|true
    }
}
