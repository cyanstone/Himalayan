package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/11.
 */
public class DicoveryColumnsList {
    private int id;
    private int orderNum;
    private String title;
    private String subtitle;
    private String coverPath;
    private String contentType;
    private String url;
    private String sharePic;
    private boolean enableShare;
    private boolean isExternalUrl;
    private int contentUpdatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSharePic() {
        return sharePic;
    }

    public void setSharePic(String sharePic) {
        this.sharePic = sharePic;
    }

    public boolean isEnableShare() {
        return enableShare;
    }

    public void setEnableShare(boolean enableShare) {
        this.enableShare = enableShare;
    }

    public boolean isExternalUrl() {
        return isExternalUrl;
    }

    public void setIsExternalUrl(boolean isExternalUrl) {
        this.isExternalUrl = isExternalUrl;
    }

    public int getContentUpdatedAt() {
        return contentUpdatedAt;
    }

    public void setContentUpdatedAt(int contentUpdatedAt) {
        this.contentUpdatedAt = contentUpdatedAt;
    }
}
