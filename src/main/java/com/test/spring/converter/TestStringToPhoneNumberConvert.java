package com.test.spring.converter;

import org.springframework.core.convert.support.DefaultConversionService;

import java.util.Date;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-13 15:52
 * @Version 1.0
 * @Description 自定义类型转换器
 */
public class TestStringToPhoneNumberConvert {
    public static void main(String[] args) {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToDateConverter());

        String phoneNumberStr = "2018-02-03";
        StringToDateConverter stringToDateConverter = new StringToDateConverter();
        Date d = stringToDateConverter.convert(phoneNumberStr);
        System.out.println(d);
    }
}
