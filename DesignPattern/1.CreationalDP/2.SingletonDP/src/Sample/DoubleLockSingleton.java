package Sample;

public class DoubleLockSingleton {
    private static DoubleLockSingleton instance ;
    private DoubleLockSingleton(){}

    /*
    This is widely used , always used this in LLD.
     */
    public static DoubleLockSingleton getInstance(){
        if(instance ==null){
            synchronized (DoubleLockSingleton.class) {
                if (instance == null)
                    return new DoubleLockSingleton();
            }
        }
        return instance;
    }
}
