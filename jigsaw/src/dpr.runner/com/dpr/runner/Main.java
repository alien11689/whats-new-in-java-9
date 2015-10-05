package com.dpr.runner;

import com.dpr.api.IHello;
import java.util.ServiceLoader;

public class Main {

  public static void main(String [] args) throws Exception {
    ServiceLoader<IHello> helloServices = ServiceLoader.load(IHello.class);
    for(IHello helloService : helloServices){
      System.out.println(helloService.helloWorld());
    }
  }
}
