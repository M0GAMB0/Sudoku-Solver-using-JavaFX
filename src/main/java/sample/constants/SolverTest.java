package sample.constants;

import javafx.scene.control.TextField;

import java.util.HashSet;

public class SolverTest {
    TextField[][] textFields=new TextField[9][9];
    public SolverTest(TextField[][] textField){
        this.textFields=textField;
    }
    public void test1() {
        textFields[2][0].setText("5");
        textFields[2][0].setEditable(false);
        textFields[3][0].setText("1");
        textFields[3][0].setEditable(false);
        textFields[4][0].setText("6");
        textFields[4][0].setEditable(false);
        textFields[7][0].setText("3");
        textFields[7][0].setEditable(false);

        textFields[0][1].setText("3");
        textFields[0][1].setEditable(false);
        textFields[3][1].setText("5");
        textFields[3][1].setEditable(false);
        textFields[4][1].setText("8");
        textFields[4][1].setEditable(false);
        textFields[5][1].setText("4");
        textFields[5][1].setEditable(false);
        textFields[6][1].setText("9");
        textFields[6][1].setEditable(false);

        textFields[5][2].setText("7");
        textFields[5][2].setEditable(false);
        textFields[7][2].setText("8");
        textFields[7][2].setEditable(false);

        textFields[0][3].setText("5");
        textFields[0][3].setEditable(false);
        textFields[2][3].setText("9");
        textFields[2][3].setEditable(false);
        textFields[3][3].setText("7");
        textFields[3][3].setEditable(false);

        textFields[2][4].setText("7");
        textFields[2][4].setEditable(false);
        textFields[4][4].setText("5");
        textFields[4][4].setEditable(false);
        textFields[8][4].setText("6");
        textFields[8][4].setEditable(false);

        textFields[2][5].setText("6");
        textFields[2][5].setEditable(false);
        textFields[4][5].setText("4");
        textFields[4][5].setEditable(false);
        textFields[5][5].setText("2");
        textFields[5][5].setEditable(false);
        textFields[7][5].setText("7");
        textFields[7][5].setEditable(false);

        textFields[4][6].setText("2");
        textFields[4][6].setEditable(false);
        textFields[7][6].setText("9");
        textFields[7][6].setEditable(false);
        textFields[8][6].setText("1");
        textFields[7][6].setEditable(false);

        textFields[1][7].setText("6");
        textFields[1][7].setEditable(false);
        textFields[3][7].setText("8");
        textFields[3][7].setEditable(false);
        textFields[5][7].setText("5");
        textFields[5][7].setEditable(false);
        textFields[6][7].setText("4");
        textFields[6][7].setEditable(false);
        textFields[7][7].setText("2");
        textFields[7][7].setEditable(false);

        textFields[0][8].setText("4");
        textFields[0][8].setEditable(false);
        textFields[6][8].setText("7");
        textFields[6][8].setEditable(false);
        textFields[7][8].setText("5");
        textFields[7][8].setEditable(false);
        textFields[8][8].setText("8");
        textFields[8][8].setEditable(false);
    }

}
