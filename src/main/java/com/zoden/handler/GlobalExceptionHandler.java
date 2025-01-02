package com.zoden.handler;


import com.zoden.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiError<?>> handleBaseException(BaseException e, WebRequest webRequest) {
        return ResponseEntity.badRequest().body(createApiError(e.getMessage(), webRequest));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError<Map<String, List<String>>>> MethodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest webRequest) {
        Map<String, List<String>> map = new HashMap<>();

        for(ObjectError objectError : e.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError) objectError).getField();

            if (map.containsKey(fieldName)) {
                map.put(fieldName, addValue(map.get(fieldName), objectError.getDefaultMessage()));
            } else {
                map.put(fieldName, addValue(new ArrayList<>(), objectError.getDefaultMessage()));
            }
        }

        return ResponseEntity.badRequest().body(createApiError(map, webRequest));
    }

    public List<String> addValue(List<String> list, String newField) {
        list.add(newField);
        return list;
    }

    public String getHostName(){
        try {
            return Inet4Address.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }

    public <T> ApiError<T> createApiError(T message, WebRequest webRequest) {
        ApiError<T> apiError = new ApiError<>();
        Exception<T> exception = new Exception<>();

        apiError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        exception.setPath(webRequest.getDescription(false).substring(4));
        exception.setMessage(message);
        exception.setCreatedAt(new Date());
        exception.setHostName(getHostName());

        apiError.setException(exception);

        return apiError;
    }
}