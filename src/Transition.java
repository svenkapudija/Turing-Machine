
public class Transition {

	private String currentState;
	private String currentTapeSymbol;
	private String newState;
	private String newTapeSymbol;
	private String headMovement;
	
	public String getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	
	public String getCurrentTapeSymbol() {
		return currentTapeSymbol;
	}
	
	public void setCurrentTapeSymbol(String currentTapeSymbol) {
		this.currentTapeSymbol = currentTapeSymbol;
	}
	
	public String getNewState() {
		return newState;
	}
	
	public void setNewState(String newState) {
		this.newState = newState;
	}
	
	public String getNewTapeSymbol() {
		return newTapeSymbol;
	}
	
	public void setNewTapeSymbol(String newTapeSymbol) {
		this.newTapeSymbol = newTapeSymbol;
	}
	
	public String getHeadMovement() {
		return headMovement;
	}
	
	public void setHeadMovement(String headMovement) {
		this.headMovement = headMovement;
	}
	
	@Override
	public String toString() {
		return currentState + "," + currentTapeSymbol + "->" + newState + "," + newTapeSymbol + "," + headMovement;
	}
	
}
