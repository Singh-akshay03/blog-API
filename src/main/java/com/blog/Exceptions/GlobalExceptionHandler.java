package com.blog.Exceptions;
import com.blog.DTOs.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(UserNotFoundException userNotFoundException){
        String message=userNotFoundException.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> categoryNotFoundExceptionHandler(CategoryNotFoundException categoryNotFoundException){
        String message=categoryNotFoundException.getMessage();
        return new ResponseEntity<String>(message, NOT_FOUND);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<String> postNotFoundExceptionHandler(PostNotFoundException postNotFoundException){
        String message=postNotFoundException.getMessage();
        return new ResponseEntity<>(message, NOT_FOUND);
    }
}
