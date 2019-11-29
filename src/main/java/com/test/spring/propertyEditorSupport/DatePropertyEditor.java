package com.test.spring.propertyEditorSupport;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-11 14:21
 * @Version 1.0
 * @Description 使用自定义属性编辑器
 */
public class DatePropertyEditor extends PropertyEditorSupport {
    private String format= "yyyy-MM-dd";

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("text:"+text);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d = sdf.parse(text);
            this.setValue(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
