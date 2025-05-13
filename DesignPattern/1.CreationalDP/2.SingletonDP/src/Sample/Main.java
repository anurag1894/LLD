package Sample;

public class Main {
    public static void main(String[] args) {

        /*
        1. Eager Solution instance will be created even it doesn't used;
         */
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();

         /*
           2.  Lazy initialization Solution instance will be created, But two  thread might get
           stuck at same time fetching the same time instance.
         */
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        // IF these two lines are executed from different thread , they might stuck

        /*
           3. ThreadSafe initialization, used synchronize  in method level
         */
        ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();

        /*
         4. Double Lock Singleton, always used this one
         */
        DoubleLockSingleton instance = DoubleLockSingleton.getInstance();
    }
}
