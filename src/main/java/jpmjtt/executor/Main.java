/**
 * 
 */
package jpmjtt.executor;

import java.util.List;

import jpmjtt.model.Instruction;
import jpmjtt.reporting.ReportGenerator;
import jpmjtt.util.SettlementDateUtil;

/**
 * @author Serhan
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Instruction> sampleInstructions = SampleClientInstructions.getSampleInstructions();
		sampleInstructions.stream().forEach(instruction->SettlementDateUtil.adjustSettlementDate(instruction));
		ReportGenerator.generateDailySettlementsReport(sampleInstructions);
		//sampleInstructions.stream().sorted((i1,i2)->i1.getSettlementDate().compareTo(i2.getSettlementDate())).forEach(i->System.out.println(i));
	}

}

