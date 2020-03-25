package edu.cnm.deepdive.canyoubeatrps.model.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.canyoubeatrps.model.dao.GameDao;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.pojo.UserSummary;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsDatabase;
import java.util.Date;
import java.util.List;

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

  public static GameRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public LiveData<List<UserSummary>> get() {
    return database.getGameDao().selectAllSummaries();
  }
  private static class InstanceHolder {

    private static final GameRepository INSTANCE = new GameRepository();
  }

}
