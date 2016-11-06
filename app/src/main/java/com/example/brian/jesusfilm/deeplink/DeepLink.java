package com.example.brian.jesusfilm.deeplink;

import android.net.Uri;

import com.example.brian.jesusfilm.BuildConfig;

public class DeepLink {
    private final String baseUrl = "https://hack-click-server.herokuapp.com/deeplink/"; //BuildConfig.DEEP_LINK_URL;
    private final String appId;

    public static class Builder<T extends Builder> {

        private String appId;

        public Builder() {}

        public T appId(String val) {
            appId = val;
            return (T) this;
        }

        public DeepLink build() {
            return new DeepLink(this);
        }
    }

    protected DeepLink(Builder builder) {
        appId = builder.appId;
    }

    public Uri deeplink() {
        return Uri.parse(baseUrl).buildUpon().appendPath(appId).build();
    }
}