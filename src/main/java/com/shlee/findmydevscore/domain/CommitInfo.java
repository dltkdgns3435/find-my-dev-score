package com.shlee.findmydevscore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
public class CommitInfo {
    private final int count;
    private final LocalDate date;

    public CommitInfo(String line){
        this.date = this.parseDate(line);
        this.count = this.parseCount(line);
    }

    private LocalDate parseDate(String line){
        int start = line.indexOf("data-date=\"") + "data-date=\"".length();
        int end = line.indexOf("\" data-level");
        String dateString = line.substring(start, end);

        return LocalDate.parse(dateString);
    }

    private int parseCount(String line){
        int start = line.indexOf("data-count=\"") + "data-count=\"".length();
        int end = line.indexOf("\" data-date");
        String countString = line.substring(start, end);

        return Integer.parseInt(countString);
    }
}
