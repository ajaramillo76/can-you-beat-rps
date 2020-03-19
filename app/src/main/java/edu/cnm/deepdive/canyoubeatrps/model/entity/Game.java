package edu.cnm.deepdive.canyoubeatrps.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import java.util.Date;

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

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @NonNull
  @ColumnInfo
  private Outcome outcome;

  @NonNull
  @ColumnInfo
  private Choice player;

  @NonNull
  @ColumnInfo
  private Choice computer;

  @NonNull
  private Date timestamp = new Date();

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

  @NonNull
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(@NonNull Date timestamp) {
    this.timestamp = timestamp;
  }

  @NonNull
  public Outcome getOutcome() {
    return outcome;
  }

  public void setOutcome(@NonNull Outcome outcome) {
    this.outcome = outcome;
  }

  @NonNull
  public Choice getPlayer() {
    return player;
  }

  public void setPlayer(@NonNull Choice player) {
    this.player = player;
  }

  @NonNull
  public Choice getComputer() {
    return computer;
  }

  public void setComputer(@NonNull Choice computer) {
    this.computer = computer;
  }

  public enum Outcome {
    WIN, LOSE, DRAW;

    @TypeConverter
    public static Integer toInteger(Outcome value) {
      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static Outcome fromInteger(Integer value) {
      return (value != null) ? Outcome.values()[value] : null;
    }
  }

  public enum Choice {
    ROCK, PAPER, SCISSORS;

    @TypeConverter
    public static Integer fromChoice(Choice choice) {
      return (choice != null) ? choice.ordinal() : null;
    }

    @TypeConverter
    public static Choice fromInteger(Integer value) {
      return (value != null) ? Choice.values()[value] : null;
    }
  }

}
