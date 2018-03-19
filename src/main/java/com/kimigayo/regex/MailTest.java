package com.kimigayo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailTest {
    public static void main(String[] args) {
        String mail="1290932@qq.com";
        Pattern pattern = Pattern.compile("[0-9a-zA-Z]+@[0-9a-zA-Z]+(\\.[a-zA-Z]{2,4}){1,2}");
        Matcher matcher = pattern.matcher(mail);
        if (matcher.matches())
            System.out.println(matcher.group());
    }
}
