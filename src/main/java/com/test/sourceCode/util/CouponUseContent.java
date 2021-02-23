package com.test.sourceCode.util;


import java.io.Serializable;

import lombok.Data;

import static com.test.sourceCode.util.TestCouponContent.COUPON_USE;

/**
 * @Description: 优惠券使用说明对象
 * @Author:
 * @Date: 2019-11-27 11:28
 * @Version: 1.0
 */
@Data
public class CouponUseContent implements Serializable {
    /**
     * 使用说明标题
     */
    private String useTitle;
    /**
     * 使用说明描述
     */
    private String useDesc;

    public CouponUseContent(String content) {
        String[] contents = content.split(COUPON_USE);
        this.useTitle = contents[0];
        if (contents.length > 1) {
            this.useDesc = contents[1].replaceAll("[\n\r]+$", "");
        }
    }

    @Override
    public String toString() {
        return "CouponUseContent{" +
                "useTitle='" + useTitle + '\'' +
                ", useDesc='" + useDesc + '\'' +
                '}';
    }

}
