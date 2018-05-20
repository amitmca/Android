package com.srcsys.notify;

import java.util.Timer;
import java.util.TimerTask;
 
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
 
public class AndroidNotifications extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        Button notificationButton = (Button)findViewById(R.id.notificationButton);
 
        notificationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Timer timer = new Timer();
                timer.schedule(new TimerTask()
                {
                    @Override
                    public void run()
                    {
// Notification Title and Message
                        Notification("Notification Title","Notification Message");
                    }
                },0);
            }
        });
    }
 
// Notification Function
    private void Notification(String notificationTitle, String notificationMessage)
    {
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.icon, "A New Message!", System.currentTimeMillis());
 
        Intent notificationIntent = new Intent(this, AndroidNotifications.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
 
        notification.setLatestEventInfo(AndroidNotifications.this, notificationTitle, notificationMessage, pendingIntent);
        notificationManager.notify(10001, notification);
    }
}