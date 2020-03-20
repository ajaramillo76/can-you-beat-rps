package edu.cnm.deepdive.canyoubeatrps.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice;
import edu.cnm.deepdive.canyoubeatrps.model.entity.User;

public class UserSummary {


  private long id;
 @Relation(entity = User.class, parentColumn = "id", entityColumn = "user_id")
  private User user;
  private Choice choice;
  private int wins;
  private int losses;
  private int draws;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Choice getChoice() {
    return choice;
  }

  public void setChoice(Choice choice) {
    this.choice = choice;
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
}
