package com.example.runner;

import com.example.api.IExample;
import java.util.ServiceLoader;

public class ExampleRunner {

  public static void main(String [] args) throws Exception {
    ServiceLoader<IExample> example = ServiceLoader.load(IExample.class);
    for(IExample e : example){
      System.out.println(e.helloWorld());
    }
  }
}
