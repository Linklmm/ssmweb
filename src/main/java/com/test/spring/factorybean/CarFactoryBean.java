package com.test.spring.factorybean;

import com.test.spring.factorybean.pojo.Car;
import org.springframework.beans.factory.FactoryBean;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-04 15:23
 * @Version 1.0
 * @Description factorybean的实现 ，用户可以通过实现该接口定制实例化bean的逻辑
 */
public class CarFactoryBean implements FactoryBean {
    private String carInfo;

    @Override
    public Object getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }
}
