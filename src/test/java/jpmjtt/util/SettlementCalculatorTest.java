package jpmjtt.util;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import jpmjtt.executor.SampleClientInstructions;
import jpmjtt.model.Instruction;
import jpmjtt.reporting.DailyRanking;

public class SettlementCalculatorTest {

	List<Instruction> sampleInstructions;
	Map<LocalDate, BigDecimal> incomingSettlements;
	Map<LocalDate, BigDecimal> outgoingSettlements;
	Map<LocalDate,List<DailyRanking>> dailyIncomingRankings;
	Map<LocalDate,List<DailyRanking>> dailyOutgoingRankings;
	
	@Before
	public void initializeTestEnvironment() {
		sampleInstructions = SampleClientInstructions.getSampleInstructions();
		sampleInstructions.stream().forEach(instruction->SettlementDateUtil.adjustSettlementDate(instruction));
		incomingSettlements =  SettlementCalculator.calculateDailyIncomingSettlements(sampleInstructions);
		dailyIncomingRankings = SettlementCalculator.calculateDailyIncomingRanking(sampleInstructions);
		outgoingSettlements =  SettlementCalculator.calculateDailyOutgoingSettlements(sampleInstructions);
		dailyOutgoingRankings = SettlementCalculator.calculateDailyOutgoingRanking(sampleInstructions);
	}
	
	@Test
	public void dailyIncomingAmountShouldBeCorrect() {
		assertEquals("Daily incoming amount on 2017-07-10 should be 6196.50", new BigDecimal("6196.50"), incomingSettlements.get(LocalDate.of(2017, 7, 10)));
		assertEquals("Daily incoming amount on 2017-07-16 should be 13250.25", new BigDecimal("13250.25"), incomingSettlements.get(LocalDate.of(2017, 7, 16)));
	}
	
	@Test
	public void dailyOutgoingAmountShouldBeCorrect() {
		assertEquals("Daily outgoing amount on 2017-07-09 should be 4063.50", new BigDecimal("4063.50"), outgoingSettlements.get(LocalDate.of(2017, 7, 9)));
		assertEquals("Daily outgoing amount on 2017-07-14 should be 16971.75", new BigDecimal("16971.75"), outgoingSettlements.get(LocalDate.of(2017, 7, 14)));
	}
	
	@Test
	public void dailyIncomingRankShouldBeCorrect() {
		assertEquals("Daily incoming rank of Entity2 on 2017-07-12 should be 2", "Entity2", dailyIncomingRankings.get(LocalDate.of(2017, 7, 12)).get(1).getEntityName());
	}
	
	@Test
	public void dailyOutgoingRankShouldBeCorrect() {
		assertEquals("Daily incoming rank of Entity3 on 2017-07-12 should be 1", "Entity3", dailyOutgoingRankings.get(LocalDate.of(2017, 7, 12)).get(0).getEntityName());
	}
}
