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

  @ColumnInfo(name = "historicaldata_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @ColumnInfo(name = "wins", index = true)
  private int wins;

  @ColumnInfo(name = "losses", index = true)
  private int losses;

  @ColumnInfo(name = "draws", index = true)
  private int draws;

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

  public int getWins() {
    return wins;
  }

  public void setWins(int wins) {
    this.wins = wins;
  }

  public int getLosses() {
    return losses;
  }

  public void setLosses(int losses) {
    this.losses = losses;
  }

  public int getDraws() {
    return draws;
  }

  public void setDraws(int draws) {
    this.draws = draws;
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
