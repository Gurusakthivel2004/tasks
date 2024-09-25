package thread;

import java.util.logging.Level;
import java.util.logging.Logger;


public class ExtendedThread extends Thread{

    private volatile boolean isRunning = true;
    private Logger logger = Logger.getLogger(ExtendedThread.class.getName());
    private long milli;
    
    public ExtendedThread(long milli) {
    	this.milli = milli;
    }
    
    public ExtendedThread(String name, long milli) {
    	super(name);
    	this.milli = milli;
    }

    public void toggleRunning() {
    	isRunning = !isRunning;
    }
    
	public void run(){
		int core = Runtime.getRuntime().availableProcessors();
        System.out.println(Thread.currentThread().getName() + " is running on core: " + core);
		logger.info("Thread Name: " + Thread.currentThread().getName());
        logger.info("Thread Priority: " + Thread.currentThread().getPriority());
        logger.info("Thread State: " + Thread.currentThread().getState());
        logger.info("Going to Sleep: " + Thread.currentThread().getName());
        try {
            while (isRunning) {
                Thread.sleep(milli);
            }
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "Interrupted Exception occured !", e);;
        }
        logger.info("After sleeping: " + Thread.currentThread().getName());
	}
}