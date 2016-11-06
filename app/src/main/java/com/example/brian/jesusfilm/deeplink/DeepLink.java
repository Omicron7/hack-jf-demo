package com.example.brian.jesusfilm.deeplink;

import android.net.Uri;

public class DeepLink {
    private final String baseUrl = "https://hack-click-server.herokuapp.com/deeplink/";
    private final String appId;
    private final String deviceId;

    public static class Builder<T extends Builder> {

        private String appId;
        private String deviceId;

        public Builder(String deviceId) {
            this.deviceId = deviceId;
        }

        public T appId(String val) {
            appId = val;
            return (T) this;
        }

        public DeepLink build() {
            return new DeepLink(this);
        }
    }

    protected DeepLink(Builder builder) {
        deviceId = builder.deviceId;
        appId = builder.appId;
    }

    public DeepLink(Uri link) {
        appId = link.getPathSegments().get(1);
        deviceId = null;
    }

    public Uri deeplink() {
        return Uri.parse(baseUrl)
                .buildUpon()
                .appendPath(appId)
                .appendQueryParameter("device_id", deviceId)
                .appendQueryParameter("platform", "android")
                .build();
    }
}