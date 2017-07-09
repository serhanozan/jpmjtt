package jpmjtt.executor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import jpmjtt.model.Instruction;
import jpmjtt.model.InstructionType;

public class SampleClientInstructions {
	public static List<Instruction> getSampleInstructions(){
		List<Instruction> sampleInstructions = new ArrayList<Instruction>();

		sampleInstructions.add(
				new Instruction(
						"Entity1", 
						InstructionType.BUY, 
						BigDecimal.valueOf(0.27), 
						Currency.getInstance("AED"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 9),
						100, 
						BigDecimal.valueOf(150.5)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity2", 
						InstructionType.BUY, 
						BigDecimal.valueOf(1.14), 
						Currency.getInstance("EUR"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 9),
						150, 
						BigDecimal.valueOf(90.25)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity3", 
						InstructionType.SELL, 
						BigDecimal.valueOf(0.26), 
						Currency.getInstance("SAR"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 9),
						250, 
						BigDecimal.valueOf(65.35)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity4", 
						InstructionType.SELL, 
						BigDecimal.valueOf(0.27), 
						Currency.getInstance("TRY"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 9),
						300, 
						BigDecimal.valueOf(76.5)
						)
				);
	
		sampleInstructions.add(
				new Instruction(
						"Entity1", 
						InstructionType.SELL, 
						BigDecimal.valueOf(0.27), 
						Currency.getInstance("AED"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 12),
						200, 
						BigDecimal.valueOf(33.25)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity2", 
						InstructionType.SELL, 
						BigDecimal.valueOf(1.14), 
						Currency.getInstance("EUR"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 12),
						350, 
						BigDecimal.valueOf(111.25)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity3", 
						InstructionType.BUY, 
						BigDecimal.valueOf(0.26), 
						Currency.getInstance("SAR"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 12),
						450, 
						BigDecimal.valueOf(120.75)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity4", 
						InstructionType.BUY, 
						BigDecimal.valueOf(0.27), 
						Currency.getInstance("TRY"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 12),
						500, 
						BigDecimal.valueOf(200.25)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity1", 
						InstructionType.BUY, 
						BigDecimal.valueOf(0.27), 
						Currency.getInstance("AED"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 14),
						200, 
						BigDecimal.valueOf(66.75)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity2", 
						InstructionType.BUY, 
						BigDecimal.valueOf(1.14), 
						Currency.getInstance("EUR"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 14),
						150, 
						BigDecimal.valueOf(99.25)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity3", 
						InstructionType.SELL, 
						BigDecimal.valueOf(0.26), 
						Currency.getInstance("SAR"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 14),
						450, 
						BigDecimal.valueOf(113.25)
						)
				);
		
		sampleInstructions.add(
				new Instruction(
						"Entity4", 
						InstructionType.SELL, 
						BigDecimal.valueOf(0.27), 
						Currency.getInstance("TRY"),
						LocalDate.of(2017, 7, 9),
						LocalDate.of(2017, 7, 14),
						300, 
						BigDecimal.valueOf(45.65)
						)
				);
		
		return sampleInstructions;
	}
}
