package hackzurich.learnwithus;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class MyPostNotificationReceiver extends BroadcastReceiver {
    public static final String CONTENT_KEY = "contentText";

    public MyPostNotificationReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra(CONTENT_KEY);
        postNotification(context, createNotification(context, text));
        Toast.makeText(context, context.getString(R.string.notification_posted), Toast.LENGTH_SHORT).show();
    }

    private void postNotification(Context context, Notification notification) {
        ((NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, notification);
    }

    @NonNull
    private Notification createNotification(Context context, String text) {
        return new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Question:")
                .setContentText("Question Question Question Question Question Question Question Question Question Question Question Question Question Question ")
                .extend(createWearableExtension(context))
                .build();
    }

    private Notification.WearableExtender createWearableExtension(Context context) {
        return new Notification.WearableExtender()
                .addPage(createFirstPage(context))
                .addPage(createSecondPage(context))
                .setDisplayIntent(createThirdPage(context));
    }

    private Notification createFirstPage(Context context) {
        return new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Answer A:")
                .setContentText("Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A Answer A ")
                .setStyle(new NotificationCompat.BigTextStyle())
                .setContentIntent(createPendingIntent(context))
                .build();
    }

    private Notification createSecondPage(Context context) {
        return new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Answer B:")
                .setContentText("Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B Bnswer B ")
                .setStyle(new NotificationCompat.BigTextStyle())
                .setContentIntent(createPendingIntent(context))
                .build();
    }

    private PendingIntent createThirdPage(Context context) {
        Intent intent = new Intent(context, JustWatchActivity.class);
        return PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        return new NotificationCompat.WearableExtender()
//                .setDisplayIntent(pendingIntent)
//                .build();
    }

    private PendingIntent createPendingIntent(Context context) {
        Intent displayIntent = new Intent(context, MyDisplayActivity.class);
        return PendingIntent.getActivity(context, 0, displayIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
