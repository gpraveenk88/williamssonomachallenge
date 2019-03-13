package com.test.williamssonoma.challenge.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationHelper {

    private static final Pattern zipCodePatternChecker = Pattern.compile("\\[\\d{5},\\d{5}\\]");

    public static boolean isZipCodeRangeValid(String zipCodeRange) {

        boolean valid = true;

        if(zipCodeRange == null) {
            valid = false;
        } else {
            Matcher matcher = zipCodePatternChecker.matcher(zipCodeRange);
            valid = matcher.matches();
        }
        return valid;
    }

}