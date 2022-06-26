package com.nitinson.urlshortener.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Redirect {

    @Id
    @GeneratedValue
    private Long id;

    @NaturalId
    @Column(unique = true, nullable = false)
    private String alias;

    @Column(nullable = false)
    private String url;

    public Redirect() {
    }

    public Redirect(String alias, String url) {
        this.alias = alias;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
