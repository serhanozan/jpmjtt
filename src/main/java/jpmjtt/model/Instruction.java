package jpmjtt.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Currency;

/**
 * @author Serhan
 *
 */
public class Instruction {

	private String entity;
	private InstructionType type;
	private BigDecimal agreedFx;
	private Currency currency;
	private LocalDate instructionDate;
	private LocalDate settlementDate;
	private int units;
	private BigDecimal pricePerUnit;
	private BigDecimal amountInUSD;
	
	public Instruction(String entity, InstructionType type, BigDecimal agreedFx, Currency currency, LocalDate instructionDate, LocalDate settlementDate, int units, BigDecimal pricePerUnit) {
		this.entity = entity;
		this.type = type;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;
		this.amountInUSD = pricePerUnit.multiply(BigDecimal.valueOf(units)).multiply(agreedFx).setScale(2, RoundingMode.HALF_UP);
	}
	
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}
	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}
	/**
	 * @return the type
	 */
	public InstructionType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(InstructionType type) {
		this.type = type;
	}
	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}
	/**
	 * @param agreedFx the agreedFx to set
	 */
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}
	/**
	 * @return the currency
	 */
	public Currency getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}
	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}
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
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	/**
	 * @return the pricePerUnit
	 */
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getAmountInUSD() {
		return amountInUSD;
	}
	
	@Override
	public String toString() {
		return 	"Entity name: " + this.entity + 
				" Inst. type: " + this.type + 
				" AgreedFx: " + this.agreedFx + 
				" Currency: " + this.currency + 
				" Inst. Date: " + this.instructionDate + 
				" Settl. Date: " + this.settlementDate + 
				" Units: " + this.units + 
				" PpU: " + this.pricePerUnit + 
				" USD Amount: " + this.amountInUSD;
	}
}
