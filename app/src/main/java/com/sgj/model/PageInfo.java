package com.sgj.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by John on 2016/8/8.
 */
public class PageInfo implements Serializable, Parcelable {

    private int catalogId;
    private int id;
    private boolean isOffline;
    private int is_jnpage;
    private String jn_enname;
    private int jn_id;
    private String jn_name;
    private String name;
    private int order;
    private String page_cover;
    private int page_id;
    private int position;
    private String url;

    public PageInfo() {
    }

    public PageInfo(int id, String url) {
        this.id = id;
        this.url = url;
    }

    protected PageInfo(Parcel in) {
        catalogId = in.readInt();
        id = in.readInt();
        isOffline = in.readByte() != 0;
        is_jnpage = in.readInt();
        jn_enname = in.readString();
        jn_id = in.readInt();
        jn_name = in.readString();
        name = in.readString();
        order = in.readInt();
        page_cover = in.readString();
        page_id = in.readInt();
        position = in.readInt();
        url = in.readString();
    }

    public static final Creator<PageInfo> CREATOR = new Creator<PageInfo>() {
        @Override
        public PageInfo createFromParcel(Parcel in) {
            return new PageInfo(in);
        }

        @Override
        public PageInfo[] newArray(int size) {
            return new PageInfo[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public int getCatalogId() {
        return this.catalogId;
    }

    public int getId() {
        return this.id;
    }

    public int getIs_jnpage() {
        return this.is_jnpage;
    }

    public String getJn_enname() {
        return this.jn_enname;
    }

    public int getJn_id() {
        return this.jn_id;
    }

    public String getJn_name() {
        return this.jn_name;
    }

    public String getName() {
        return this.name;
    }

    public int getOrder() {
        return this.order;
    }

    public String getPage_cover() {
        return this.page_cover;
    }

    public int getPage_id() {
        return this.page_id;
    }

    public int getPosition() {
        return this.position;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOffline() {
        return this.isOffline;
    }

    public void setCatalogId(int paramInt) {
        this.catalogId = paramInt;
    }

    public void setId(int paramInt) {
        this.id = paramInt;
    }

    public void setIs_jnpage(int paramInt) {
        this.is_jnpage = paramInt;
    }

    public void setJn_enname(String paramString) {
        this.jn_enname = paramString;
    }

    public void setJn_id(int paramInt) {
        this.jn_id = paramInt;
    }

    public void setJn_name(String paramString) {
        this.jn_name = paramString;
    }

    public void setName(String paramString) {
        this.name = paramString;
    }

    public void setOffline(boolean paramBoolean) {
        this.isOffline = paramBoolean;
    }

    public void setOrder(int paramInt) {
        this.order = paramInt;
    }

    public void setPage_cover(String paramString) {
        this.page_cover = paramString;
    }

    public void setPage_id(int paramInt) {
        this.page_id = paramInt;
    }

    public void setPosition(int paramInt) {
        this.position = paramInt;
    }

    public void setUrl(String paramString) {
        this.url = paramString;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        paramParcel.writeInt(this.id);
        paramParcel.writeInt(this.order);
        paramParcel.writeInt(this.page_id);
        paramParcel.writeInt(this.jn_id);
        paramParcel.writeString(this.page_cover);
        paramParcel.writeString(this.name);
        paramParcel.writeString(this.url);
        paramParcel.writeInt(this.is_jnpage);
        if (this.isOffline) ;
        for (byte b = 1; ; b = 0) {
            paramParcel.writeByte(b);
            paramParcel.writeString(this.jn_name);
            paramParcel.writeString(this.jn_enname);
            paramParcel.writeInt(this.position);
            paramParcel.writeInt(this.catalogId);
            return;
        }
    }
}