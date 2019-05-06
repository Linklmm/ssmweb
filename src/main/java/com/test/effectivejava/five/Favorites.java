package com.test.effectivejava.five;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author
 * @Date 2019-05-06 08:51
 * @Version 1.0
 * @Description 优先考虑类型安全的异构容器
 */
public class Favorites {
    private Map<Class<?>,Object> favorites = new HashMap<>();

    public <T> void putFavorites(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type),instance);
    }

    public <T> T getFavorites(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorites(String.class,"java");
        f.putFavorites(Integer.class,0xcafebabe);
        f.putFavorites(Class.class,Favorites.class);
        String favoritesString = f.getFavorites(String.class);
        Integer favoriteInteger = f.getFavorites(Integer.class);
        Class<?> favoriteClass = f.getFavorites(Class.class);
        System.out.printf("%s %x %s%n",favoritesString,
                favoriteInteger,favoriteClass);
    }
}
