package net.dg.greetingsservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.dg.greetingsservice.client.HolidayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
@RequestMapping("greetings")
@AllArgsConstructor
public class GreetingsServiceController {

    private final HolidayClient holidayClient;

    @GetMapping()
    public String getGreetings() {
        return holidayClient.getGreetings();
    }

    @GetMapping("/bulkhead")
    public String getGreetingsWithBulkhead(){
        return holidayClient.getGreetingsWithBulkhead();
    }

    @GetMapping("/rate-limiter")
    public String getGreetingsWithRateLimiter(){
        return holidayClient.getGreetingsWithRateLimiter();
    }

    @GetMapping("/retry")
    public String getGreetingsWithRetry(){
        return holidayClient.getGreetingsWithRetry();
    }
    

}
