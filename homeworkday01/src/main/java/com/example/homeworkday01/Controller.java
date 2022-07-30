package com.example.homeworkday01;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@RestController
public class Controller {

    @GetMapping("/level1/{time}")
    public ResponseEntity<String> level1(@PathVariable("time") Long unixTimeAge) {
        try {
            isValidateInput(unixTimeAge);
            Date date = new Date(unixTimeAge * 1000L);
            SimpleDateFormat jdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
            return ResponseEntity.ok(jdf.format(date));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/level2")
    public ResponseEntity<String> level2(@RequestParam("time") Long unixTimeAge) {
        try {
            isValidateInput(unixTimeAge);
            Date date = new Date(unixTimeAge * 1000L);
            SimpleDateFormat jdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            LocalDate localDateinput = LocalDate.parse(jdf.format(date));
            LocalDate localDateNow = LocalDate.now();
            Period period = Period.between(localDateinput, localDateNow);
            long yearsBetween = period.getYears();
            long daysBetween = Math.abs(ChronoUnit.DAYS.between(localDateinput,localDateNow));
            String result = String.valueOf(yearsBetween) + "\t" + String.valueOf(daysBetween);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private static boolean isValidateInput(Long unixTimeInput) {
        if (unixTimeInput == 0) {
            throw new RuntimeException("Input time invalid: Zero");
        }

        if (unixTimeInput < 0) {
            throw new RuntimeException("Input time invalid: Negative");
        }

        return true;
    }
    

}
