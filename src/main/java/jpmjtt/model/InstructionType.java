package jpmjtt.model;

/**
 * @author Serhan
 *
 */
public enum InstructionType {
	BUY("B"),
    SELL("S");

    @SuppressWarnings("unused")
	private String type;
    
    private InstructionType(String type) {
		this.type = type;
	}
}
