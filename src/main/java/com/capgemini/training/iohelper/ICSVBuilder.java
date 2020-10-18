package com.capgemini.training.iohelper;

import java.io.Reader;
import java.util.List;

/**
 * CSV Builder interface.
 * @param <T>
 */
public interface ICSVBuilder<T> {
    /**
     * CSV Iterable of bean object.
     * @param reader
     * @param clazz
     * @return Iterable of bean object
     * @throws CSVBuilderException
     */
    Iterable<T> getCSVFileIterable(Reader reader, Class<T> clazz) throws CSVBuilderException;

    /**
     * List of bean objects.
     * @param reader
     * @param clazz
     * @return List
     * @throws CSVBuilderException
     */
    List<T> getLst(Reader reader, Class<T> clazz) throws CSVBuilderException;
}
