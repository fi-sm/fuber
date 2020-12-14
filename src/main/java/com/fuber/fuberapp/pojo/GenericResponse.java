package com.fuber.fuberapp.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GenericResponse<T> {
    private AppError appError;
    private T response;
    private HttpStatus status;

    public GenericResponse(){}

    public GenericResponse(AppError appError, HttpStatus status) {
        this.appError = appError;
        this.status = status;
    }

    public GenericResponse(T response, HttpStatus status) {
        this.response = response;
        this.status = status;
    }

    public AppError getAppError() {
        return appError;
    }

    public void setAppError(AppError appError) {
        this.appError = appError;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
