package com.zgf.likemeituandianpupage.recycler;


import java.util.List;

public class DataModel {

    public static final int TYPE_TITLE = 0;
    public static final int TYPE_ITEM = 1;

    private int type;
    private String title;
    private List<Item> item;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public static class Item {
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}
