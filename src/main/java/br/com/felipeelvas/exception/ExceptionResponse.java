package br.com.felipeelvas.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
// This record is used to encapsulate the details of an exception response.


