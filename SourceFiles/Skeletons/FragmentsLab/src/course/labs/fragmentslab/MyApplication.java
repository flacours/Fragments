package course.labs.fragmentslab;

import android.app.Application;
import android.util.Log;

/**
 * Created by lacoursf on 07/02/14.
 */
public class MyApplication extends Application {
    private static final String TAG = "Lab-Fragments";
    // handler listener
    private Thread.UncaughtExceptionHandler _unCaughtExceptionHandler =
            new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread thread, Throwable ex) {

                    Log.i(TAG, "Exception : " + ex.getMessage());
                    Log.i(TAG, "Exception : " + ex.getClass());
                    Log.i(TAG, "Exception : " + ex.getStackTrace().toString());

                    // re-throw critical exception further to the os (important)
                    defaultUEH.uncaughtException(thread, ex);
                }
            };
    // uncaught exception handler variable
    private Thread.UncaughtExceptionHandler defaultUEH;

    public MyApplication() {
        defaultUEH = Thread.getDefaultUncaughtExceptionHandler();

        // setup handler for uncaught exception
        Thread.setDefaultUncaughtExceptionHandler(_unCaughtExceptionHandler);
    }
}
