package com.test.williamssonoma.challenge.helper;

import com.test.williamssonoma.challenge.helpers.ValidationHelper;

import org.junit.Assert;
import org.junit.Test;

public class ValidationHelperTest {


     /* Test various valid zip code strings */
    @Test
    public void validPatterns() {
        //valid
        Assert.assertEquals(true, ValidationHelper.isZipCodeRangeValid("[12424,32424]"));

        //valid
        Assert.assertEquals(true, ValidationHelper.isZipCodeRangeValid("[44444,55555]"));
    }

     /* Test various invalid zip code strings */
    @Test
    public void invalidPatterns() {
        //missing leading bracket
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid("33333,55555]"));

        //missing trailing bracket
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid("[33333,55555"));

        //no comma in between
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid("[44444455555]"));

        //missing upper bound
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid("[44444,]"));

        //missing lower bound
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid("[,44444]"));

        //special characters
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid("[$44a4,444#?]"));

        //null
        Assert.assertEquals(false, ValidationHelper.isZipCodeRangeValid(null));
    }

}
