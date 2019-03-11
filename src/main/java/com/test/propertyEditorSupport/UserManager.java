package com.test.propertyEditorSupport;

import java.util.Date;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-11 09:42
 * @Version 1.0
 * @Description
 */
public class UserManager {
    private Date dateValue;

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }

    @Override
    public String toString() {
        return "dateValue:"+dateValue;
    }
}
