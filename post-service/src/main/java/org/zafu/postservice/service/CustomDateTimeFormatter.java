package org.zafu.postservice.service;

import org.springframework.stereotype.Component;
import org.zafu.postservice.exception.AppException;
import org.zafu.postservice.exception.ErrorCode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Component
public class CustomDateTimeFormatter {

    Map<Long, Function<Instant, String>> strategy = new LinkedHashMap<>();

    public CustomDateTimeFormatter(){
        this.strategy.put(60L, this::secondsFormat);
        this.strategy.put(3600L, this::minutesFormat);
        this.strategy.put(84600L, this::hoursFormat);
        this.strategy.put(Long.MAX_VALUE, this::dateFormat);
    }


    private String secondsFormat(Instant instant){
        long elapseSeconds = ChronoUnit.SECONDS.between(instant, Instant.now());
        return elapseSeconds+" seconds";
    }

    private String minutesFormat(Instant instant){
        long elapseMinutes = ChronoUnit.MINUTES.between(instant, Instant.now());
        return elapseMinutes+" minutes";
    }

    private String hoursFormat(Instant instant){
        long elapseHours = ChronoUnit.HOURS.between(instant, Instant.now());
        return elapseHours+" hours";
    }

    private String dateFormat(Instant instant){
        LocalDateTime ldt = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        return ldt.format(dtf);
    }

    public String format(Instant instant){
        long elapseSeconds = ChronoUnit.SECONDS.between(instant, Instant.now());
        var function = strategy.entrySet()
                .stream()
                .filter(entry ->elapseSeconds < entry.getKey()).findFirst()
                .orElseThrow(()-> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
        return function.getValue().apply(instant);
    }

}
