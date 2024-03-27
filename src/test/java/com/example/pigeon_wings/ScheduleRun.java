package com.example.pigeon_wings;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.testng.annotations.DataProvider;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ScheduleRun {
        public static void main(String[] args) {
            // Create a ScheduledExecutorService instance
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

            // Schedule the task to run every day at 12 AM
            executor.scheduleAtFixedRate(() -> {

                System.out.println("running ");

            }, calculateDelay(), 60, TimeUnit.SECONDS); // Run every 24 hours
        }

        // Calculate the delay until 12 AM
        private static long calculateDelay() {
            Calendar now = Calendar.getInstance();
            Calendar nextRun = Calendar.getInstance();
            nextRun.set(Calendar.HOUR_OF_DAY, 0);
            nextRun.set(Calendar.MINUTE, 0);
            nextRun.set(Calendar.SECOND, 0);
            nextRun.set(Calendar.MILLISECOND, 0);
            if (nextRun.before(now)) {
                nextRun.add(Calendar.SECOND, 1);
            }
            return nextRun.getTimeInMillis() - now.getTimeInMillis();
        }
    }

