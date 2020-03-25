package edu.cnm.deepdive.canyoubeatrps.service;

import android.annotation.SuppressLint;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.canyoubeatrps.BuildConfig;
import edu.cnm.deepdive.canyoubeatrps.model.entity.Game;
import io.reactivex.Single;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface CanYouBeatRpsService {

  String DATE_FORMAT = "yyyy-MM-dd";

  @SuppressLint("SimpleDateFormat")
  DateFormat DATE_FORMATTER = new SimpleDateFormat(DATE_FORMAT);

  @GET
  Single<Game> get(@Query("date") String date);


  class InstanceHolder {

    static {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .setDateFormat(DATE_FORMAT)
          .create();
    }

  }


}
