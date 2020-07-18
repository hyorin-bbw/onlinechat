package com.hyorin.onlinechat.onlinechat_serveside;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ServeSideTest {

    public void test() {

    }

    @Test
    public void main() throws IOException {
        ServeSide serveSide = new ServeSide();
        String [] strings = new String[0];
        ServeSide.main(strings);
    }
}