package com.test.williamssonoma.challenge.helper;

import com.test.williamssonoma.challenge.helpers.StringHelper;
import org.junit.Assert;
import org.junit.Test;

import com.test.williamssonoma.challenge.bean.ZipCodeRange;
public class StringHelperTest {


     /* Test for expanding an string array of strings with a space as delimiter */
    @Test
    public void strings() {
        Assert.assertEquals("1 2 3 4", StringHelper.connect(new String[] {"1", "2", "3", "4"}, " "));
    }


     /* Test for expanding an array of ZipCodeRange objects with a space as delimiter. */
    @Test
    public void zipCodeRanges() {
        ZipCodeRange range1 = new ZipCodeRange(10000,10001);
        ZipCodeRange range2 = new ZipCodeRange(10002,10003);
        ZipCodeRange range3 = new ZipCodeRange(10004,10005);

        ZipCodeRange[] ranges = new ZipCodeRange[] { range1, range2, range3 };

        Assert.assertEquals("[10000,10001] [10002,10003] [10004,10005]", StringHelper.connect(ranges, " "));
    }

}
