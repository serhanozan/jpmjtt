package jpmjtt.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Currency;

import jpmjtt.model.Instruction;

/**
 * @author Serhan
 *
 */
public class SettlementDateUtil {
	
	public static void adjustSettlementDate(Instruction instruction) {
		instruction.setSettlementDate(findFirstWorkingDay(instruction.getSettlementDate(), instruction.getCurrency()));
	}

	private static LocalDate findFirstWorkingDay(LocalDate date, Currency currency) {
		if(currency.equals(Currency.getInstance("AED")) || currency.equals(Currency.getInstance("SAR"))){
			if(date.getDayOfWeek().equals(DayOfWeek.FRIDAY) || date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
				return findFirstWorkingDay(date.plusDays(1), currency);
			}
		}else {
			if(date.getDayOfWeek().equals(DayOfWeek.SATURDAY) || date.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
				return findFirstWorkingDay(date.plusDays(1), currency);
			}
		}
		return date;
	}
}
