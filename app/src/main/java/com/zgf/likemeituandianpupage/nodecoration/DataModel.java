package com.zgf.likemeituandianpupage.nodecoration;



public class DataModel {

    public static final int TYPE_TITLE = 0;
    public static final int TYPE_ITEM = 1;

    private int type;
    private Title title;
    private Item item;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public static class Title {
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
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
