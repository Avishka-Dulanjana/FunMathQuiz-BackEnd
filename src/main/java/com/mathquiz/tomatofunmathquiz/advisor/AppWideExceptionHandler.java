package com.mathquiz.tomatofunmathquiz.advisor;

import com.mathquiz.tomatofunmathquiz.exception.EntryDuplicationException;
import com.mathquiz.tomatofunmathquiz.exception.EntryNotFoundException;
import com.mathquiz.tomatofunmathquiz.exception.NotFoundException;
import com.mathquiz.tomatofunmathquiz.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"Not Found!",e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<StandardResponse> handleEntryNotFoundException(EntryNotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Entry Not Found!", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
    @ExceptionHandler(EntryDuplicationException.class)
    public ResponseEntity<StandardResponse> handleDuplicatedFileException(EntryDuplicationException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Duplicated File Reported!", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}
