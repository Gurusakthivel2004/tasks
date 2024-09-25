package singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;


public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();
    
    private EagerSingleton() {
    	System.out.print("constructor");
    }

    public EagerSingleton getInstance() {
        return instance;
    }
    
    public static void abc() {
    	System.out.print("abc");
    }
    
    public void readObject(ObjectInputStream os) throws IOException,ClassNotFoundException {
    	os.defaultReadObject();
    	if(instance == null) {
    		instance = this;
    	}
    }
    
    private Object readResolve() throws ObjectStreamException{
    	return instance;
    }
}