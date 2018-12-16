package com.example.kakyunglee.boostcamp_ass;

import java.util.List;

public class NaverDTO {
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public List<MovieDTO> getList() {
        return items;
    }

    public void setList(List<MovieDTO> list) {
        this.items = list;
    }

    private int total;
    private int start;
    private int display;
    private List<MovieDTO> items;
}
