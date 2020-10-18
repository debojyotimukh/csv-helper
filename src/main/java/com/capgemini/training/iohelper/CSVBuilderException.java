package com.capgemini.training.iohelper;

/**
 * Custom exception for CSV helper library.
 */
public class CSVBuilderException extends Exception {

    /**
     * Serial Version.
     */
    private static final long serialVersionUID = 924984927759794535L;

    public CSVBuilderException() {
    }

    public CSVBuilderException(String message) {
        super(message);
    }

}
