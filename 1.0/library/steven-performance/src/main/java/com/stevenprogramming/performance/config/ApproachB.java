package com.stevenprogramming.performance.config;

import com.stevenprogramming.performance.beans.BaseSingleton;
import com.stevenprogramming.performance.beans.SingletonB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * This class will serve a main Configuration Profile B
 *
 * @author Steven Ricardo Mendez Brenes
 * @version 1.0
 *
 */
@Profile("B")
@Configuration
public class ApproachB {
  
    @Bean(name = "singleton")
  public BaseSingleton singleton() {
    return new SingletonB();
  }
}
