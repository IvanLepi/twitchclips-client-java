package dev.devos.client.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.devos.client.ClipsService;
import org.springframework.web.client.RestTemplate;
import dev.devos.client.Feed;

@RestController
public class HomeController {

     
    ClipsService clipsService;

    @Autowired
    HomeController(ClipsService clipsService){
        this.clipsService = clipsService;
    }

    @GetMapping("/")
    public String clipshome(Model model) {
        model.addAttribute("clipsfeed", clipsService.getClips());
        return "clipshome";
    }
    
}
