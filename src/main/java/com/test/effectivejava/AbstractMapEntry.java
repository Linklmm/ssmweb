package com.test.effectivejava;

import java.util.Map;
import java.util.Objects;

/**
 * @Auther: linklmm
 * @Date: 2019/4/15 11:11
 * @Description 已Map.Entry接口为例，所有实现都放在骨架实现类中
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }

        Map.Entry<?, ?> e = (Map.Entry<?, ?>) obj;
        return Objects.equals(e.getKey(), getKey()) &&
                Objects.equals(e.getValue(), getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getKey())
                ^ Objects.hashCode(getValue());
    }

    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
