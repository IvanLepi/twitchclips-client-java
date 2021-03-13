package dev.devos.client;
import java.util.List;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ClipsService {

    
    Logger LOG = LoggerFactory.getLogger(ClipsService.class);

    List<Clip> myClips = new ArrayList<Clip>();
        
    WebClient webClient = WebClient.create("http://localhost:8080/clips");
   
    public List<Clip> getClips() {
        try {
            
            myClips = webClient.get().retrieve().bodyToMono(Feed.class).block().getData();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("Getting the clips..." + myClips.toString());
        
        return myClips;
    }
}
