package com.test.williamssonoma.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.test.williamssonoma.challenge.bean.ZipCodeRange;
import com.test.williamssonoma.challenge.helpers.ValidationHelper;
import com.test.williamssonoma.challenge.helpers.ZipCodeRangeComparator;


public class ZipCodeRangeCompressor {

    /* method to produce the array that represents the same ranges */
    public static ZipCodeRange[] reduceZipCodeRanges(String[] ranges) {

        List<String> invalidRanges = new ArrayList<String>();
        List<ZipCodeRange> validRanges = new ArrayList<ZipCodeRange>();
        for(String range : ranges) {
            if(ValidationHelper.isZipCodeRangeValid(range)) {
                String tokens[] = range.replace("[","").replace("]", "").split(",");

                int lowerBound = Integer.parseInt(tokens[0]);
                int upperBound = Integer.parseInt(tokens[1]);

                if(upperBound < lowerBound) {
                    int temp = lowerBound;
                    lowerBound = upperBound;
                    upperBound = temp;
                }
                validRanges.add(new ZipCodeRange(lowerBound, upperBound));
            } else {
                invalidRanges.add(range);
            }
        }

        if(invalidRanges.size() > 0) {
            throw new IllegalArgumentException("Invalid ranges found: " + invalidRanges + ", input given as 5-digit zip code ranges separated by spaces");
        } else {
            return reduceZipCodeRanges(validRanges);
        }
    }


    /* method to reduce overlapping zip codes */
    private static ZipCodeRange[] reduceZipCodeRanges(List<ZipCodeRange> ranges) {

        if(ranges == null) {
            return null;
        }
        if(ranges.size() == 0) {
            return new ZipCodeRange[0];
        }

        Collections.sort(ranges, new ZipCodeRangeComparator());
        List<ZipCodeRange> reducedRanges = new ArrayList<ZipCodeRange>();
        reducedRanges.add(ranges.get(0));
        ZipCodeRange currentZipCodeRange = ranges.get(0);
        int currentIdx = 0;
        for(int i = 1; i < ranges.size(); i++) {
            ZipCodeRange nextZipCodeRange = ranges.get(i);

            if(!currentZipCodeRange.equals(nextZipCodeRange)) {

                if(currentZipCodeRange.getUpperBound() >= nextZipCodeRange.getLowerBound()) {

                    int upperBound = 0;
                    if(currentZipCodeRange.getUpperBound() > nextZipCodeRange.getUpperBound()) {
                        upperBound = currentZipCodeRange.getUpperBound();
                    } else {
                        upperBound = nextZipCodeRange.getUpperBound();
                    }

                    ZipCodeRange newZipCodeRange = new ZipCodeRange(currentZipCodeRange.getLowerBound(), upperBound);
                    currentZipCodeRange = newZipCodeRange;
                    reducedRanges.set(currentIdx, newZipCodeRange);
                } else {
                    currentZipCodeRange = nextZipCodeRange;
                    reducedRanges.add(nextZipCodeRange);
                    currentIdx = i;
                }
            }
        }
        ZipCodeRange[] arr = new ZipCodeRange[reducedRanges.size()];
        arr = reducedRanges.toArray(arr);
        return arr;
    }

}
