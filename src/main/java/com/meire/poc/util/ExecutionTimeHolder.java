package com.meire.poc.util;

import org.springframework.stereotype.Component;

@Component
public
class ExecutionTimeHolder {
    private static long executionTime;

    public static void setExecutionTime(long time) {
        executionTime = time;
    }

    public static long getExecutionTime() {
        return executionTime;
    }
}