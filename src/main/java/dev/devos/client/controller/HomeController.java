package dev.devos.client.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("clipsfeed", clipsService.getClips(Optional.empty()));
        return "clipshome";
    }

    @GetMapping("/game")
    public String game(@RequestParam(required = true) String game_id, Model model) {
        model.addAttribute("gamesfeed", clipsService.getClips(Optional.of(game_id)));
        return "gameshome";
    }
    
}
