package edu.cnm.deepdive.canyoubeatrps.controller;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game.Choice;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        GameFragment.update_game(Game.Choice.ROCK);
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

//  static SQLiteDatabase db=null;
//  private Choice player, computer;
//  int p = 0;
//  int c = 0;
//   Cursor res;
//  @Override
//  protected void onCreate(Bundle savedInstanceState) {
//    super.onCreate(savedInstanceState);
//    setContentView(R.layout.activity_game);
////    DbHelper dbh = new DbHelper(this, "game.db", null, 1);
////    db = dbh.getWritableDatabase();
//    Button bt1 = findViewById(R.id.rock);
//    Button bt2 = findViewById(R.id.paper);
//    Button bt3 = findViewById(R.id.scissors);
//    Button bt4 = findViewById(R.id.home_button);
//    bt1.setOnClickListener(this);
//    bt2.setOnClickListener(this);
//    bt3.setOnClickListener(this);
////    bt4.setOnClickListener(this);
//  }
//
//  @Override
//  public void onClick(View v) {
//
//    ImageView imageView = findViewById(R.id.player_choice);
//
//    boolean play = true;
//
//    switch (v.getId()) {
//      case R.id.rock:
//        player = Choice.ROCK;
//        imageView.setImageResource(R.drawable.rock);
//        break;
//      case R.id.paper:
//        player = Choice.PAPER;
//        imageView.setImageResource(R.drawable.paper);
//        break;
//      case R.id.scissors:
//        player = Choice.SCISSORS;
//        imageView.setImageResource(R.drawable.scissors);
//        break;
//    }
//
//    if (play) {
//      play();
//      if (p == 10 || c == 10)
//        showResults();
//    }
//  }
//
//  private void showResults() {
//    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
//    builder.setCancelable(false);
//    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//      @Override
//      public void onClick(DialogInterface dialog, int which) {
//        // Do nothing
//        try{
//          int noOfWins = 0;
//          if (c < p) {
//            ContentValues cv=new ContentValues();
//            ContentValues cv1=new ContentValues();
//            cv.put("name", String.valueOf(LoginActivity.class));
//            cv.put("score", p);
//            db.insert("highscore", null, cv);
//            if (res.moveToFirst()) {
//              noOfWins = Integer.parseInt(res.getString(res.getColumnIndex("wins")));
//            }
//            cv1.put("wins",(noOfWins)+1);
//            cv1.put("username", String.valueOf(LoginActivity.class));
//            db.insert("classicWins", null, cv1);
//            Toast.makeText(getApplicationContext(), "Your scores are submitted successfully", Toast.LENGTH_LONG).show();
//          }
//          TextView userS = findViewById(R.id.textView2);
//          TextView androidS = findViewById(R.id.textView3);
//          userS.setText(String.valueOf("Player score:" + p));
//          androidS.setText(String.valueOf("Computer Score:" + c));
//          p = 0;
//          c = 0;
//        }catch (SQLException e) {
//          Toast.makeText(getApplicationContext(), "Couldn't submit your scores. Please try again.", Toast.LENGTH_LONG).show();
//        }
//      }
//    });
//    if (c < p) {
//      builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//
//        @Override
//        public void onClick(DialogInterface arg0, int arg1) {
//          Intent k=new Intent(GameActivity.this, MainActivity.class);
//          startActivity(k);
//        }
//      });
//    }
//
//    // Sets the right message according to result.
//    if (c > p) {
//      builder.setMessage("You Loose!");
//    } else if (c < p) {
//      builder.setMessage("You Win!");
//    } else if (c == p) {
//      builder.setMessage("It's a draw!");
//    }
//
//    AlertDialog alert = builder.create();
//    alert.show();
//  }
//
//  private void play() {
//    // Generates a random play.
//    TextView userS = findViewById(R.id.textView2);
//    TextView androidS = findViewById(R.id.textView3);
//    Random random = new Random();
//    int rand = random.nextInt(3);
//    computer = null;
//    ImageView imageView = findViewById(R.id.computer_choice);
//
//    // Sets the right image according to random selection.
//    switch (rand) {
//      case 0:
//        computer = Choice.ROCK;
//        imageView.setImageResource(R.drawable.rock);
//        break;
//      case 1:
//        computer = Choice.PAPER;
//        imageView.setImageResource(R.drawable.paper);
//        break;
//      case 2:
//        computer = Choice.SCISSORS;
//        imageView.setImageResource(R.drawable.scissors);
//        break;
//    }
//    // Determine game result according to user selection and Android selection.
//    if (computer == player) {
//      p++;
//      c++;
//    } else if (computer == Choice.ROCK && player == Choice.SCISSORS) {
//
//      c++;
//    } else if (computer == Choice.PAPER && player == Choice.ROCK) {
//
//      c++;
//    } else if (computer == Choice.SCISSORS && player == Choice.PAPER) {
//
//      c++;
//    } else {
//
//      p++;
//    }
//    userS.setText(String.valueOf("Player score:" + p));
//    androidS.setText(String.valueOf("Computer Score:" + c));
//  }
//
//
//  @Override
//  public void onBackPressed() {
//    moveTaskToBack(true);
//    Intent back = new Intent(GameActivity.this, MainActivity.class);
//    startActivity(back);
//
//  }

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
