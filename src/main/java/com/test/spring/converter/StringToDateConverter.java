package com.test.spring.converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 15:41
 * @Version 1.0
 * @Description spring的另外类型转换器，converter
 */
public class StringToDateConverter implements org.springframework.core.convert.converter.Converter<String,Date> {
    @Override
    public Date convert(String s) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }
}
