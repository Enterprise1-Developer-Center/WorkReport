package kr.co.e1.workreport.framework.utils;

import java.util.HashMap;

/**
 * Created by jaeho on 2018. 1. 23
 */

public class DefaultHashMap<K,V> extends HashMap<K,V> {
  protected V defaultValue;
  public DefaultHashMap(V defaultValue) {
    this.defaultValue = defaultValue;
  }
  @Override
  public V get(Object k) {
    return containsKey(k) ? super.get(k) : defaultValue;
  }
}