package dev.devos.client.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import dev.devos.client.model.Clip;
import dev.devos.client.model.Feed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ClipsService {

    Logger LOG = LoggerFactory.getLogger(ClipsService.class);

    List<Clip> myClips = new ArrayList<Clip>();

    WebClient webClient;

    public List<Clip> getClips(Optional<String> game_id, Optional<String> broadcaster_id) {
        try {
            if (game_id.isPresent()) {
                webClient = WebClient.create("http://localhost:8080/clips?game_id=" + game_id.get());
                myClips = webClient.get().retrieve().bodyToMono(Feed.class).block().getData();
            } else if (broadcaster_id.isPresent()) {
                webClient = WebClient.create("http://localhost:8080/clips?broadcaster_id=" + broadcaster_id.get());
                myClips = webClient.get().retrieve().bodyToMono(Feed.class).block().getData();
            } else {
                webClient = WebClient.create("http://localhost:8080/clips");
                myClips = webClient.get().retrieve().bodyToMono(Feed.class).block().getData();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("Getting the clips..." + myClips.toString());

        return myClips;
    }
    public List<Clip> getTrending() {
        try {
                webClient = WebClient.create("http://localhost:8080/clips?sort=trending");
                myClips = webClient.get().retrieve().bodyToMono(Feed.class).block().getData();

        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("Getting the clips..." + myClips.toString());

        return myClips;
    }
}
