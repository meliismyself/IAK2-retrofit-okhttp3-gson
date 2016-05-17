package com.meliismyself.cobakejar2.api.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Meli Oktavia on 4/30/2016.
 */
public class WeatherItem {
    @SerializedName("id")
    private int id;

    @SerializedName("main")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
