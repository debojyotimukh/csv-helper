package com.capgemini.training.iohelper;

import java.io.Reader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.Iterator;
import java.util.List;

/**
 * CSV builder using open csv library.
 * 
 * @param <T>
 */
public class OpenCSVBuilder<T> implements ICSVBuilder<T> {

    public OpenCSVBuilder() {
    }

    @Override
    public Iterable<T> getCSVFileIterable(final Reader reader, final Class<T> clazz) throws CSVBuilderException {
        try {
            final CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).withSeparator(',').withThrowExceptions(true)
                    .withType(clazz).build();
            final Iterator<T> iterator = csvToBean.iterator();
            final Iterable<T> csvIterable = () -> iterator;

            return csvIterable;

        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage());
        }
    }

    @Override
    public List<T> getLst(final Reader reader, final Class<T> clazz) throws CSVBuilderException {
        try {
            final CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(reader).withSeparator(',').withThrowExceptions(true)
                    .withType(clazz).build();

            return csvToBean.parse();

        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage());
        }
    }

}
