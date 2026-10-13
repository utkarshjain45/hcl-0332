package com.hcl.library.exception;

public class BorrowLimitExceededException extends RuntimeException {
    public BorrowLimitExceededException(String message) {
        super(message);
    }
}
