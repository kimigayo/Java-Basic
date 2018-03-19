package com.kimigayo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneTest {
    public static void main(String[] args) {
        String phone = "13899239876";
        Pattern pattern = Pattern.compile("1[^124][1-9]{9}");
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()){
            System.out.println(matcher.group());
        }
    }
}
