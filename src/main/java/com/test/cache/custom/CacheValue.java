package com.test.cache.custom;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description 缓存实体类
 *
 * @author playboy
 * @date 2020-05-18 10:16
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheValue implements Comparable<CacheValue> {
    /**
     * 键
     */
    private Object key;
    /**
     * 值
     */
    private Object value;
    /**
     * 过期时间
     */
    private Long expireTime;
    /**
     * 创建时间
     */
    private Long createTime;
    /**
     * 最后访问时间
     */
    private long lastTime;
    /**
     * 命中次数
     */
    private Integer hitCount;


    @Override
    public int compareTo(CacheValue o) {
        return this.hitCount.compareTo(o.getHitCount());
    }

}
