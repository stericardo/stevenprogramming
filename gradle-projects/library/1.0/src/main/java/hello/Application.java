package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Steven Ricardo Mendez Brenes
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World Steven Ricardo Mendez Brenes!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
