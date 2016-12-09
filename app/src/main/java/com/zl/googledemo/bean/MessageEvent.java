package com.zl.googledemo.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by zhanglin on 2016/12/9.
 */

public class MessageEvent<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    Objects data;
    int Type;
}
