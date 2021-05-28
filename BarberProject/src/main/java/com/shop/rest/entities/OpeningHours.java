package com.shop.rest.entities;

import com.shop.rest.constants.DaysOfWeek;
import org.springframework.stereotype.Component;

@Component
public class OpeningHours {

    private DaysOfWeek dayOfWeek;
    private Integer[] openFromUntil;
    private boolean open;

    public OpeningHours() {
    }

    public OpeningHours(DaysOfWeek dayOfWeek, Integer[] openFromUntil, boolean open) {
        setDayOfWeek(dayOfWeek);
        setOpenFromUntil(openFromUntil);
        setOpen(open);
    }

    public DaysOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DaysOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer[] getOpenFromUntil() {
        return openFromUntil;
    }

    public void setOpenFromUntil(Integer[] openFromUntil) {
        this.openFromUntil = openFromUntil;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
