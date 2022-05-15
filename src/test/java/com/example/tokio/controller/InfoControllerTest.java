package com.example.tokio.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InfoControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private InfoController infoController;

    @Test
    public void getStatus() throws Exception {
    }
}
