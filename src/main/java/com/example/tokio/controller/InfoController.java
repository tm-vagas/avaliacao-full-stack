package com.example.tokio.controller;

import com.example.tokio.util.Util;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;


@RestController
@RequestMapping("/api/info/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InfoController {

    @GetMapping(value = "/status", produces = "application/json")
    public HashMap<String, Object> getStatus() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", UUID.randomUUID().toString());
        map.put("status", "ok");
        map.put("date", Util.getCurrentDate());
        return map;
    }
}
