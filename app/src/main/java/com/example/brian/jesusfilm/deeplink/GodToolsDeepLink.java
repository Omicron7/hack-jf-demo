package com.example.brian.jesusfilm.deeplink;

import android.net.Uri;

public class GodToolsDeepLink extends DeepLink {

    private final String resource;
    private final String language;
    private final int page;

    public static class Builder extends DeepLink.Builder<Builder> {
        private String resource = "kgp";
        private String language = "en";
        private int page = 1;

        public Builder() {
            this.appId("org.cru.godtools");
        }

        public Builder resource(String val) {
            resource = val;
            return this;
        }

        public Builder language(String val) {
            language = val;
            return this;
        }

        public Builder page(int val) {
            page = val;
            return this;
        }

        public GodToolsDeepLink build() {
            return new GodToolsDeepLink(this);
        }
    }

    protected GodToolsDeepLink(Builder builder) {
        super(builder);
        resource = builder.resource;
        language = builder.language;
        page = builder.page;
    }

    public Uri deeplink() {
        return super.deeplink().buildUpon().appendPath(language).appendPath(resource).appendPath(Integer.toString(page)).build();
    }
}