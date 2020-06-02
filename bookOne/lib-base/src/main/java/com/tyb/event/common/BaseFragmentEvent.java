package com.tyb.event.common;

import com.tyb.event.BaseEvent;


public class BaseFragmentEvent<T> extends BaseEvent<T> {
    public BaseFragmentEvent(int code) {
        super(code);
    }
}
