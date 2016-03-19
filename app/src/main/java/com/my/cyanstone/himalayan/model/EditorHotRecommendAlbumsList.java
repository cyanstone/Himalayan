package com.my.cyanstone.himalayan.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 95199 on 2016/3/11.
 */
public class EditorHotRecommendAlbumsList implements Parcelable{
    private long albumId;
    private String coverLarge;
    private String title;
    private String tags;
    private int tracks;
    private long playsCounts;
    private int isFinished;
    private int serialState;
    private long trackId;
    private String trackTitle;

    protected EditorHotRecommendAlbumsList(Parcel in) {
        albumId = in.readLong();
        coverLarge = in.readString();
        title = in.readString();
        tags = in.readString();
        tracks = in.readInt();
        playsCounts = in.readLong();
        isFinished = in.readInt();
        serialState = in.readInt();
        trackId = in.readLong();
        trackTitle = in.readString();
    }

    public static final Creator<EditorHotRecommendAlbumsList> CREATOR = new Creator<EditorHotRecommendAlbumsList>() {
        @Override
        public EditorHotRecommendAlbumsList createFromParcel(Parcel in) {
            return new EditorHotRecommendAlbumsList(in);
        }

        @Override
        public EditorHotRecommendAlbumsList[] newArray(int size) {
            return new EditorHotRecommendAlbumsList[size];
        }
    };

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getCoverLarge() {
        return coverLarge;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public long getPlaysCounts() {
        return playsCounts;
    }

    public void setPlaysCounts(long playsCounts) {
        this.playsCounts = playsCounts;
    }

    public int getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(int isFinished) {
        this.isFinished = isFinished;
    }

    public int getSerialState() {
        return serialState;
    }

    public void setSerialState(int serialState) {
        this.serialState = serialState;
    }

    public long getTrackId() {
        return trackId;
    }

    public void setTrackId(long trackId) {
        this.trackId = trackId;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(albumId);
        dest.writeString(coverLarge);
        dest.writeString(title);
        dest.writeString(tags);
        dest.writeInt(tracks);
        dest.writeLong(playsCounts);
        dest.writeInt(isFinished);
        dest.writeInt(serialState);
        dest.writeLong(trackId);
        dest.writeString(trackTitle);
    }
}
