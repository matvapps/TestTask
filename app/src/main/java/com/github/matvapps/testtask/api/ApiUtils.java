package com.github.matvapps.testtask.api;

/**
 * Created by Alexandr.
 */
public class ApiUtils {
    public static TestTaskApi getTestTaskApi() {
        return NetworkClient.getRetrofit().create(TestTaskApi.class);
    }
}