package dev.devos.client.model;

import java.util.List;

import lombok.Data;

@Data
public class Feed {
    private List<Clip> data;
}