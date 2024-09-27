package singleton;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class Singleton implements Serializable{

    private static final long serialVersionUID = 1L;

	private Singleton() {}

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public void readObject(ObjectInputStream os) throws IOException,ClassNotFoundException {
    	os.defaultReadObject();
    }
    
    private Object readResolve() throws ObjectStreamException{
    	return SingletonHelper.INSTANCE;
    }
}