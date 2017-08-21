package com.trevorism.domain

/**
 * @author tbrooks
 */
class Service {
    long id
    String name
    String gitUrl
    String host

    String url
    String dns


    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gitUrl='" + gitUrl + '\'' +
                ", host='" + host + '\'' +
                ", url='" + url + '\'' +
                ", dns='" + dns + '\'' +
                '}';
    }
}
