package com.main.stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.*;
//import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setUp() {
        // your existing setup
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.district.in/");
    }

    @After
    public void tearDown(Scenario scenario) {
        // 1. Screenshot on failure
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver)
                                    .getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(
                "❌ Screenshot on Failure",
                new ByteArrayInputStream(screenshot)
            );
        }

        // 2. Browser console logs
        try {
            LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
            StringBuilder sb = new StringBuilder();
            for (LogEntry entry : logs) {
                sb.append("[").append(entry.getLevel()).append("] ")
                  .append(entry.getMessage()).append("\n");
            }
            Allure.addAttachment(
                "📝 Browser Console Logs",
                "text/plain",
                sb.toString(),
                ".log"
            );
        } catch (Exception ignored) {
            // some drivers may not support logs
        }

        // 3. (Optional) Attach a recorded video
        File video = new File("path/to/your-test-recording.mp4");
        if (video.exists()) {
            try (FileInputStream fis = new FileInputStream(video)) {
                Allure.addAttachment(
                    "🎥 Test Execution Video",
                    "video/mp4",
                    fis,
                    ".mp4"
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        driver.quit();
    }
}
