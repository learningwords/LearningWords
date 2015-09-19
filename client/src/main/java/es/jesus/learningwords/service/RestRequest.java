package es.jesus.learningwords.service;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * Created by jesus on 11/09/15.
 */
public class RestRequest<T> {
    private String path;
    private T parameter;
    private MediaType mediaType;
    private GenericType<T> genericType;
    //public Class<T> responseType;

    public RestRequest(String path, MediaType mediaType, T parameter) {
        this.path = path;
        this.parameter = parameter;
        this.mediaType = mediaType;
    }

    public RestRequest(String path, MediaType mediaType, GenericType<T> genericType) {
        this.path = path;
        this.mediaType = mediaType;
        this.genericType = genericType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public T getParameter() {
        return parameter;
    }

    public void setParameter(T parameter) {
        this.parameter = parameter;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public GenericType<T> getGenericType() {
        return genericType;
    }

    public void setGenericType(GenericType<T> genericType) {
        this.genericType = genericType;
    }
}
