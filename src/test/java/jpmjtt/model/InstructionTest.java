package jpmjtt.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import org.junit.Test;

public class InstructionTest {

	@Test
	public void instructionShouldCalculateAmountInUsdCorrect() {
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
		
		assertEquals("150.5 x 100 x 0.27 should be 4063.50", new BigDecimal("4063.50"), testInstance.getAmountInUSD());
	}
}
