package jpmjtt.reporting;

import java.time.LocalDate;

/**
 * @author Serhan
 *
 */
public class DailyRanking {
	private LocalDate settlementDate;
	private String entityName;
	private int rank;
	/**
	 * @return the settlementDate
	 */
	public LocalDate getSettlementDate() {
		return settlementDate;
	}
	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	/**
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}
	/**
	 * @param rank the rank to set
	 */
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return settlementDate.toString() + "\t" + entityName + "\t\t" + rank;
	}
}
