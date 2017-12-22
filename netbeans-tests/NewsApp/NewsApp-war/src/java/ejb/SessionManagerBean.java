package ejb;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author steven.mendez
 * @since Dec 21 2017
 * @version 1.0
 */
@Singleton
@LocalBean
@WebListener
public class SessionManagerBean implements HttpSessionListener {

    private static int counter = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        counter--;
    }
    
    public int getActiveSessionsCount() {
        return counter;
    }

}
