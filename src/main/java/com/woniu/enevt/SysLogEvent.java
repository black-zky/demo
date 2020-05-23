package com.woniu.enevt;

import com.woniu.pojo.Log;
import org.springframework.context.ApplicationEvent;

public class SysLogEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public SysLogEvent(Log source) {
        super(source);
    }
}
