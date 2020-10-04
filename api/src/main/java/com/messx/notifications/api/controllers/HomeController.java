package com.messx.notifications.api.controllers;

import com.messx.notifications.lib.annotations.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    @LogExecutionTime
    public ResponseEntity<String> home(){
        log.info("request for api");
        return new ResponseEntity<String>("Basic controller", HttpStatus.OK);
    }
}
