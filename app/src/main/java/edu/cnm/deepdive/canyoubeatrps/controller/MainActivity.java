package edu.cnm.deepdive.canyoubeatrps.controller;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.widget.Button;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;

public class MainActivity extends AppCompatActivity {

  private NavController navController;
  private NavOptions navOptions;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button button = findViewById(R.id.start_button);
    Button button2 = findViewById(R.id.how_to_button);

    button.setOnClickListener(
        new Button.OnClickListener() {
          @Override
          public void onClick(View v) {
            TextView statusText = findViewById(R.id.start_button);
            statusText.setText("Game play coming soon");
          }
        });
    button2.setOnClickListener(
        new Button.OnClickListener() {
          public void onClick(View v) {
            TextView statusText = findViewById(R.id.how_to_button);
            statusText.setText("How To coming soon");
          }
        }
    );
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

  private boolean setupNavigation() {
    navOptions = new NavOptions.Builder()
        .setPopUpTo(R.id.navigation_map, true)
        .build();
    AppBarConfiguration appBarConfiguration =
        new AppBarConfiguration.Builder(R.id.navigation_start)
            .build();
    navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
      return true;
  }



}
