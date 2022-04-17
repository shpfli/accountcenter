package pers.hubery.accountcenter.core.generator;

/**
 * IDGenerator
 *
 * @author Hubery
 * @version IdGenerator.java v1.0 2022-04-18 00:14
 */
public interface IdGenerator {
    /**
     * 生成账务流水ID
     *
     * @return 账务流水ID
     */
    String genAccountingLogId();
}
