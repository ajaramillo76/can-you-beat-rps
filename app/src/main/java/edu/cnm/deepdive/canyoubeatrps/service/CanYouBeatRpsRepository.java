package edu.cnm.deepdive.canyoubeatrps.service;

import android.app.Application;

public class CanYouBeatRpsRepository {

  private final CanYouBeatRpsDatabase database;

  private static Application context;

  private CanYouBeatRpsRepository () {
    if (context == null) {
      throw new IllegalStateException();
    }
    database = CanYouBeatRpsDatabase.getInstance();
  }

  public static void setContext(Application context) { CanYouBeatRpsRepository.context = context; }

  public static CanYouBeatRpsRepository getInstance() { return InstanceHolder.INSTANCE; }

  private static class InstanceHolder {

    private static final CanYouBeatRpsRepository INSTANCE = new CanYouBeatRpsRepository();
  }

}
