package edu.cnm.deepdive.canyoubeatrps.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.canyoubeatrps.model.dao.GameDao;
import edu.cnm.deepdive.canyoubeatrps.model.dao.UserDao;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.entity.User;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsDatabase.DateConverters;
import java.util.Date;

@Database(
    entities = {User.class, Game.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Game.Outcome.class, Game.Choice.class, DateConverters.class})
public abstract class CanYouBeatRpsDatabase extends RoomDatabase {

  private static final String DB_NAME = "canYouBeatRps_db";

  private static Application context;

  public static void setContext(Application context) {CanYouBeatRpsDatabase.context = context; }

  public static CanYouBeatRpsDatabase getInstance() {return InstanceHolder.INSTANCE;}

  public abstract UserDao getUserDao();

  public abstract GameDao getGameDao();

  private static class InstanceHolder {

    private static final CanYouBeatRpsDatabase INSTANCE = Room.databaseBuilder(
        context, CanYouBeatRpsDatabase.class, DB_NAME).build();
  }

  public static class DateConverters {
    @TypeConverter
    public static Long fromDate(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date fromInteger(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }

}
