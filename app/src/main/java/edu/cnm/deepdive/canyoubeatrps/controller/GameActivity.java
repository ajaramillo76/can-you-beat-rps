package edu.cnm.deepdive.canyoubeatrps.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;

public class GameActivity extends AppCompatActivity {

  private TextView message;
  private TextView win_rate;
  private TextView loss;
  private TextView player_action_5;
  private TextView player_action_4;
  private TextView player_action_3;
  private TextView player_action_2;
  private TextView player_action_1;
  private TextView robot_action_5;
  private TextView robot_action_4;
  private TextView robot_action_3;
  private TextView robot_action_2;
  private TextView robot_action_1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);

    message = (TextView) findViewById(R.id.message);
    win_rate = (TextView) findViewById(R.id.win_rate);
    loss = (TextView) findViewById(R.id.loss);
    Button rock = (Button) findViewById(R.id.rock);
    Button paper = (Button) findViewById(R.id.paper);
    Button scissors = (Button) findViewById(R.id.scissors);
    player_action_5 = (TextView) findViewById(R.id.player_action_5);
    player_action_4 = (TextView) findViewById(R.id.player_action_4);
    player_action_3 = (TextView) findViewById(R.id.player_action_3);
    player_action_2 = (TextView) findViewById(R.id.player_action_2);
    player_action_1 = (TextView) findViewById(R.id.player_action_1);
    robot_action_5 = (TextView) findViewById(R.id.robot_action_5);
    robot_action_4 = (TextView) findViewById(R.id.robot_action_4);
    robot_action_3 = (TextView) findViewById(R.id.robot_action_3);
    robot_action_2 = (TextView) findViewById(R.id.robot_action_2);
    robot_action_1 = (TextView) findViewById(R.id.robot_action_1);

    rock.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        GameFragment.update_game(GameFragment.ACTION_ROCK);
        updateGameText();
      }
    });
    paper.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        GameFragment.update_game(GameFragment.ACTION_PAPER);
        updateGameText();
      }
    });
    scissors.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        GameFragment.update_game(GameFragment.ACTION_SCISSORS);
        updateGameText();
      }
    });
  }

  private void setText(TextView view, String text, int status) {
    view.setText(text);
    setTextColor(view, status);
  }

  private void setTextColor(TextView view, int status) {
    if (status == GameFragment.STATUS_WIN) {
      view.setTextColor(getResources().getColor(R.color.colorFont1));
    } else if (status == GameFragment.STATUS_TIE) {
      view.setTextColor(getResources().getColor(R.color.colorAccent));
    } else {
      view.setTextColor(getResources().getColor(R.color.colorFont));
    }
  }

  private void updateGameText() {
    setText(message, GameFragment.get_message(GameFragment.player_turn(0)), GameFragment.player_turn(0));
    setText(win_rate, String.format("%.2f", GameFragment.get_win_rate()), GameFragment.player_turn(0));
//    setText(loss, String.format("%.10f", GameFragment.getLoss()), GameFragment.player_turn(0));
    setText(player_action_1, GameFragment.get_message(GameFragment.get_player(0)), GameFragment.player_turn(0));
    setText(robot_action_1, GameFragment.get_message(GameFragment.get_robot(0)), GameFragment.robot_turn(0));
    setText(player_action_2, GameFragment.get_message(GameFragment.get_player(1)), GameFragment.player_turn(1));
    setText(robot_action_2, GameFragment.get_message(GameFragment.get_robot(1)), GameFragment.robot_turn(1));
    setText(player_action_3, GameFragment.get_message(GameFragment.get_player(2)), GameFragment.player_turn(2));
    setText(robot_action_3, GameFragment.get_message(GameFragment.get_robot(2)), GameFragment.robot_turn(2));
    setText(player_action_4, GameFragment.get_message(GameFragment.get_player(3)), GameFragment.player_turn(3));
    setText(robot_action_4, GameFragment.get_message(GameFragment.get_robot(3)), GameFragment.robot_turn(3));
    setText(player_action_5, GameFragment.get_message(GameFragment.get_player(4)), GameFragment.player_turn(4));
    setText(robot_action_5, GameFragment.get_message(GameFragment.get_robot(4)), GameFragment.robot_turn(4));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.main_options, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled = true;
    //noinspection SwitchStatementWithTooFewBranches
    switch (item.getItemId()) {
      case R.id.sign_out:
        GoogleSignInRepository.getInstance().signOut()
            .addOnCompleteListener((task) -> {
              Intent intent = new Intent(this, LoginActivity.class);
              intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
              startActivity(intent);
            });
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }
  public enum Choice {
    ROCK,
    PAPER,
    SCISSORS
  }

  public enum Outcome {
    WIN,
    LOSS,
    DRAW
  }


}
