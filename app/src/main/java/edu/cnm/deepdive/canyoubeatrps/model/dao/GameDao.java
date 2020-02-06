package edu.cnm.deepdive.canyoubeatrps.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface GameDao {

  @Insert
  long  insert(Game game);

  @Insert
  Single<List<Long>> insert(Collection<Game> games);

  @Update
  int update(Game game);

  @Delete
  int delete(Game games);

  @Query("SELECT * FROM Game ORDER BY game_id")
  LiveData<List<Game>> select();



}
