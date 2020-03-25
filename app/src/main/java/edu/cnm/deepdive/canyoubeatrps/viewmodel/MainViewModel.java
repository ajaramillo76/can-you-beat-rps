package edu.cnm.deepdive.canyoubeatrps.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import edu.cnm.deepdive.canyoubeatrps.model.pojo.UserSummary;
import edu.cnm.deepdive.canyoubeatrps.model.repository.GameRepository;
import edu.cnm.deepdive.canyoubeatrps.service.CanYouBeatRpsService;
import io.reactivex.disposables.CompositeDisposable;
import java.text.ParseException;
import java.util.Date;

public class MainViewModel extends AndroidViewModel implements LifecycleObserver {

  private final MutableLiveData<Throwable> throwable;
  private final MutableLiveData<Game> game;
  private final CompositeDisposable pending;
  private final GameRepository repository;

  public MainViewModel(@NonNull Application application) {
    super(application);
    repository = GameRepository.getInstance();
    throwable = new MutableLiveData<>();
    game = new MutableLiveData<>();
    pending = new CompositeDisposable();
    Date today = new Date();
    String formattedDate = CanYouBeatRpsService.DATE_FORMATTER.format(today);
    try {
      setGameDate(CanYouBeatRpsService.DATE_FORMATTER
      .parse(formattedDate));
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }

  public void setGameDate(Date date) {
    throwable.setValue(null);
    pending.add(
        repository.get(date)
        .subscribe(
            game::postValue,
            throwable::postValue
        )
    );
  }

  @SuppressWarnings("unused")
  @OnLifecycleEvent(Event.ON_STOP)
  private void disposePending() {
    pending.clear();
  }


}
