package com.example.understanding_android_room_java.ui;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static final int THREAD_COUNT = 3;

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    private static final class InstanceHolder {
        private static AppExecutors instance = new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT), new MainThreadExecutor());
    }

    public static AppExecutors getInstance() {
        return InstanceHolder.instance;
    }

    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.mainThread = mainThread;
        this.networkIO = networkIO;
    }

    public Executor getDiskIO() {
        return diskIO;
    }

    public Executor getNetworkIO() {
        return networkIO;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }

    static class DiskIOThreadExecutor implements Executor {

        private final Executor mDiskIO;

        public DiskIOThreadExecutor() {
            mDiskIO = Executors.newSingleThreadExecutor();
        }

        @Override
        public void execute(@NonNull Runnable command) {
            mDiskIO.execute(command);
        }
    }
}
