package dev.devos.client.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.devos.client.service.ClipsService;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

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

}
