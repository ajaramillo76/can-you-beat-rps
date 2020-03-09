package edu.cnm.deepdive.canyoubeatrps.model.repository;

import android.app.Application;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsDatabase;

public class HistoricalDataRepository {

  private final CanYouBeatRpsDatabase database;

  private static Application context;

  private HistoricalDataRepository() {
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
    HistoricalDataRepository.context = context;
  }


  private static class InstanceHolder {

    private static final HistoricalDataRepository INSTANCE = new HistoricalDataRepository();

  }
}

