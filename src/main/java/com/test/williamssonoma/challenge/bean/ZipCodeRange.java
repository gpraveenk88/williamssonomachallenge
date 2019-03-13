package com.test.williamssonoma.challenge.bean;

public class ZipCodeRange {

    private int lowerBound;
    private int upperBound;

    public ZipCodeRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public String toString() {
        return "[" + lowerBound + "," + upperBound + "]";
    }


    public int getLowerBound() {
        return lowerBound;
    }


    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }


    public int getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(int upperBound) {
        this.upperBound = upperBound;
    }

    @Override
    public boolean equals(Object obj) {
        ZipCodeRange range = (ZipCodeRange) obj;
        return this.lowerBound == range.lowerBound && this.upperBound == range.upperBound;
    }
}
