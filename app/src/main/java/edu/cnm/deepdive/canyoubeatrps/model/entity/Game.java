package edu.cnm.deepdive.canyoubeatrps.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
)
public class Game {

  @ColumnInfo(name = "game_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(index = true)
  private long userId;

  @ColumnInfo(index = true)
  private boolean win;

  @ColumnInfo(index = true)
  private boolean lose;

  @ColumnInfo(index = true)
  private boolean draw;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public boolean isWin() {
    return win;
  }

  public void setWin(boolean win) {
    this.win = win;
  }

  public boolean isLose() {
    return lose;
  }

  public void setLose(boolean lose) {
    this.lose = lose;
  }

  public boolean isDraw() {
    return draw;
  }

  public void setDraw(boolean draw) {
    this.draw = draw;
  }

}
