package com.example.demo.dto;

import java.util.List;
import com.example.demo.entity.Bike;

public class ChatResponse {

    private String message;
    private List<Bike> recommendations;
    private ChatSession session;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public List<Bike> getRecommendations() { return recommendations; }
    public void setRecommendations(List<Bike> recommendations) { this.recommendations = recommendations; }

    public ChatSession getSession() { return session; }
    public void setSession(ChatSession session) { this.session = session; }
}