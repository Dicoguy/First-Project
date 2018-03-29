

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{

	private Cell[][] spreadsheet = new Cell[20][12];
	public Spreadsheet() {
		for(int row = 0; row < spreadsheet.length; row++) {
			for(int col = 0; col < spreadsheet[row].length; col++){
				spreadsheet[row][col] = new EmptyCell(); 
			}
		}
	}
	
	@Override
	public String processCommand(String command){
		if(command.equals("")) {
			return "";
		}else {
			String output = "";
			if(command.contains("=")) { //cell assignment
				SpreadsheetLocation location = new SpreadsheetLocation(command.split(" ", 3)[0]);
				spreadsheet[location.getRow()][location.getCol()] = new TextCell(command.split(" ", 3)[2]);
				//System.out.println("The specific text of cell in processcommand" + command.split(" ", 3)[2]);
				output = getGridText();
			}else if(command.contains("clear") && (command.length() == 8) || (command.length() == 9) ) {
				SpreadsheetLocation location = new SpreadsheetLocation(command.split(" ", 3)[1]);
				spreadsheet[location.getRow()][location.getCol()] = new EmptyCell();
				output = getGridText();
			}else if((command.toLowerCase()).contains("clear") && (command.length() == 5)) {
				for(int row = 0; row < spreadsheet.length; row++) {
					for(int col = 0; col < spreadsheet[row].length; col++){
						spreadsheet[row][col] = new EmptyCell(); 
					}
				}
				output = getGridText();			
			}else { //if just a single coordinate
				SpreadsheetLocation location = new SpreadsheetLocation(command);
				output = getCell(location).fullCellText();
			}
			return output;
			
		}
		
	}

	@Override
	public int getRows(){
		return spreadsheet[0].length;
	}

	@Override
	public int getCols(){
		return  spreadsheet.length;
	}
	
	@Override
	public Cell getCell(Location loc){
		Cell location = spreadsheet[loc.getRow()][loc.getCol()];
		return location;
	}

	@Override
	public String getGridText(){
		String grid = "   ";
		for(char letter = 'A'; letter <= 'L'; letter++) {
				grid += "|" + letter + "         ";
			}
		grid += "|\n";
		
		for(int i = 0; i < 20; i++) {
			if(i < 9) {	
				grid +=  (i + 1) + "  |";        
			}else {
				grid +=  (i + 1) + " |";
			}
			
			for(int j = 0; j < 12; j++) {
				grid += spreadsheet[i][j].abbreviatedCellText() + "|";
			}
			grid += "\n";
		}
		
		
		return grid;
	}
}
