package com.zhbit.scratch.Utils;

import java.util.UUID;

//获取主键
public class IdUtils {

    public static String getPrimaryKey() {

        return UUID.randomUUID().toString().replaceAll("-", "");

    }
}