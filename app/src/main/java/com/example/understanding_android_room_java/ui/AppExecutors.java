package com.example.understanding_android_room_java.ui;

import java.util.concurrent.Executor;

public class AppExecutors {

    private static final int THREAD_COUNT = 3;

    private final Executor diskIO;

    private final Executor networkIO;

    private final Executor mainThread;

    private static final class InstanceHolder {
        
    }
}
