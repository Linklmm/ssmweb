package com.test.effectivejava;

/**
 * 版权声明：Copyright(c) 2019
 *
 * @program: ssmweb
 * @Author minmin.liu
 * @Date 2019-03-15 16:03
 * @Version 1.0
 * @Description javaBean模式
 */
public class NutritionFactsToBuilder {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        private final int servingSize;
        private final int servings;
//参数默认值
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val)
        { calories =val;return this;}
        public Builder fat(int val) {
            fat=val;
            return this;
        }
        public Builder sodium(int val){
            sodium =val;
            return this;
        }
        public Builder carbohydrate(int val){
            carbohydrate =val;
            return this;
        }

        public NutritionFactsToBuilder build(){
            return new NutritionFactsToBuilder(this);
        }
    }

    @Override
    public String toString() {
        return "servingSize:"+servingSize+" servings: "+servings
                +" calories:"+calories+" fat:"+fat+
                " sodium:"+sodium+" carbohydrate:"+carbohydrate;
    }

    private NutritionFactsToBuilder(Builder builder){
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFactsToBuilder cocaCola = new Builder(240,8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);
    }
}
