package com.williamborgesc.restexampleapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.williamborgesc.restexampleapp.dto.Quote;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuoteService {

    @Value("${app.version}")
    private String version;

    public Quote getRandom() throws IOException {
        Quote quote = loadQuote().get(new Random().nextInt(50));
        quote.setHostname(InetAddress.getLoopbackAddress().getHostAddress());
        quote.setApplicationVersion(version);
        return quote;
    }

    private List<Quote> loadQuote() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = this.getClass().getResourceAsStream("/quotes.json");
        return objectMapper.readValue(inputStream,  new TypeReference<List<Quote>>(){});
    }
}
