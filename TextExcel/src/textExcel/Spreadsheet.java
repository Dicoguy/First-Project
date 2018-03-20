

package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid{

	Cell[][] spreadsheet = new Cell[12][20];
	public Spreadsheet() {
		for(int row = 0; row < spreadsheet.length; row++) {
			for(int col = 0; col < spreadsheet[row].length; col++){
				spreadsheet[row][col] = new EmptyCell(); 
			}
		}
	}
	
	@Override
	public String processCommand(String command){
		SpreadsheetLocation location = new SpreadsheetLocation(command);
		if(command.contains("=")) {
			
		}else if(command.contains("clear") && (command.length() == 8) || (command.length() == 9) ) {
			
		}else if(command.contains("clear") && (command.length() == 5)) {
			for(int row = 0; row < spreadsheet.length; row++) {
				for(int col = 0; col < spreadsheet[row].length; col++){
					spreadsheet[row][col] = new EmptyCell(); 
				}
			}
			
		}else if(command.contains("=")) {
			spreadsheet[getRow()][getCol]
		}else {
			
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
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText(){
		String grid = "";
		for(char letter = 'A'; letter <= 'L'; letter++) {
			if(letter == 'L') {
				grid += "   |" + letter + "         |";
			}else {
				grid += "   |" + letter + "      ";
			}
		}
		for(int i = 1; i <= 20; i++) {
			if(i >= 10) {
				grid += "\n" + i + " |";        
			}else {
				grid += "\n" + i + "  |";
			}
			for(int j = 0; j <= 11; j++) {
				grid += "          |";
			}
		}
		grid += "\n";
		return grid;
	}
}
