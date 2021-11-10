package com.example.serviceboundmessengerexcercise;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyService extends Service {

    Messenger mMessenger = new Messenger(new IncomingHandler());

    static final int JOB_1 = 1;
    static final int JOB_2 = 2;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "Service Binding", Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }

    class IncomingHandler extends Handler{

        @Override
        public void handleMessage(@NonNull Message msg) {

            switch (msg.what){

                case JOB_1:
                    Toast.makeText(MyService.this, "Hello fron job 1", Toast.LENGTH_SHORT).show();
                    break;
                case JOB_2:
                    Toast.makeText(MyService.this, "Hello from job 2", Toast.LENGTH_SHORT).show();
                default:
                    super.handleMessage(msg);
            }

        }
    }
}
