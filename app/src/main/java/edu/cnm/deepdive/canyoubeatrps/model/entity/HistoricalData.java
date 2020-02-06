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
public class HistoricalData {

  @ColumnInfo(name = "historical_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "wins", index = true)
  private boolean wins;

  @ColumnInfo(name = "losses", index = true)
  private boolean losses;

  @ColumnInfo(name = "draw", index = true)
  private boolean draw;

  @ColumnInfo(name = "rock", index = true)
  private int rock;

  @ColumnInfo(name = "paper", index = true)
  private int paper;

  @ColumnInfo(name = "scissors", index = true)
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

  public boolean isWins() {
    return wins;
  }

  public void setWins(boolean wins) {
    this.wins = wins;
  }

  public boolean isLosses() {
    return losses;
  }

  public void setLosses(boolean losses) {
    this.losses = losses;
  }

  public boolean isDraw() {
    return draw;
  }

  public void setDraw(boolean draw) {
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
