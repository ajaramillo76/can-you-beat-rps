package edu.cnm.deepdive.canyoubeatrps.service;

import android.app.Application;

public class GameRepository {

  private final CanYouBeatRpsDatabase database;

  private static Application context;

  private GameRepository() {
    if (context == null) {
      throw new IllegalStateException();
    }
    database = CanYouBeatRpsDatabase.getInstance();
  }

  public CanYouBeatRpsDatabase getDatabase() {
    return database;
  }

  public static Application getContext() {
    return context;
  }

  public static void setContext(Application context) {
    GameRepository.context = context;
  }

  private static class InstanceHolder {

    private static final GameRepository INSTANCE = new GameRepository();
  }

}
