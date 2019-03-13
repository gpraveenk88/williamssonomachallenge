package com.test.williamssonoma.challenge.bean;

import org.junit.Assert;
import org.junit.Test;

public class ZipCodeRangeTest {


    /* To test Zip code equals method */
    @Test
    public void equals() {

        ZipCodeRange range = new ZipCodeRange(10000,20000);
        ZipCodeRange rangeEquals = new ZipCodeRange(10000,20000);
        ZipCodeRange rangeNotEquals = new ZipCodeRange(10001,20000);

        Assert.assertEquals(range, rangeEquals);
        Assert.assertNotEquals(range, rangeNotEquals);
    }
}