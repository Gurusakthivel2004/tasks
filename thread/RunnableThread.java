package thread;

import java.util.logging.Level;
import java.util.logging.Logger;

import helper.util.Helper;
import runner.SecondLayer;

public class RunnableThread implements Runnable {

    private volatile boolean isRunning = true;
    Logger logger = Logger.getLogger(ExtendedThread.class.getName());
    private long milli;
    private ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "default");
    
    public RunnableThread(long milli) {
    	this.milli = milli;
    }
    
    public void toggleRunning() {
    	isRunning = !isRunning;
    }

	public void run() {
//		System.out.println("Before setting : " + Thread.currentThread().getName() + " - ThreadLocal : " + threadLocal.get());
//		threadLocal.set(Thread.currentThread().getName());
//		System.out.println("After setting : " + Thread.currentThread().getName() + " - ThreadLocal : " + threadLocal.get());
	    Helper.set(Thread.currentThread().getName());
		SecondLayer.thirdCall();
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