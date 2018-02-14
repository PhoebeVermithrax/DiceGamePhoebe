/*
 * Created by: Phoebe Vermithrax
 * Created on: 13-Feb-2018
 * Created for: ICS4U
 * Daily Assignment – Day #7
 * This program generates a random number and has the user guess it. 
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DiceGame {

	//Create an int variable (So the numbers are full) to store the random number. 
	int randomNumber;
	
	//Create the variables for the user input and the number of their guesses.
	int userNum;
	int numOfGuesses;
	
	protected Shell shell;
	private Text txtRandomNum;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DiceGame window = new DiceGame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Dice Game");
		
		Label lblEnterANumberIntro = new Label(shell, SWT.NONE);
		lblEnterANumberIntro.setBounds(28, 80, 213, 15);
		lblEnterANumberIntro.setText("Enter a number between 1 to 6: ");
		
		txtRandomNum = new Text(shell, SWT.BORDER);
		txtRandomNum.setBounds(260, 77, 137, 21);
		
		Label lblTheRandomAns = new Label(shell, SWT.NONE);
		lblTheRandomAns.setBounds(260, 194, 55, 15);
		lblTheRandomAns.setText("New Label");
		//Make the random answer invisible.
		lblTheRandomAns.setVisible(false);
		
		Label lblNumOfGuesses = new Label(shell, SWT.NONE);
		lblNumOfGuesses.setBounds(260, 162, 55, 15);
		lblNumOfGuesses.setText(" ");
		
		Label lblCongrats = new Label(shell, SWT.NONE);
		lblCongrats.setBounds(28, 225, 55, 15);
		lblCongrats.setText("Congrats!");
		//Make the text invisible.
		lblCongrats.setVisible(false);
		
		Button btnNewNumber = new Button(shell, SWT.NONE);
		btnNewNumber.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Reset the number of guesses to 0.
				numOfGuesses = 0;
				lblNumOfGuesses.setText("" + 0);
				
				//Reset the invisibility of the Random Text and the congrats.
				lblTheRandomAns.setVisible(false);
				lblCongrats.setVisible(false);
				
				//Everytime the user presses the new number button, provide a new random number.
				randomNumber = ((int) (Math.random()*6))+1;
				
				//To check if it works, print this to the terminal.
				System.out.println(" " + randomNumber);
			}
		});
		
		Button btnGuess = new Button(shell, SWT.NONE);
		btnGuess.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//Get the user's input from the textbox.
				userNum = Integer.parseInt(txtRandomNum.getText());
				
				//Check to see if the user's number is the same as the random number. If not, then increase their number
				//of guesses.
				if (userNum == randomNumber)
				{
					//Show the random number and update the number of guesses.
					lblTheRandomAns.setVisible(true);
					lblTheRandomAns.setText(" " + randomNumber);

					numOfGuesses++;
					lblNumOfGuesses.setText("" + numOfGuesses);
					
					//Reveal the congrats text.
					lblCongrats.setVisible(true);
				}
				else {
					
					//Update the number of guesses.
					numOfGuesses++;
					lblNumOfGuesses.setText("" + numOfGuesses);
				}
				
			}
		});
		btnGuess.setBounds(260, 118, 137, 25);
		btnGuess.setText("Guess");
		

		btnNewNumber.setBounds(260, 31, 137, 25);
		btnNewNumber.setText("New Number");
		
		Label lblNumberOfGuessesIntro = new Label(shell, SWT.NONE);
		lblNumberOfGuessesIntro.setBounds(28, 162, 213, 15);
		lblNumberOfGuessesIntro.setText("Number of Guesses before correct: ");
		
		Label lblTheRandomNumberIntro = new Label(shell, SWT.NONE);
		lblTheRandomNumberIntro.setBounds(28, 194, 213, 15);
		lblTheRandomNumberIntro.setText("The Random Number was: ");
		
		Label lblFirstGenerateA = new Label(shell, SWT.NONE);
		lblFirstGenerateA.setBounds(28, 31, 213, 15);
		lblFirstGenerateA.setText("First, generate a random number:");
		

		
		

	}
}
