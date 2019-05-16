package com.test.effectivejava.six;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: linklmm
 * @Date: 2019/5/14 10:41* @Description 表示一个双字母组或者有序的字母对
 */
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }
    //没能将equals方法覆盖，而是将它重载，为了覆盖Object.equals方法
    //必须定义一个参数为Object类型的equals方法
//    @Override
    //public boolean equals(Object b)
    public boolean equals(Bigram b){
        return b.first == first&&b.second ==second;
    }
    @Override
    public int hashCode(){
        return 31*first+second;
    }

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i=0;i<10;i++){
            for (char ch = 'a';ch <= 'z';ch++){
                s.add(new Bigram(ch,ch));
            }
        }
        System.out.println(s.size());
    }
}
