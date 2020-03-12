package edu.cnm.deepdive.canyoubeatrps.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import edu.cnm.deepdive.canyoubeatrps.model.dao.GameDao;
import edu.cnm.deepdive.canyoubeatrps.model.dao.HistoricalDataDao;
import edu.cnm.deepdive.canyoubeatrps.model.dao.UserDao;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.entity.HistoricalData;
import edu.cnm.deepdive.canyoubeatrps.model.entity.User;

@Database(
    entities = {User.class, Game.class, HistoricalData.class},
    version = 1,
    exportSchema = true
)
public abstract class CanYouBeatRpsDatabase extends RoomDatabase {

  private static final String DB_NAME = "canYouBeatRps_db";

  private static Application context;

  public static void setContext(Application context) {CanYouBeatRpsDatabase.context = context; }

  public static CanYouBeatRpsDatabase getInstance() {return InstanceHolder.INSTANCE;}

  public abstract UserDao getUserDao();

  public abstract GameDao getGameDao();

  public abstract HistoricalDataDao HistoricalDataDao();

  private static class InstanceHolder {

    private static final CanYouBeatRpsDatabase INSTANCE = Room.databaseBuilder(
        context, CanYouBeatRpsDatabase.class, DB_NAME).build();
  }

}
