package com.fivengers.blooming.global.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

    public static LocalDate findLastSunday() {
        LocalDate todayDate = LocalDate.now();

        DayOfWeek todayDayOfWeek = todayDate.getDayOfWeek();

        return todayDate.minusDays(todayDayOfWeek.getValue());
    }

}
