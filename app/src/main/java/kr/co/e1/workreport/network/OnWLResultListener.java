package kr.co.e1.workreport.network;

/**
 * Created by jaeho on 2017. 11. 7
 */

public interface OnWLResultListener<T extends WResult> {
  void onPre();

  void onResultSuccess(T result);

  void onResultFailure(T result);

  void onServerError(String msg);

  void onPost();
}
