package com.test.effectivejava.eight;

/**
 * @Auther: linklmm
 * @Date: 2019/6/11 08:43
 * * @Description 慎用可变参数
 */
public class VariableArityMethod {
    static int sum(int... args){
        int sum =0;
        for (int arg:args){
            sum+=arg;
        }
        return sum;
    }
    static int main(int... args){
        if (args.length == 0){
            throw new IllegalArgumentException("Too few arguments");
        }
        int min =args[0];
        for (int i=1;i<args.length;i++){
            if (args[i]<min){
                min = args[i];
            }
        }
        return min;
    }
    static int min(int firstArg,int... remainingArgs){
        int min = firstArg;
        for (int arg:remainingArgs){
            if (arg<min)
                min =arg;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(sum(1,2,3));
    }
}
