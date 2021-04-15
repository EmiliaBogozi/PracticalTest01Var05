package ro.pub.cs.systems.eim.practicaltest01var05;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.sql.Date;

public class ProcessingThread extends Thread{
    private Context context = null;
    private String m1 = null;
    private String m2 = null;
    private String m3 = null;
    private String m4 = null;
    private String m5 = null;
    private boolean isRunning = true;

    public ProcessingThread(Context context, String m1, String m2, String m3, String m4, String m5) {
        this.context = context;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
    }

    @Override
    public void run() {
        Log.d(Constants.TAG, "Thread has started! ");
        while(isRunning) {
            sendMessage(m1);
            sleep();
            sendMessage(m2);
            sleep();
            sendMessage(m3);
            sleep();
            sendMessage(m4);
            sleep();
            sendMessage(m5);
            sleep();
        }
        Log.d(Constants.TAG, "Thread has stopped!");
    }

    private void sendMessage(String message) {
        Intent intent = new Intent();
        intent.setAction(Constants.INTENT_ACTION);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA,
                "Mesajul este " + message);
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
