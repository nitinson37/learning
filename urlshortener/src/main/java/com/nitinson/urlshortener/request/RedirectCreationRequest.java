package com.nitinson.urlshortener.request;

import javax.validation.constraints.NotNull;

public class RedirectCreationRequest {

    private String alias;

    @NotNull
    private String url;

    public RedirectCreationRequest(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
