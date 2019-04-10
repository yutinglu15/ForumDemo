package com.example.lab5reddit;

public class Message {
    String text;
    int score;

    public Message(){
        this.text = "";
        this.score = 0;
    }

    public Message(String text, int score) {
        this.text = text;
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
