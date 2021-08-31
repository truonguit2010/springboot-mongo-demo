package com.realbizgames.demo.mongo.utils;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;

import static java.time.temporal.ChronoField.*;

public class DateTimeConvertor {

    public static final DateTimeFormatter OUR_DATE_TIME_FORMATTER;

    static {
        OUR_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
                .appendLiteral('-')
                .appendValue(MONTH_OF_YEAR, 2)
                .appendLiteral('-')
                .appendValue(DAY_OF_MONTH, 2)
                .appendLiteral(' ')
                .appendValue(HOUR_OF_DAY, 2)
                .appendLiteral(':')
                .appendValue(MINUTE_OF_HOUR, 2)
                .optionalStart()
                .appendLiteral(':')
                .appendValue(SECOND_OF_MINUTE, 2)
                .toFormatter();
    }

    /**
     * @param str 2021-04-01T00:00:00Z or 2021-12-12 00:00:00
     * @return
     */
    public static LocalDateTime to(String str) {
        if (StringUtils.isNullOrEmpty(str)) {
            return null;
        } else if (str.contains(" ")) {
            return LocalDateTime.parse(str, OUR_DATE_TIME_FORMATTER);
        } else {
            return LocalDateTime.parse(str, DateTimeFormatter.ISO_DATE_TIME);
        }
    }

    public static String from(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        } else {
            return localDateTime.format(OUR_DATE_TIME_FORMATTER);
        }
    }
}
