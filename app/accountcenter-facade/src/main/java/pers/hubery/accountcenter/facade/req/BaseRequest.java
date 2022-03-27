package pers.hubery.accountcenter.facade.req;

import java.io.Serializable;

/**
 * 请求基类
 *
 * @author hubery
 * @version BaseRequest.java v1.0 2022-03-27 21:25
 */
public abstract class BaseRequest implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8918407329251880203L;

    /** 请求唯一标识，幂等键 */
    private String requestUniqueId;

    /** 租户ID */
    private String tenantId;

    /**
     * Getter method for property <tt>requestUniqueId</tt>.
     *
     * @return property value of requestUniqueId
     */
    public String getRequestUniqueId() {
        return requestUniqueId;
    }

    /**
     * Setter method for property <tt>requestUniqueId</tt>.
     *
     * @param requestUniqueId value to be assigned to property requestUniqueId
     */
    public void setRequestUniqueId(final String requestUniqueId) {
        this.requestUniqueId = requestUniqueId;
    }

    /**
     * Getter method for property <tt>tenantId</tt>.
     *
     * @return property value of tenantId
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * Setter method for property <tt>tenantId</tt>.
     *
     * @param tenantId value to be assigned to property tenantId
     */
    public void setTenantId(final String tenantId) {
        this.tenantId = tenantId;
    }
}
