/*
 * Copyright (c) 2022 StulSoft
 */

package com.stulsoft.pjava.basics.network;

import java.io.IOException;
import java.net.ServerSocket;

public class FindFirstPort {
    public static void main(String[] args) {
        try {
            try (ServerSocket serverSocket = new ServerSocket(0)) {
                assert (serverSocket != null);
                assert (serverSocket.getLocalPort() > 0);
                System.out.printf("port=%d%n", serverSocket.getLocalPort());
            } catch (IOException e) {
                throw new RuntimeException("Port is not available");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
