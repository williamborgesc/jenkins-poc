package com.williamborgesc.restexampleapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @JsonProperty("q")
    private String text;

    @JsonProperty("a")
    private String author;

    private String hostname;
    private String applicationVersion;
}
