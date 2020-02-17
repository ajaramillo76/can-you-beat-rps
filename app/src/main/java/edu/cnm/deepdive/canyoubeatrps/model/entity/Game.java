package edu.cnm.deepdive.canyoubeatrps.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Game {

  @ColumnInfo(name = "game_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(index = true)
  private int win;

  @ColumnInfo(index = true)
  private int lose;

  @ColumnInfo(index = true)
  private int draw;

  @ColumnInfo(index = true)
  private int rock;

  @ColumnInfo(index = true)
  private int paper;

  @ColumnInfo(index = true)
  private int scissors;

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

  public int getWin() {
    return win;
  }

  public void setWin(int win) {
    this.win = win;
  }

  public int getLose() {
    return lose;
  }

  public void setLose(int lose) {
    this.lose = lose;
  }

  public int getDraw() {
    return draw;
  }

  public void setDraw(int draw) {
    this.draw = draw;
  }

  public int getRock() {
    return rock;
  }

  public void setRock(int rock) {
    this.rock = rock;
  }

  public int getPaper() {
    return paper;
  }

  public void setPaper(int paper) {
    this.paper = paper;
  }

  public int getScissors() {
    return scissors;
  }

  public void setScissors(int scissors) {
    this.scissors = scissors;
  }
}
