package com.test.data.list;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-02 20:16
 * @description: list性能对比
 **/
@Slf4j
public class TestList {

  private static List<Integer> iteratorLinkedList = new LinkedList();
  private int xx = 0;

  /**
   * arrayList和LinkedList头插性能比较
   */
  @Test
  public void testArraysComputeLinked() {
    ArrayList<Integer> list = new ArrayList<>();
    Instant start = Instant.now();
    int num1 = 100000;
    for (int i = 0; i < num1; i++) {
      list.add(0, i);
    }
    log.error("10w arraylist add first time:{}",
        Instant.now().getNano() - start.getNano());

    LinkedList<Integer> linkedList = new LinkedList<>();
    Instant linkedStart = Instant.now();
    for (int i = 0; i < num1; i++) {
      linkedList.addFirst(i);
    }
    log.error("10w LinkedList add first time:{}",
        Instant.now().getNano() - linkedStart.getNano());

    ArrayList<Integer> list2 = new ArrayList<>();
    Instant start2 = Instant.now();
    int num2 = 1000000;
    for (int i = 0; i < num2; i++) {
      list2.add(0, i);
    }
    log.error("100w arraylist add first time:{}",
        Instant.now().getNano() - start2.getNano());

    LinkedList<Integer> linkedList2 = new LinkedList<>();
    Instant linkedStart2 = Instant.now();
    for (int i = 0; i < num2; i++) {
      linkedList2.addFirst(i);
    }
    log.error("10w LinkedList add first time:{}",
        Instant.now().getNano() - linkedStart2.getNano());
  }

  //5种遍历

  @BeforeAll
  public static void init() {
    for (int i = 0; i < 1000000; i++) {
      iteratorLinkedList.add(i);
    }
  }

  @Test
  public void test_LinkedList_for0() {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < iteratorLinkedList.size(); i++) {
      xx += iteratorLinkedList.get(i);
    }
    log.error("for 耗时：{}", System.currentTimeMillis() - startTime);

    long startTime2 = System.currentTimeMillis();
    for (Integer itr : iteratorLinkedList) {
      xx += itr;
    }
    log.error("增强for 耗时：{}", System.currentTimeMillis() - startTime2);

    long startTime3 = System.currentTimeMillis();
    Iterator<Integer> iterator = iteratorLinkedList.iterator();
    while (iterator.hasNext()) {
      Integer next = iterator.next();
      xx += next;
    }
    log.error("iterator 耗时：{}", System.currentTimeMillis() - startTime3);

    long startTime4 = System.currentTimeMillis();
    iteratorLinkedList.forEach(integer -> {
      xx += integer;
    });
    log.error("forEach 耗时：{}", System.currentTimeMillis() - startTime4);

    long startTime5 = System.currentTimeMillis();
    iteratorLinkedList.stream().forEach(integer -> {
      xx += integer;
    });
    log.error("stream 耗时：{}", System.currentTimeMillis() - startTime5);
  }

}
