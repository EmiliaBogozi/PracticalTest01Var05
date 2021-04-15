package ro.pub.cs.systems.eim.practicaltest01var05;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PracticalTest01Var05Service extends Service {

    private ProcessingThread processingThread = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String m1 = intent.getStringExtra(Constants.MESSAGE1);
        String m2 = intent.getStringExtra(Constants.MESSAGE2);
        String m3 = intent.getStringExtra(Constants.MESSAGE3);
        String m4 = intent.getStringExtra(Constants.MESSAGE4);
        String m5 = intent.getStringExtra(Constants.MESSAGE5);

        processingThread = new ProcessingThread(this, m1, m2, m3, m4, m5);
        processingThread.start();

        return Service.START_REDELIVER_INTENT;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        processingThread.stopThread();
    }
}