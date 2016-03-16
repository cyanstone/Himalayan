package com.my.cyanstone.himalayan.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 95199 on 2016/3/11.
 */
public class DiscoveryColumnsList implements Parcelable {
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
    private DiscoveryAlbumProperties properties;

    protected DiscoveryColumnsList(Parcel in) {
        id = in.readInt();
        orderNum = in.readInt();
        title = in.readString();
        subtitle = in.readString();
        coverPath = in.readString();
        contentType = in.readString();
        url = in.readString();
        sharePic = in.readString();
        enableShare = in.readByte() != 0;
        isExternalUrl = in.readByte() != 0;
        contentUpdatedAt = in.readInt();
    }

    public static final Creator<DiscoveryColumnsList> CREATOR = new Creator<DiscoveryColumnsList>() {
        @Override
        public DiscoveryColumnsList createFromParcel(Parcel in) {
            return new DiscoveryColumnsList(in);
        }

        @Override
        public DiscoveryColumnsList[] newArray(int size) {
            return new DiscoveryColumnsList[size];
        }
    };

    public DiscoveryAlbumProperties getProperties() {
        return properties;
    }

    public void setProperties(DiscoveryAlbumProperties properties) {
        this.properties = properties;
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(orderNum);
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(coverPath);
        dest.writeString(contentType);
        dest.writeString(url);
        dest.writeString(sharePic);
        dest.writeByte((byte) (enableShare ? 1 : 0));
        dest.writeByte((byte) (isExternalUrl ? 1 : 0));
        dest.writeInt(contentUpdatedAt);
    }
}
