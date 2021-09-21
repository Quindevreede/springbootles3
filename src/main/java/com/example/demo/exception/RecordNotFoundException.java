package com.example.demo.exception;

public class RecordNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(String message) {
        super(message);
    }
    public RecordNotFoundException() {
        super("Record not found.");
    }
/*
Hier hebben we een een super message geinstantieerd
zodat als het {NR} niet gevonden kan worden wij zelf de "message" bij de foutmelding
voor de gebruiker kunnen bepalen.
 */
}