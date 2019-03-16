package com.test.williamssonoma.challenge;
import org.junit.Test;
import com.test.williamssonoma.challenge.bean.ZipCodeRange;
import org.junit.Assert;
import com.test.williamssonoma.challenge.helpers.StringHelper;

public class ZipCodeRangeCompressorTest {
  
  
       /* One overlapping range */
        @Test
        public void case2() {
            ZipCodeRange[] newRanges = ZipCodeRangeCompressor.reduceZipCodeRanges(new String[]{
                    "[94133,94133]", "[94200,94299]", "[94226,94399]"
            });
            Assert.assertEquals("[94133,94133] [94200,94399]", StringHelper.connect(newRanges, " "));
        }

        /* No overlapping ranges */
        @Test
        public void case1() {
        ZipCodeRange[] newRanges = ZipCodeRangeCompressor.reduceZipCodeRanges(new String[]{
                "[94133,94133]", "[94200,94299]", "[94600,94699]"
        });
        Assert.assertEquals("[94133,94133] [94200,94299] [94600,94699]", StringHelper.connect(newRanges, " "));
        }


         /* All the same ranges */
        @Test
        public void case3() {
            ZipCodeRange[] newRanges = ZipCodeRangeCompressor.reduceZipCodeRanges(new String[]{
                    "[11111,11111]", "[11111,11111]", "[11111,11111]"
            });
            Assert.assertEquals("[11111,11111]", StringHelper.connect(newRanges, " "));
        }

         /* what happens when backward ranges are given */
        @Test
        public void case5() {
            ZipCodeRange[] newRanges = ZipCodeRangeCompressor.reduceZipCodeRanges(new String[]{
                    "[31111,11111]", "[11111,31111]", "[11110,11111]", "[11117,10000]", "[11110,11119]", "[32110,33112]"
            });
            Assert.assertEquals("[10000,31111] [32110,33112]", StringHelper.connect(newRanges, " "));
        }

}
