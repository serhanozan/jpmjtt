package jpmjtt.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import org.junit.Test;

import jpmjtt.model.Instruction;
import jpmjtt.model.InstructionType;

public class SettlementDateUtilTest {

	@Test
	public void shouldFindNextSundayForAED() {
		Instruction testInstance = new Instruction(
				"Entity1", 
				InstructionType.BUY, 
				BigDecimal.valueOf(0.27), 
				Currency.getInstance("AED"),
				LocalDate.of(2017, 7, 9),
				LocalDate.of(2017, 7, 14),
				100, 
				BigDecimal.valueOf(150.5)
				);
		
		SettlementDateUtil.adjustSettlementDate(testInstance);
		
		assertEquals("14/7/2017 should change to 16/7/2017", LocalDate.of(2017, 7, 16), testInstance.getSettlementDate());
	}
	
	@Test
	public void shouldBeTheSameForAED() {
		Instruction testInstance = new Instruction(
				"Entity1", 
				InstructionType.BUY, 
				BigDecimal.valueOf(0.27), 
				Currency.getInstance("AED"),
				LocalDate.of(2017, 7, 9),
				LocalDate.of(2017, 7, 9),
				100, 
				BigDecimal.valueOf(150.5)
				);
		
		SettlementDateUtil.adjustSettlementDate(testInstance);
		
		assertEquals("9/7/2017 should not change", LocalDate.of(2017, 7, 9), testInstance.getSettlementDate());
	}
	
	@Test
	public void shouldFindNextSundayForSAR() {
		Instruction testInstance = new Instruction(
				"Entity1", 
				InstructionType.BUY, 
				BigDecimal.valueOf(0.27), 
				Currency.getInstance("SAR"),
				LocalDate.of(2017, 7, 9),
				LocalDate.of(2017, 7, 14),
				100, 
				BigDecimal.valueOf(150.5)
				);
		
		SettlementDateUtil.adjustSettlementDate(testInstance);
		
		assertEquals("14/7/2017 should change to 16/7/2017", LocalDate.of(2017, 7, 16), testInstance.getSettlementDate());
	}
	
	@Test
	public void shouldBeTheSameForSAR() {
		Instruction testInstance = new Instruction(
				"Entity1", 
				InstructionType.BUY, 
				BigDecimal.valueOf(0.27), 
				Currency.getInstance("SAR"),
				LocalDate.of(2017, 7, 9),
				LocalDate.of(2017, 7, 9),
				100, 
				BigDecimal.valueOf(150.5)
				);
		
		SettlementDateUtil.adjustSettlementDate(testInstance);
		
		assertEquals("9/7/2017 should not change", LocalDate.of(2017, 7, 9), testInstance.getSettlementDate());
	}
	
	@Test
	public void shouldFindNextMondayForTRY() {
		Instruction testInstance = new Instruction(
				"Entity1", 
				InstructionType.BUY, 
				BigDecimal.valueOf(0.27), 
				Currency.getInstance("TRY"),
				LocalDate.of(2017, 7, 9),
				LocalDate.of(2017, 7, 9),
				100, 
				BigDecimal.valueOf(150.5)
				);
		
		SettlementDateUtil.adjustSettlementDate(testInstance);
		
		assertEquals("9/7/2017 should change to 10/7/2017", LocalDate.of(2017, 7, 10), testInstance.getSettlementDate());
	}
	
	@Test
	public void shouldBeTheSameForTRY() {
		Instruction testInstance = new Instruction(
				"Entity1", 
				InstructionType.BUY, 
				BigDecimal.valueOf(0.27), 
				Currency.getInstance("TRY"),
				LocalDate.of(2017, 7, 9),
				LocalDate.of(2017, 7, 14),
				100, 
				BigDecimal.valueOf(150.5)
				);
		
		SettlementDateUtil.adjustSettlementDate(testInstance);
		
		assertEquals("14/7/2017 should not change", LocalDate.of(2017, 7, 14), testInstance.getSettlementDate());
	}
}
