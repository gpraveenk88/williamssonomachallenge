package com.test.williamssonoma.challenge.helpers;

import java.util.Comparator;
import com.test.williamssonoma.challenge.bean.ZipCodeRange;

public class ZipCodeRangeComparator implements Comparator<ZipCodeRange>{

    public int compare(ZipCodeRange range1, ZipCodeRange range2) {

        int comp = range1.getLowerBound() - range2.getLowerBound();

        if(comp == 0) {
            comp = range1.getUpperBound() - range2.getUpperBound();
        }
        return comp;
    }
}

