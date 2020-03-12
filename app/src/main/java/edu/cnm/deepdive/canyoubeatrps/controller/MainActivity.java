package edu.cnm.deepdive.canyoubeatrps.controller;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.canyoubeatrps.R;
import edu.cnm.deepdive.canyoubeatrps.service.GoogleSignInRepository;

public class MainActivity extends AppCompatActivity {

  private ProgressBar loading;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loading = findViewById(R.id.loading);
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
