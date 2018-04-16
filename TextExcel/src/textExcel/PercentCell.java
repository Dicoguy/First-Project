package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String input) {
		super(input);
		
	}

	@Override
	public String abbreviatedCellText() {
		String truncated = "";
		String returnString = "";
		if(getValue().contains(".")) {
			truncated = getValue().substring(0,getValue().indexOf(".")) + "%";
		}
		if(truncated.length() >= 10) {
			returnString = truncated.substring(0,10);
			return returnString;
		}else {
			for(int i = truncated.length(); i < 10; i++) {
				truncated += " ";
			}
			return truncated;
		}
		
	}

	@Override
	public String fullCellText() {
		return (getDoubleValue() + "");
	}
	
	public double getDoubleValue() {
		return Double.parseDouble(getValue().substring(0, getValue().length() - 1)) * .01;
	}
	
}