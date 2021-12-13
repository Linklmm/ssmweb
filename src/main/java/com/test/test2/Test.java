package com.test.test2;

import com.alibaba.fastjson.JSON;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2021-07-20 15:33
 * @description:
 * 5 10
 * ..*.....**
 * .**..*****
 * .*...*....
 * ..****.***
 * ..****.***
 **/
public class Test {

  /**
   * 0代表. 1 代表*
   *
   * @param params
   * @return
   */
  public static int[] sort(int[] params){
    for(int i = 0;i<params.length;i++){
      for (int j=i+1;j<params.length;j++){
        if (params[i]>params[j]){
          int temp = params[i];
          params[i] = params[j];
          params[j] = temp;
        }
      }
    }
    return params;
  }

  public static void main(String[] args) {
    int[] nums = {3,1,5,7,8,4,6};
    System.out.println(JSON.toJSONString(sort(nums)));
  }

}
