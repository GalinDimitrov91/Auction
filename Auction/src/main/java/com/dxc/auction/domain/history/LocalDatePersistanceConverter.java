package com.dxc.auction.domain.history;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This class convert from java local date to sql.
 * @author YVasilev
 *
 */
@Converter(autoApply = true)
public class LocalDatePersistanceConverter implements
    AttributeConverter<LocalDate, Date> {
	
	/**
	 * Empty constructor.
	 */
	public LocalDatePersistanceConverter() {
		// The solution for quality code
	}
	
    /**
     * Convert from Date to LocalDate.
     */
    @Override
    public Date convertToDatabaseColumn(final LocalDate entityValue) {
        return Date.valueOf(entityValue);
    }

    /**
     * Convert from LocalDate to Date.
     */
    @Override
    public LocalDate convertToEntityAttribute(final Date databaseValue) {
        return databaseValue.toLocalDate();
    }
}
