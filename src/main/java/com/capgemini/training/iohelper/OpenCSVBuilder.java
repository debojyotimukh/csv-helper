package com.capgemini.training.iohelper;

import java.io.Reader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import java.util.Iterator;
import java.util.List;

/**
 * CSV builder using open csv library.
 * @param <T>
 */
public class OpenCSVBuilder<T> implements ICSVBuilder<T> {

    public OpenCSVBuilder() {
    }

    @Override
    public Iterable<T> getCSVFileIterable(final Reader reader, final Class<T> clazz) throws CSVBuilderException {

        final CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).withSeparator(',').withThrowExceptions(true)
                .withType(clazz).build();
        final Iterator<T> iterator = csvToBean.iterator();
        final Iterable<T> csvIterable = () -> iterator;

        final List<CsvException> capturedExceptions = csvToBean.getCapturedExceptions();
        for (final Exception e : capturedExceptions) {
            throw new CSVBuilderException(e.getMessage());
        }

        return csvIterable;

    }

    @Override
    public List<T> getLst(final Reader reader, final Class<T> clazz) throws CSVBuilderException {

        final CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).withSeparator(',').withThrowExceptions(true)
                .withType(clazz).build();

        final List<CsvException> capturedExceptions = csvToBean.getCapturedExceptions();
        for (final Exception e : capturedExceptions) {
            throw new CSVBuilderException(e.getMessage());
        }

        return csvToBean.parse();

    }

}
