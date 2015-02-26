package login;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class LoginListener
 * foo
 */
@WebListener
public class LoginListener implements ServletContextListener {
	acctMan.AccountManager accountManager;

    /**
     * Default constructor. 
     */
    public LoginListener() {
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ServletContext context;
        accountManager = new acctMan.AccountManager();
        context = arg0.getServletContext();
        context.setAttribute("manager", accountManager);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    }
	
}
