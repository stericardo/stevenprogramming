package com.stevenprogramming.performance.config;

import com.stevenprogramming.performance.beans.BaseSingleton;
import com.stevenprogramming.performance.beans.SingletonA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * This class will serve a main Configuration Profile A
 *
 * @author Steven Ricardo Mendez Brenes
 * @version 1.0
 *
 */
@Profile("A")
@Configuration
public class ApproachA {

  @Bean(name = "singleton")
  public BaseSingleton singleton() {
    return new SingletonA();
  }

}
