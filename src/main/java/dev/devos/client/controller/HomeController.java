package dev.devos.client.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import dev.devos.client.ClipsService;
import org.springframework.stereotype.Controller;


@Controller
public class HomeController {

     
    ClipsService clipsService;

    @Autowired
    HomeController(ClipsService clipsService){
        this.clipsService = clipsService;
    }

    @GetMapping("/clips")
    public String clipshome(Model model) {
        model.addAttribute("clipsfeed", clipsService.getClips());
        return "clipshome";
    }
    
}
