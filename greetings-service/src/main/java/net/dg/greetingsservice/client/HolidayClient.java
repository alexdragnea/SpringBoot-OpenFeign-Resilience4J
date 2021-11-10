package net.dg.greetingsservice.client;

import feign.Client;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@FeignClient(name = "holidayClient", url = "http://localhost:8181/holiday-greetings")
public interface HolidayClient {


    @GetMapping("greetings")
    public String getGreetings();

    @Bulkhead(name = "holidayClient", fallbackMethod = "fallBack")
    @GetMapping("bulkhead")
    public String getGreetingsWithBulkhead();

    @RateLimiter(name = "holidayClient", fallbackMethod = "fallBack")
    @GetMapping("rate-limiter")
    public String getGreetingsWithRateLimiter();

    @Retry(name = "holidayClient", fallbackMethod = "fallBack")
    @GetMapping("retry")
    public String getGreetingsWithRetry();

    default String fallBack(Throwable ex) {
        return "Recovered with fallback: " + ex.getMessage();
    }

}
