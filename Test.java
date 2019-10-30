package com.neuedu.common;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String string="[java, php, mysql]";

        String replace = string.replace("[","").replace("]","").replace(" ","");
        String trim = replace.trim();
        System.out.println(trim);

    }
    }


