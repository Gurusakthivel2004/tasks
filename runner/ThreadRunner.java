package runner;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import thread.ExtendedThread;
import thread.RunnableThread;

public class ThreadRunner {

    Logger logger = Logger.getLogger(FileRunner.class.getName());
    

	public static void main(String[] args) {
		ThreadRunner threadRunner = new ThreadRunner();		
		threadRunner.logger.info("Enter the question number: ");
	    try(Scanner reader = new Scanner(System.in);) {
	    	FileHandler infoHandler = new FileHandler("info.log", true);
			infoHandler.setLevel(Level.INFO);
	        infoHandler.setFormatter(new SimpleFormatter());
	        threadRunner.logger.addHandler(infoHandler);
	    	int questionNo = reader.nextInt();
		    reader.nextLine();
	    	switch(questionNo) {
		    
				case 1:
					threadRunner.handleExtendedThread(new ExtendedThread(0));
					break;
					
				case 2:
					threadRunner.handleRunnableThread(new Thread(new RunnableThread(0)));
					break;
					
				case 3:
					threadRunner.handleBothThreads();
					break;
					
				case 4:
					threadRunner.handleCustomThreads(reader);
					break;
					
				case 6:
					threadRunner.handleThreadDumps(reader);
					break;
					
				case -1:
					return;
	    	}	
		} catch (Exception e) {
			threadRunner.logger.severe("Error occured");
		}
	}
	
	public void handleThreadDumps(Scanner reader) throws InterruptedException {
		
		logger.info("Enter how many milliseconds you want the threads to sleep : ");
		long milliSeconds = reader.nextLong();
		logger.info("Enter how many threads you want to create : ");
		int numberOfThreads = reader.nextInt();
		logger.info("Enter how many minutes in milliseconds you want to wait : ");
		long minutes = reader.nextLong();
		logger.info("Enter the dump interval in milliseconds : ");
		long dumpInterval = reader.nextLong();
		logger.info("Enter the stop interval in milliseconds : ");
		long stopInterval = reader.nextLong();
		logger.info("Enter the number of thread dumps : ");
		long dumps = reader.nextLong();
		
		ExtendedThread[] extendedThreads = new ExtendedThread[numberOfThreads];
		Thread[] runnableThreads = new Thread[numberOfThreads];
		RunnableThread[] runnables = new RunnableThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            extendedThreads[i] = new ExtendedThread("ExtendedThread-" + i, milliSeconds * i);
            extendedThreads[i].start();
            
            runnables[i] = new RunnableThread(milliSeconds * i);
            runnableThreads[i] = new Thread(runnables[i], "RunnableThread-" + i);
            runnableThreads[i].start();
        }
        
        Thread.sleep(minutes);
        
        for (int i=0;i<numberOfThreads;i++) {
            logger.info("Stopping ExtendedThread-" + (i));
            extendedThreads[i].toggleRunning();
            Thread.sleep(stopInterval); 
            
            logger.info("Stopping RunnableThread-" + (i));
            runnables[i].toggleRunning();
            Thread.sleep(stopInterval); 
        }
        
        for (int i=0;i<dumps;i++) {
            takeThreadDump();
            Thread.sleep(dumpInterval); 
        }
        
        logger.info("All tasks completed.");
	}
	
	 public void takeThreadDump() {
		  for (Thread thread : Thread.getAllStackTraces().keySet()) {			  
			  logger.info("Thread Name: " + thread.getName());
			  logger.info("Thread State: " + thread.getState());
			  for (StackTraceElement element : thread.getStackTrace()) {
				  logger.info("" + element);
			  }
			  logger.info("");
	       }
	 }
	 
	 public static void printThreadDump() {
	        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
	        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(true, true);

	        System.out.println("Thread Dump:");
	        for (ThreadInfo threadInfo : threadInfos) {
	            System.out.println(threadInfo.toString());
	        }
	    }
	
	public void handleCustomThreads(Scanner reader) throws InterruptedException{
		logger.info("Enter how many milliseconds you want the threads to sleep : ");
		long milliSeconds = reader.nextLong();
		logger.info("Enter how many threads you want to create : ");
		int numberOfThreads = reader.nextInt();
		
		ExtendedThread[] extendedThreads = new ExtendedThread[numberOfThreads];
		Thread[] runnableThreads = new Thread[numberOfThreads];
		RunnableThread[] runnables = new RunnableThread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            extendedThreads[i] = new ExtendedThread("ExtendedThread-" + i, milliSeconds * i);
            extendedThreads[i].start();
            
            runnables[i] = new RunnableThread(milliSeconds * i);
            runnableThreads[i] = new Thread(runnables[i], "RunnableThread-" + i);
            runnableThreads[i].start();
        }
        Thread.sleep(5000);
        System.out.println("After sleeping");
        
        for (int i=0;i<numberOfThreads;i++) {
            logger.info("Stopping ExtendedThread-" + (i));
            extendedThreads[i].toggleRunning();
            
            logger.info("Stopping RunnableThread-" + (i));
            runnables[i].toggleRunning();
        }
        printThreadDump();
		
	}
	
	public void handleBothThreads() {
		ExtendedThread extendedThread = new ExtendedThread("ExtendedThread", 0);
		
		RunnableThread runnableThread = new RunnableThread(0);
		Thread rThread = new Thread(runnableThread, "RunnableThread");
		
		handleExtendedThread(extendedThread);
		handleRunnableThread(rThread);
	}
	
	public void handleRunnableThread(Thread runnableThread) {
		printThread();
		runnableThread.start();
		printThread();
	}
	
	public void handleExtendedThread(ExtendedThread extendedThread) {
		printThread();
		extendedThread.start();
		printThread();
	}
	
	public void printThread() {
		logger.info("Thread Name: " + Thread.currentThread().getName());
        logger.info("Thread Priority: " + Thread.currentThread().getPriority());
        logger.info("Thread State: " + Thread.currentThread().getState());
	}
	
 
}
