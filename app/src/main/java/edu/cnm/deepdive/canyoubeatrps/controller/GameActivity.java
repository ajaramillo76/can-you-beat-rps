package edu.cnm.deepdive.canyoubeatrps.controller;

import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;
import java.util.Random;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements OnClickListener {

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

  static SQLiteDatabase db=null;
  private Choice player, computer;
  int p = 0;
  int c = 0;
   Cursor res;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_game);
//    DbHelper dbh = new DbHelper(this, "game.db", null, 1);
//    db = dbh.getWritableDatabase();
    Button bt1 = findViewById(R.id.rock);
    Button bt2 = findViewById(R.id.paper);
    Button bt3 = findViewById(R.id.scissors);
    Button bt4 = findViewById(R.id.home_button);
    bt1.setOnClickListener(this);
    bt2.setOnClickListener(this);
    bt3.setOnClickListener(this);
//    bt4.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {

    ImageView imageView = findViewById(R.id.player_choice);

    boolean play = true;

    switch (v.getId()) {
      case R.id.rock:
        player = Choice.ROCK;
        imageView.setImageResource(R.drawable.rock);
        break;
      case R.id.paper:
        player = Choice.PAPER;
        imageView.setImageResource(R.drawable.paper);
        break;
      case R.id.scissors:
        player = Choice.SCISSORS;
        imageView.setImageResource(R.drawable.scissors);
        break;

      case R.id.home_button:
        Intent i = new Intent(GameActivity.this, MainActivity.class);
        startActivity(i); // To go home.
        play = false;
        finish();
        break;

    }




    if (play) {
      play();
      if (p == 10 || c == 10)
        showResults();
    }
  }

  private void showResults() {
    AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
    builder.setCancelable(false);
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        // Do nothing
        try{
          int noOfWins = 0;
          if (c < p) {
            ContentValues cv=new ContentValues();
            ContentValues cv1=new ContentValues();
            cv.put("name", String.valueOf(LoginActivity.class));
            cv.put("score", p);
            db.insert("highscore", null, cv);
            if (res.moveToFirst()) {
              noOfWins = Integer.parseInt(res.getString(res.getColumnIndex("wins")));
            }
            cv1.put("wins",(noOfWins)+1);
            cv1.put("username", String.valueOf(LoginActivity.class));
            db.insert("classicWins", null, cv1);
            Toast.makeText(getApplicationContext(), "Your scores are submitted successfully", Toast.LENGTH_LONG).show();
          }
          TextView userS = findViewById(R.id.textView2);
          TextView androidS = findViewById(R.id.textView3);
          userS.setText(String.valueOf("Player score:" + p));
          androidS.setText(String.valueOf("Computer Score:" + c));
          p = 0;
          c = 0;
        }catch (SQLException e) {
          Toast.makeText(getApplicationContext(), "Couldn't submit your scores. Please try again.", Toast.LENGTH_LONG).show();
        }
      }
    });
    if (c < p) {
      builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface arg0, int arg1) {
          Intent k=new Intent(GameActivity.this, MainActivity.class);
          startActivity(k);
        }
      });
    }

    // Sets the right message according to result.
    if (c > p) {
      builder.setMessage("You Loose!");
    } else if (c < p) {
      builder.setMessage("You Win!");
    } else if (c == p) {
      builder.setMessage("It's a draw!");
    }

    AlertDialog alert = builder.create();
    alert.show();
  }

  private void play() {
    // Generates a random play.
    TextView userS = (TextView) findViewById(R.id.textView2);
    TextView androidS = (TextView) findViewById(R.id.textView3);
    Random random = new Random();
    int rand = random.nextInt(3);
    computer = null;
    ImageView imageView = (ImageView) findViewById(R.id.computer_choice);

    // Sets the right image according to random selection.
    switch (rand) {
      case 0:
        computer = Choice.ROCK;
        imageView.setImageResource(R.drawable.rock);
        break;
      case 1:
        computer = Choice.PAPER;
        imageView.setImageResource(R.drawable.paper);
        break;
      case 2:
        computer = Choice.SCISSORS;
        imageView.setImageResource(R.drawable.scissors);
        break;
    }
    // Determine game result according to user selection and Android selection.
    if (computer == player) {
      p++;
      c++;
    } else if (computer == Choice.ROCK && player == Choice.SCISSORS) {

      c++;
    } else if (computer == Choice.PAPER && player == Choice.ROCK) {

      c++;
    } else if (computer == Choice.SCISSORS && player == Choice.PAPER) {

      c++;
    } else {

      p++;
    }
    userS.setText(String.valueOf("Player score:" + p));
    androidS.setText(String.valueOf("Computer Score:" + c));
  }


  @Override
  public void onBackPressed() {
    moveTaskToBack(true);
    Intent back = new Intent(GameActivity.this, MainActivity.class);
    startActivity(back);

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
  
}
