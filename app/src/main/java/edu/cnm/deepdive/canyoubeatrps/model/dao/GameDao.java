package edu.cnm.deepdive.canyoubeatrps.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.canyoubeatrps.model.pojo.UserSummary;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface GameDao {

  String SUMMARY_QUERY = "SELECT\n"
      + "    user_id AS id,\n"
      + "    player AS choice,\n"
      + "    SUM(CASE outcome WHEN 0 THEN 1 ELSE 0 END) AS wins,\n"
      + "    SUM(CASE outcome WHEN 1 THEN 1 ELSE 0 END) AS losses,\n"
      + "    SUM(CASE outcome WHEN 2 THEN 1 ELSE 0 END) AS draws\n"
      + "FROM\n"
      + "    Game\n"
      + "GROUP BY\n"
      + "    user_id,\n"
      + "    player\n"
      + "ORDER BY\n"
      + "    user_id,\n"
      + "    player";

  String ONE_SUMMARY_QUERY = "SELECT\n"
      + "    user_id AS id,\n"
      + "    player AS choice,\n"
      + "    SUM(CASE outcome WHEN 0 THEN 1 ELSE 0 END) AS wins,\n"
      + "    SUM(CASE outcome WHEN 1 THEN 1 ELSE 0 END) AS losses,\n"
      + "    SUM(CASE outcome WHEN 2 THEN 1 ELSE 0 END) AS draws\n"
      + "FROM\n"
      + "    Game\n"
      + "WHERE\n"
      + "    user_id = :userId\n"
      + "GROUP BY\n"
      + "    user_id,\n"
      + "    player\n"
      + "ORDER BY\n"
      + "    user_id,\n"
      + "    player";

  @Insert
  Single<Long>  insert(Game game);

  @Insert
  Single<List<Long>> insert(Collection<Game> games);

  @Update
  Single<Integer> update(Game... game);

  @Delete
  Single<Integer> delete(Game... games);

  @Query("SELECT * FROM Game WHERE user_id = :userId ORDER BY game_id")
  LiveData<List<Game>> select(long userId);

  @Transaction
  @Query(SUMMARY_QUERY)
  LiveData<List<UserSummary>> selectAllSummaries();

  @Transaction
  @Query(ONE_SUMMARY_QUERY)
  LiveData<List<UserSummary>> selectOneSummary(long userId);


}
