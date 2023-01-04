package com.williamborgesc.restexampleapp.controller;

import com.williamborgesc.restexampleapp.dto.Quote;
import com.williamborgesc.restexampleapp.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping
    public Quote getRandom() throws IOException {

        return quoteService.getRandom();
    }
}
