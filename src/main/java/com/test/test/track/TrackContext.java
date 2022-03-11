package com.test.test.track;

/**
 * @program: ssmweb
 * @author: playboy
 * @create: 2022-03-11 22:57
 * @description: 链路追踪上下文
 **/
public class TrackContext {

  private static final ThreadLocal<String> trackLocal = new ThreadLocal<>();

  public static void clear() {
    trackLocal.remove();
  }

  public static String getLinkId() {
    return trackLocal.get();
  }

  public static void setLinkId(String linkId) {
    trackLocal.set(linkId);
  }

}
