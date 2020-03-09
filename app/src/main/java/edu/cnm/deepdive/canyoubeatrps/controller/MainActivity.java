package edu.cnm.deepdive.canyoubeatrps.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.canyoubeatrps.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

/*    userChoice = (ImageView) findViewById(R.id.iv_userChoice);
    compChoice = (ImageView) findViewById(R.id.iv_compChoice);
    rock = (Button) findViewById(R.id.btn_rock);
    paper = (Button) findViewById(R.id.btn_paper);
    scissors = (Button) findViewById(R.id.btn_scissors);
    score = (TextView) findViewById(R.id.tv_score);

    compChoice.setImageResource(R.drawable.rock);
    userChoice.setImageResource(R.drawable.scissors);

    rock.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        userChoice.setImageResource(R.drawable.rock);
        String message = playTurn(1);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        score.setText("Your score: " + Integer.toString(playerWins) + "     Computer Score: " + Integer.toString(computerWins));

      }
    });

    paper.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        userChoice.setImageResource(R.drawable.paper);
        String message = playTurn(2);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        score.setText("Your score: " + Integer.toString(playerWins) + "     Computer Score: " + Integer.toString(computerWins));
      }
    });

    scissors.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        userChoice.setImageResource(R.drawable.scissors);
        String message = playTurn(3);
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        score.setText("Your score: " + Integer.toString(playerWins) + "     Computer Score: " + Integer.toString(computerWins));
      }
    });


  }

  int playerWins = 0;
  int computerWins = 0;

  public String playTurn(int playerChoice) {
    Random randomNum = new Random();

    int computerChoice = randomNum.nextInt(3) + 1;

    if (computerChoice == 1) {
      compChoice.setImageResource(R.drawable.rock);
    } else if (computerChoice == 2) {
      compChoice.setImageResource(R.drawable.paper);
    } else {
      compChoice.setImageResource(R.drawable.scissors);
    }

    if (playerChoice == computerChoice) {
      // Tie
      return "Tie!";
    } else if ( (playerChoice == 1 && computerChoice == 3) ||
        (playerChoice == 2 && computerChoice == 1) ||
        (playerChoice == 3 && computerChoice == 2)) {
      playerWins++;
      return "You Win... Congratulations!";
    } else {
      computerWins++;
      return "The Computer Won!";

    }


  } */

  }
}
