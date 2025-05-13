package Sample;

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if(instance==null)
            return new LazySingleton();
        return instance;
    }
}
