package com.example.homeworkday01;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import static java.time.format.DateTimeFormatter.ofPattern;

@RestController
public class Controller {

    @GetMapping("/level1/{time}")
    public ResponseEntity<String> level1(@PathVariable("time") Long unixTimeAge) {
        try {
            isValidateInput(unixTimeAge);
            return ResponseEntity.ok(convertUnixTimeToDate(unixTimeAge));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }



    @GetMapping("/level2")
    public ResponseEntity<String> level2(@RequestParam("time") Long unixTimeAge) {
        try {
            isValidateInput(unixTimeAge);
            String result = calculateAndShowNumbersOfYearsAndDays(convertUnixTimeToDate(unixTimeAge));
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/level3/{time}")
    public ResponseEntity<String> level3(
            @PathVariable(value = "time", required = false) Long unixTimePath,
            @RequestParam(value = "timeParam", required = false) Long unixTimeParam,
            @RequestHeader(value = "unixTimeHeader",required = false) Long unixTimeHeader,
            @RequestBody(required = false) Long unixTimeBody) {

        Long unixTimeInput = null;

        if (unixTimeParam != null) {
            unixTimeInput = unixTimeParam;
        }
        if (unixTimePath != null) {
            unixTimeInput = unixTimePath;
        }
        if (unixTimeHeader != null) {
            unixTimeInput = unixTimeHeader;
        }
        if (unixTimeBody != null) {
            unixTimeInput = unixTimeBody;
        }

        try {
            isValidateInput(unixTimeInput);
            String result = calculateAndShowNumbersOfYearsAndDays(convertUnixTimeToDate(unixTimeInput));
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/level4")
    public ResponseEntity<String> level4(@RequestParam("time") String stringTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = LocalDate.parse(stringTime,dateTimeFormatter).toString();
            String result = calculateAndShowNumbersOfYearsAndDays(date);
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private static int count = 0;
    @GetMapping("/level5")
    public ResponseEntity<String> level5(@RequestParam("time") String stringTime) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String date = LocalDate.parse(stringTime,dateTimeFormatter).toString();
            String result = calculateAndShowNumbersOfYearsAndDays(date);
            count ++;
            return ResponseEntity.ok(result + "\t" + count);
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

    private static String convertUnixTimeToDate(Long unixTime) {
        Date date = new Date(unixTime * 1000L);
        SimpleDateFormat jdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return jdf.format(date);
    }

    private static String calculateAndShowNumbersOfYearsAndDays(String date) {
        LocalDate localDateInput = LocalDate.parse(date);
        long yearsBetween = Math.abs(ChronoUnit.YEARS.between(localDateInput, LocalDate.now()));
        long daysBetween = Math.abs(ChronoUnit.DAYS.between(localDateInput, LocalDate.now()));
        return String.valueOf(yearsBetween) + "\t" + String.valueOf(daysBetween);
    }

}
