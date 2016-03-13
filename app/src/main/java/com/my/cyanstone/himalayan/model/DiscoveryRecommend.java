package com.my.cyanstone.himalayan.model;

/**
 * Created by 95199 on 2016/3/11.
 */
public class DiscoveryRecommend {
    private Entrances entrances;
    private int ret;
    private DicoveryColumns discoveryColumns;
    private EditorRecommendAlbums editorRecommendAlbums;
    private HotRecommends hotRecommends;
    private FocusImages focusImages;
    private BulletArea bulletArea;
    private String msg;
    private SpecialColumn specialColumn;

    public Entrances getEntrances() {
        return entrances;
    }

    public void setEntrances(Entrances entrances) {
        this.entrances = entrances;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public DicoveryColumns getDiscoveryColumns() {
        return discoveryColumns;
    }

    public void setDiscoveryColumns(DicoveryColumns discoveryColumns) {
        this.discoveryColumns = discoveryColumns;
    }

    public EditorRecommendAlbums getEditorRecommendAlbums() {
        return editorRecommendAlbums;
    }

    public void setEditorRecommendAlbums(EditorRecommendAlbums editorRecommendAlbums) {
        this.editorRecommendAlbums = editorRecommendAlbums;
    }

    public HotRecommends getHotRecommends() {
        return hotRecommends;
    }

    public void setHotRecommends(HotRecommends hotRecommends) {
        this.hotRecommends = hotRecommends;
    }

    public FocusImages getFocusImages() {
        return focusImages;
    }

    public void setFocusImages(FocusImages focusImages) {
        this.focusImages = focusImages;
    }

    public BulletArea getBulletArea() {
        return bulletArea;
    }

    public void setBulletArea(BulletArea bulletArea) {
        this.bulletArea = bulletArea;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SpecialColumn getSpecialColumn() {
        return specialColumn;
    }

    public void setSpecialColumn(SpecialColumn specialColumn) {
        this.specialColumn = specialColumn;
    }
}
