package edu.cnm.deepdive.canyoubeatrps.controller;


import static edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice.PAPER;
import static edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice.ROCK;
import static edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice.SCISSORS;

import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Outcome;
import java.util.Random;

public class GameFragment extends Fragment {

  public static Outcome getOutcome(Choice player, Choice computer) {

    switch (player){
      case ROCK:
        switch (computer){
        case SCISSORS:
          return Outcome.WIN;
        case PAPER:
          return Outcome.LOSE;
      }
      break;
      case SCISSORS:
        switch (computer){
          case PAPER:
            return Outcome.WIN;
          case ROCK:
            return Outcome.LOSE;
        }
        break;
      case PAPER:
        switch (computer){
          case SCISSORS:
            return Outcome.LOSE;
          case ROCK:
            return Outcome.WIN;
        }
        break;
    }
    return Outcome.DRAW;
  }

  private static Random randomer = new Random();
  public static Choice random() {
    Choice[] values = Choice.values();
    return values[randomer.nextInt(values.length)];
  }
}
