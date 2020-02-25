package edu.cnm.deepdive.canyoubeatrps.service;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GoogleSignInRepository {

  private static Application context;

  private GoogleSignInClient client;
  private MutableLiveData<GoogleSignInAccount> account;
  private MutableLiveData<Throwable> throwable;

  private GoogleSignInRepository() {
    account = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    GoogleSignInOptions options; new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
        // .requestIdToken(clientId)
        .build();
  }

}
