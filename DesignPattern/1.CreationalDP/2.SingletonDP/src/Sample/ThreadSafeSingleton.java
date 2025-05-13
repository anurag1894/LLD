package Sample;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance ;
    private ThreadSafeSingleton(){}

    /*
    synchronized ensure it should access by only one thread. but it is costly.
     */
    public static  synchronized ThreadSafeSingleton getInstance(){
        if(instance == null)
             return new ThreadSafeSingleton();
        else return instance;
    }
}
