package edu.cnm.deepdive.canyoubeatrps.controller;

import android.app.Activity;
import android.se.omapi.Session;
import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import org.tensorflow.lite.Tensor;

public class TensorFlow {

  private Tensor output_tensor;
  private Tensor loss_tensor;
  private Session s;

  static {
    System.loadLibrary("tensorflow_inference");
  }

  public TensorFlow(Activity a, String file) {
    try {
      InputStream initialStream = a.getAssets().open(file);
      byte[] targetArray = new byte[initialStream.available()];
      initialStream.read(targetArray);
    } catch (IOException e) {
      e.printStackTrace();
      s = null;
    }
  }

  public void init() {

  }
//
//  public void inference(Tensor input_tensor) {
//    List<Tensor<?>> results = s.runner()
//        .feed("input_tensor", input_tensor)
//        .fetch("output_tensor")
//        .run();
//    output_tensor = results.get(0);
//  }
//
//  public void train(Tensor input_tensor, Tensor label_tensor) {
//    List<Tensor<?>> results = s.runner()
//        .feed("input_tensor", input_tensor)
//        .feed("label_tensor", label_tensor)
//        .addTarget("backprop")
//        .fetch("output_tensor")
//        .fetch("loss_tensor")
//        .run();
//    output_tensor = results.get(0);
//    loss_tensor = results.get(1);
//  }
//
  public float[] getOutput() {
    FloatBuffer buffer = FloatBuffer.allocate(3);
//    output_tensor.writeTo(buffer);
    return buffer.array();
  }
//
//  public float getLoss() {
//    return loss_tensor.floatValue();
//  }

}

