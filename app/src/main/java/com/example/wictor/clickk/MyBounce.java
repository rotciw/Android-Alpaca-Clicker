package com.example.wictor.clickk;

public class MyBounce implements android.view.animation.Interpolator {

    private double mAmplitude = 1;
    private double mFrequency = 10;

    MyBounce(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }

}
