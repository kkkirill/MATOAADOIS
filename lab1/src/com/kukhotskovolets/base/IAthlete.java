package com.kukhotskovolets.base;

public interface IAthlete {
    default void train() {
        train(1);
    }

    void train(int boostFactor);

    void compete();
}
