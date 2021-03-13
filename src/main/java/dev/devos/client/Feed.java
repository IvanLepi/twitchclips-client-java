package dev.devos.client;

import java.util.List;

import lombok.Data;

@Data
public class Feed {
    private List<Clip> data;
}