package net.dg.holidayservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holiday-greetings")
@Slf4j
public class HolidayServiceController {

    @GetMapping("/greetings")
    public String getHolidayGreetings(){
        log.info("Inside getHolidayGreetings of HolidayServiceController");
        return "I wish you all happy holidays!";
    }

    @GetMapping("/bulkhead")
    public String getHolidayGreetingsWithBulkhead(){
        log.info("Inside getHolidayGreetingsWithBulkhead of HolidayServiceController");
        return "I wish you all happy holidays!";
    }

    @GetMapping("/rate-limiter")
    public String getHolidayGreetingsWithRateLimiter(){
        log.info("Inside getHolidayGreetingsWithRateLimiter of HolidayServiceController");
        return "I wish you all happy holidays!";
    }

}
