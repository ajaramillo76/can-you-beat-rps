package edu.cnm.deepdive.canyoubeatrps;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsDatabase;

public class CanYouBeatRpsApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);

    CanYouBeatRpsDatabase.setContext(this);
    new Thread (() -> CanYouBeatRpsDatabase.getInstance().getUserDao().delete()).start();
  }
}
