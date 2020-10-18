package com.capgemini.training.iohelper;

/**
 * Utility class for CSV helper library.
 * @param <T>
 */
public final class CSVBuilderFactory<T> {

    private CSVBuilderFactory() {
    }

    /**
     * Factory method to create CSV builder.
     * @param <T>
     * @return generic CSV builder
     */
    public static <T> ICSVBuilder<T> createCSVBuilder() {
        return new OpenCSVBuilder<>();
    }

}
