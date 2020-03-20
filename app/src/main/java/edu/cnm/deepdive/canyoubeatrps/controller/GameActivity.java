package edu.cnm.deepdive.canyoubeatrps.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Outcome;

public class GameActivity extends AppCompatActivity {

  TextView playerTextView;
  TextView androidTextView;
  TextView textResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
    playerTextView = findViewById(R.id.text_player_choice);
    androidTextView = findViewById(R.id.text_android_choice);
    textResult = findViewById(R.id.text_result);
  }

  public void onMakeButtonChoice(View view) {
    switch (view.getId()) {
      case R.id.rock_button:
        play(Choice.ROCK);
        break;
      case R.id.paper_button:
        play(Choice.PAPER);
        break;
      case R.id.scissors_button:
        play(Choice.SCISSORS);
        break;
    }
  }

  private void play(Choice player) {
    playerTextView.setText("Player's choice: " + player.toString().toLowerCase());

    Choice[] computer = Choice.values();
    androidTextView.setText("Computer's choice: " + computer.toString().toLowerCase());

//    Outcome outcome = Game.getComputer(player, computer);
//    textResult.setText("Player " + ());
//  }
  }
}
