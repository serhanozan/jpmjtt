/**
 * 
 */
package jpmjtt.reporting;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import jpmjtt.model.Instruction;
import jpmjtt.util.SettlementCalculator;

/**
 * @author Serhan
 *
 */
public class ReportGenerator {

	public static void generateDailySettlementsReport(List<Instruction> instructions) {
		
		System.out.println("\tDAILY INCOMING SETTLEMENTS");
		System.out.println("Date" + "\t\t" + "Amount(USD)");
		
		HashMap<LocalDate, BigDecimal> incoming =  SettlementCalculator.calculateDailyIncomingSettlements(instructions);
		for (LocalDate date : incoming.keySet().stream().sorted().collect(Collectors.toList())) {
			System.out.println( date + "\t"  + incoming.get(date));
		}
		
		System.out.println("");
		
		System.out.println("\tDAILY INCOMING RANKINGS");
		System.out.println("Date" + "\t\t" + "Entity" + "\t\t" + "Rank");
		
		HashMap<LocalDate,List<DailyRanking>> dailyIncomingRankings = SettlementCalculator.calculateDailyIncomingRanking(instructions);
		for (LocalDate date : dailyIncomingRankings.keySet().stream().sorted().collect(Collectors.toList())) {
			for(DailyRanking ranking : dailyIncomingRankings.get(date)){
				 System.out.println(ranking);
			 }
		}
		
		System.out.println("");
		
		System.out.println("\tDAILY OUTGOING SETTLEMENTS");
		System.out.println("Date" + "\t\t" + "Amount(USD)");
		
		HashMap<LocalDate, BigDecimal> outgoing =  SettlementCalculator.calculateDailyOutgoingSettlements(instructions);
		for (LocalDate date : outgoing.keySet().stream().sorted().collect(Collectors.toList())) {
			System.out.println( date + "\t"  + outgoing.get(date));
		}
		
		System.out.println("");
		
		System.out.println("\tDAILY OUTGOING RANKINGS");
		System.out.println("Date" + "\t\t" + "Entity" + "\t\t" + "Rank");
		
		 HashMap<LocalDate,List<DailyRanking>> dailyOutgoingRankings = SettlementCalculator.calculateDailyOutgoingRanking(instructions);
		 for (LocalDate date : dailyIncomingRankings.keySet().stream().sorted().collect(Collectors.toList())) {
			 for(DailyRanking ranking : dailyOutgoingRankings.get(date)){
				 System.out.println(ranking);
			 }
		}
	}
}
