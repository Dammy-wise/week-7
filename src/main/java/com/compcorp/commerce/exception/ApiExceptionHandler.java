package com.compcorp.commerce.exception;
import jakarta.servlet.http.HttpServletRequest;import org.springframework.http.*;import org.springframework.web.bind.MethodArgumentNotValidException;import org.springframework.web.bind.annotation.*;import java.time.Instant;import java.util.*;
@RestControllerAdvice public class ApiExceptionHandler{
 public record ApiError(Instant timestamp,int status,String code,String message,String path,Map<String,String> fieldErrors){}
 @ExceptionHandler(NotFoundException.class) ResponseEntity<ApiError> notFound(NotFoundException e,HttpServletRequest r){return build(HttpStatus.NOT_FOUND,"NOT_FOUND",e.getMessage(),r,Map.of());}
 @ExceptionHandler({ConflictException.class,InsufficientStockException.class}) ResponseEntity<ApiError> conflict(RuntimeException e,HttpServletRequest r){return build(HttpStatus.CONFLICT,"BUSINESS_RULE_VIOLATION",e.getMessage(),r,Map.of());}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<ApiError> invalid(MethodArgumentNotValidException e,HttpServletRequest r){Map<String,String> f=new TreeMap<>();e.getBindingResult().getFieldErrors().forEach(x->f.put(x.getField(),x.getDefaultMessage()));return build(HttpStatus.BAD_REQUEST,"VALIDATION_ERROR","Request validation failed",r,f);}
 @ExceptionHandler(Exception.class) ResponseEntity<ApiError> unexpected(Exception e,HttpServletRequest r){return build(HttpStatus.INTERNAL_SERVER_ERROR,"INTERNAL_ERROR","An unexpected error occurred",r,Map.of());}
 private ResponseEntity<ApiError> build(HttpStatus s,String c,String m,HttpServletRequest r,Map<String,String> f){return ResponseEntity.status(s).body(new ApiError(Instant.now(),s.value(),c,m,r.getRequestURI(),f));}
}
