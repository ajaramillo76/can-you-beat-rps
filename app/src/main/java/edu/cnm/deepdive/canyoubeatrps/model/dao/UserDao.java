package edu.cnm.deepdive.canyoubeatrps.model.dao;

import android.provider.ContactsContract.CommonDataKinds.Email;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.canyoubeatrps.model.entity.User;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);

  @Insert
  Single<List<Long>> insert(Collection<User> users);

  @Update
  Single<Integer> update(User... users);

  @Delete
  Single<Integer> delete(User... users);

  @Query("SELECT * FROM User ORDER BY user_id")
  LiveData<List<User>> select();

  @Query("SELECT * FROM User WHERE email_id = :email")
  Maybe<User> select(String email);

}
