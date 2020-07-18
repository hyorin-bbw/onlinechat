package com.hyorin.onlinechat.onlinechat_clientside;

import com.hyorin.onlinechat.onlinechat_serveside.ServeSide;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void main() {
        Client client = new Client();
        String[] s = new String[111];
        client.main(s);
    }
}