package dev.devos.client.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;

import dev.devos.client.model.Clip;
import dev.devos.client.service.ClipsService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    List<String> clipArray = new ArrayList<>();

    ClipsService clipsService;

    @Autowired
    HomeController(ClipsService clipsService) {
        this.clipsService = clipsService;
    }

    @GetMapping("/")
    public String clipshome(Model model) {
        model.addAttribute("clipsfeed", clipsService.getClips(Optional.empty(), Optional.empty()));
        return "clipshome";
    }

    @GetMapping("/game")
    public String game(@RequestParam(required = true) String game_id, Model model) {
        model.addAttribute("clipsfeed", clipsService.getClips(Optional.of(game_id), Optional.empty()));
        return "clipshome";
    }

    @GetMapping("/channel")
    public String channel(@RequestParam(required = true) String broadcaster_id, Model model) {
        model.addAttribute("clipsfeed", clipsService.getClips(Optional.empty(), Optional.of(broadcaster_id)));
        return "clipshome";
    }

    @GetMapping("/video")
    public String video(@RequestParam(required = true) String embed_url, Model model) {
        // clipArray.add(embed_url);
        // clipArray.add(broadcaster_name);
        // clipArray.add(view_count);
        model.addAttribute("videosfeed", embed_url);
        return "videopage";
    }

    @GetMapping("/trending")
    public String trendinghome(Model model) {
        model.addAttribute("trendingfeed", clipsService.getTrending());
        return "clipshome";
    }

}
