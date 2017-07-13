package jpmjtt.util;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import jpmjtt.model.Instruction;
import jpmjtt.model.InstructionType;
import jpmjtt.reporting.DailyRanking;

/**
 * @author Serhan
 *
 */
public class SettlementCalculator {

	public static Map<LocalDate, BigDecimal> calculateDailyIncomingSettlements(List<Instruction> instructions){
		return calculateDailySettlements(instructions.stream().filter(instruction -> instruction.getType().equals(InstructionType.SELL)).collect(Collectors.toList()));
	}
	
	public static Map<LocalDate, BigDecimal> calculateDailyOutgoingSettlements(List<Instruction> instructions){
		return calculateDailySettlements(instructions.stream().filter(instruction -> instruction.getType().equals(InstructionType.BUY)).collect(Collectors.toList()));
	}
	
	private static Map<LocalDate, BigDecimal> calculateDailySettlements(List<Instruction> instructions){
		Map<LocalDate, BigDecimal> dailyIncomingSettlements = new HashMap<LocalDate, BigDecimal>();
		/*
		 	instructions.stream().forEach(
				instruction ->{
					BigDecimal sum = dailyIncomingSettlements.get(instruction.getSettlementDate());
					if(sum == null){
						sum = instruction.getAmountInUSD();
					}else {
						sum.add(instruction.getAmountInUSD());
						dailyIncomingSettlements.remove(instruction.getSettlementDate());
					}
					dailyIncomingSettlements.put(instruction.getSettlementDate(), sum);
				});
				*/
		dailyIncomingSettlements = 
				instructions.stream()
					.collect(groupingBy(Instruction::getSettlementDate,
							mapping(Instruction::getAmountInUSD,
							reducing(BigDecimal.ZERO, BigDecimal::add))));
		return dailyIncomingSettlements;
	}
	
	public static HashMap<LocalDate,List<DailyRanking>> calculateDailyIncomingRanking(List<Instruction> instructions){
		return calculateDailyRankings(instructions.stream().filter(instruction -> instruction.getType().equals(InstructionType.SELL)).collect(Collectors.toList()));
	}
	
	public static HashMap<LocalDate,List<DailyRanking>> calculateDailyOutgoingRanking(List<Instruction> instructions){
		return calculateDailyRankings(instructions.stream().filter(instruction -> instruction.getType().equals(InstructionType.BUY)).collect(Collectors.toList()));
	}

	private static HashMap<LocalDate,List<DailyRanking>> calculateDailyRankings(List<Instruction> instructions) {
		HashMap<LocalDate,List<DailyRanking>> dailyRankings = new HashMap<LocalDate,List<DailyRanking>>();
		
		instructions.stream().collect(groupingBy(Instruction::getSettlementDate)).forEach(
				(date,instructionlist) -> {
					List<DailyRanking> rankingsForOneDay = new ArrayList<DailyRanking>();
					instructionlist.stream().sorted((i1,i2)->i1.getAmountInUSD().compareTo(i2.getAmountInUSD())).collect(Collectors.toList()).forEach(
							instruction -> {
								DailyRanking ranking = new DailyRanking();
								ranking.setEntityName(instruction.getEntity());
								ranking.setRank(rankingsForOneDay.size()+1);
								ranking.setSettlementDate(date);
								rankingsForOneDay.add(ranking);
							});
					dailyRankings.put(date, rankingsForOneDay);
				});;	
		
		return dailyRankings;
	}
}
