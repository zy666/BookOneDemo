package com.tyb.event.common;


import com.tyb.event.BaseEvent;


public class BaseActivityEvent<T> extends BaseEvent<T> {
    public BaseActivityEvent(int code) {
        super(code);
    }
}
