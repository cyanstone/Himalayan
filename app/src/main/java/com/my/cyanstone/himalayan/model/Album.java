package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/19.
 */
public class Album {
    private long albumId;
    private int categoryId;
    private String categoryName;
    private String title;
    private String coverOrigin;
    private  String coverSmall;
    private String coverMiddle;
    private String coverLarge;
    private String coverWebLarge;
    private long  createdAt;
    private long updatedAt;
    private long uid;
    private String nickname;
    private boolean isVerified;
    private String avatarPath;
    private int zoneId;
    private String intro;
    private String introRich;
    private String tags;
    private int tracks;
    private int shares;
    private boolean hasNew;
    private boolean isFavorite;
    private long playTimes;
    private int status;
    private int serializeStatus;
    private int serialState;
    private long playTrackId;
    private boolean autoStart;
    private boolean isRecordDesc;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverOrigin() {
        return coverOrigin;
    }

    public void setCoverOrigin(String coverOrigin) {
        this.coverOrigin = coverOrigin;
    }

    public String getCoverSmall() {
        return coverSmall;
    }

    public void setCoverSmall(String coverSmall) {
        this.coverSmall = coverSmall;
    }

    public String getCoverMiddle() {
        return coverMiddle;
    }

    public void setCoverMiddle(String coverMiddle) {
        this.coverMiddle = coverMiddle;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public String getCoverWebLarge() {
        return coverWebLarge;
    }

    public void setCoverWebLarge(String coverWebLarge) {
        this.coverWebLarge = coverWebLarge;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntroRich() {
        return introRich;
    }

    public void setIntroRich(String introRich) {
        this.introRich = introRich;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public boolean isHasNew() {
        return hasNew;
    }

    public void setHasNew(boolean hasNew) {
        this.hasNew = hasNew;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public long getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(long playTimes) {
        this.playTimes = playTimes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSerializeStatus() {
        return serializeStatus;
    }

    public void setSerializeStatus(int serializeStatus) {
        this.serializeStatus = serializeStatus;
    }

    public int getSerialState() {
        return serialState;
    }

    public void setSerialState(int serialState) {
        this.serialState = serialState;
    }

    public long getPlayTrackId() {
        return playTrackId;
    }

    public void setPlayTrackId(long playTrackId) {
        this.playTrackId = playTrackId;
    }

    public boolean isAutoStart() {
        return autoStart;
    }

    public void setAutoStart(boolean autoStart) {
        this.autoStart = autoStart;
    }

    public boolean isRecordDesc() {
        return isRecordDesc;
    }

    public void setIsRecordDesc(boolean isRecordDesc) {
        this.isRecordDesc = isRecordDesc;
    }
}
