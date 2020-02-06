package edu.cnm.deepdive.canyoubeatrps.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.canyoubeatrps.model.entity.HistoricalData;
import java.util.Collection;
import java.util.List;

@Dao
public interface HistoricalDataDao {

  @Insert
  long insert(HistoricalData historicalData);

  @Insert
  List<Long> insert(Collection<HistoricalData> historicalDatas);

  @Update
  int update(HistoricalData historicalData);

  @Delete
  int delete(HistoricalData... historicalDatas);

  @Query("SELECT * FROM HistoricalData ORDER BY historicaldata_id")
  List<HistoricalData> select();

}
