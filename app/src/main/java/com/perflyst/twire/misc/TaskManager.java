package com.perflyst.twire.misc;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import static android.app.ActivityManager.*;

public class TaskManager {

    /**
     * Bring up launcher task to front
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void navToLauncherTask(@Nonnull Context appContext) {
        ActivityManager activityManager = (ActivityManager) appContext.getSystemService(Context.ACTIVITY_SERVICE);
        // iterate app tasks available and navigate to launcher task (browse task)
        final List<AppTask> appTasks = activityManager.getAppTasks();
        for (AppTask task : appTasks) {
            final Intent baseIntent = task.getTaskInfo().baseIntent;
            final Set<String> categories = baseIntent.getCategories();
            if (categories != null && categories.contains(Intent.CATEGORY_LAUNCHER)) {
                task.moveToFront();
                return;
            }
        }
    }
}
