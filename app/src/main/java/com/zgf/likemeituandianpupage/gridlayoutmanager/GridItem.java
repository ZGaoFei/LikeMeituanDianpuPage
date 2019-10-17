package com.zgf.likemeituandianpupage.gridlayoutmanager;

public class GridItem {
    public static final int ITEM_TYPE_SMALL = 0;
    public static final int ITEM_TYPE_NORMAL = 1;
    public static final int ITEM_TYPE_BIG = 2;

    private int type;
    private int spanSize;
    private String title;

    public GridItem(int spanSize, String title) {
        this.spanSize = spanSize;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
