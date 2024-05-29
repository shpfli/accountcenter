package pers.hubery.accountcenter.core.generator.impl;

import org.springframework.stereotype.Component;
import pers.hubery.accountcenter.core.generator.IdGenerator;

@Component
public class IdGeneratorImpl implements IdGenerator {

    /**
     * 生成账务流水ID
     *
     * @return 账务流水ID
     */
    @Override
    public String genAccountingLogId() {
        //TODO
        return "00000000";
    }
}
