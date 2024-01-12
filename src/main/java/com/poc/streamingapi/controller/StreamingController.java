package com.poc.streamingapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/streaming")
class StreamingController {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamText() {
        // Simulate a long-running process generating text
        return Flux.range(1, 10)
                .delayElements(java.time.Duration.ofSeconds(1))
                .map(i -> "Chunk " + i);
    }
}






+