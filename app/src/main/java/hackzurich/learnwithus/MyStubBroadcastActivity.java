package hackzurich.learnwithus;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Example shell activity which simply broadcasts to our receiver and exits.
 */
public class MyStubBroadcastActivity extends Activity {

    private JobScheduler jobScheduler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent();
        i.setAction("hackzurich.learnwithus.SHOW_NOTIFICATION");
        i.putExtra(MyPostNotificationReceiver.CONTENT_KEY, getString(R.string.title));
        sendBroadcast(i);

        jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

        JobInfo.Builder builder = new JobInfo.Builder(1,new ComponentName(getPackageName(), JobSchedulerService.class.getName()))
                .setPeriodic(5_000);
        if( jobScheduler.schedule(builder.build()) <= 0 ) {
            throw new RuntimeException("scheduling failed");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        jobScheduler.cancelAll();
    }
}
