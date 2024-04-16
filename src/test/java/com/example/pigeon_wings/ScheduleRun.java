package com.example.pigeon_wings;

import io.cucumber.core.cli.Main;

import javax.mail.MessagingException;
import java.io.IOException;
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
                String [] argv = new String[]{ "-g","","classpath:features", "--tags", "@test-1 or @test-2", "--plugin", "html:D:/SpringBootCourse/IntellijWorkSpace/screenshotStore/report_nop.html"};
              ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Main.run(argv, contextClassLoader);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                SendAutoEmail cls = new SendAutoEmail();
                try {
                    SendAutoEmail.sendReportEmail();
                } catch (IOException | MessagingException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("running ");

            }, calculateDelay(), 2*60*60, TimeUnit.SECONDS);
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
                nextRun.add(Calendar.DATE, 1);
            }
            return nextRun.getTimeInMillis() - now.getTimeInMillis();
        }
    }

