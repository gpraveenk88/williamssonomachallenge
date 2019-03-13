package com.test.williamssonoma.challenge;

import com.test.williamssonoma.challenge.helpers.StringHelper;
import com.test.williamssonoma.challenge.bean.ZipCodeRange;

public class ZipCodeReducerMain {

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Please provide input. Input must be 5-digit zip code ranges separated by spaces: [#####,#####] [#####,#####]");
            System.exit(1);
        }
        System.out.println("Input: " + StringHelper.connect(args, " "));
        ZipCodeRange[] ranges = ZipCodeRangeCompressor.reduceZipCodeRanges(args);
        System.out.println("Output: " + StringHelper.connect(ranges, " "));
    }

}
