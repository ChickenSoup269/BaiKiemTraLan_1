package com.example.kiemtralan_1;

public class BankMessage implements Comparable<BankMessage>{

    private String date;
    private String content;
    private boolean isReceived;

    public BankMessage(String date, String content, boolean isReceived) {
        this.date = date;
        this.content = content;
        this.isReceived = isReceived;
    }

    @Override
    public int compareTo(BankMessage other) {
        return this.getDate().compareTo(other.getDate());
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public boolean isReceived() {
        return isReceived;
    }
}




