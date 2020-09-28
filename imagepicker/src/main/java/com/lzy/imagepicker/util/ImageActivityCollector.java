package com.lzy.imagepicker.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ImageActivityCollector {
    public static List<Activity> activitys = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activitys.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activitys.remove(activity);
    }

    public static void removeAll() {
        for (Activity activity : activitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
    /**
     * 除了传来的Activity其他的全部删除
     * 可以传多个Activity
     * @param clazz
     */
    public static void removeAll(Class<?>... clazz) {
        boolean isExist = false;
        for (Activity act : activitys) {
            for (Class c : clazz) {
                if (act.getClass().isAssignableFrom(c)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                if (!act.isFinishing()) {
                    act.finish();
                }
            } else {
                isExist = false;
            }
        }
    }
}
