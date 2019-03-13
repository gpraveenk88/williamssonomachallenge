package com.test.williamssonoma.challenge.helpers;

import com.test.williamssonoma.challenge.bean.ZipCodeRange;

public class StringHelper {

    public static String connect(String[] arr, String delimiter) {
        StringBuffer buf = new StringBuffer();

        boolean first = false;
        for(String item : arr) {
            if(first == false) {
                buf.append(item);
                first = true;
            } else {
                buf.append(delimiter + item);
            }
        }
        return buf.toString();
    }

    public static String connect(ZipCodeRange[] ranges, String delimiter) {
        StringBuffer buf = new StringBuffer();

        boolean first = false;
        for(ZipCodeRange range : ranges) {
            if(first == false) {
                buf.append(range.toString());
                first = true;
            } else {
                buf.append(delimiter + range.toString());
            }
        }
        return buf.toString();
    }
}

