package com.example.demo.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class R {
    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public static R success(Object data) {
        return new R(true, 0, "success", data);
    }

    public static R failed() {
        return new R(true, 1, "error", null);
    }

}
