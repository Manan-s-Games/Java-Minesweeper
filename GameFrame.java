import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GameFrame extends JFrame{
    public final int GameSize = 16;
    public final int Bombs = (int)(GameSize * GameSize / 8);
    public int BombNum;
    JButton play[][] = new JButton[GameSize][GameSize];
    boolean buttonPress = true;
    public int counter = 0;
    public final int FRAME_HEIGHT = 805;
    public final int FRAME_WIDTH = 700;
    ArrayList<String> tilesToCheck = new ArrayList<String>();
    ImageIcon img1 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Covered_Tile.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img2 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Not_a_Mine.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img3 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Mine.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img4 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\1.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img5 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\2.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img6 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\3.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img7 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\4.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img8 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\5.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img9 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\6.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img10 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\7.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img11 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\8.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img12 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Blank.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon img13 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Uncovered_Mine.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon flag = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Flagged_Tile.png").getImage().getScaledInstance((int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize), Image.SCALE_SMOOTH));
    ImageIcon background = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\Background.png").getImage().getScaledInstance(FRAME_WIDTH ,FRAME_HEIGHT, Image.SCALE_SMOOTH));
    ImageIcon ResetSmile = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\ResetSmile.png").getImage().getScaledInstance(70 ,70, Image.SCALE_SMOOTH));
    ImageIcon ResetDeath = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\ResetDeath.png").getImage().getScaledInstance(70 ,70, Image.SCALE_SMOOTH));
    ImageIcon ResetSmile2 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\ResetSmile2.png").getImage().getScaledInstance(70 ,70, Image.SCALE_SMOOTH));
    ImageIcon ResetDeath2 = new ImageIcon(new ImageIcon("C:\\Users\\duama\\OneDrive\\Documents\\VS Code\\VS Java\\MineSweeper\\ResetDeath2.png").getImage().getScaledInstance(70 ,70, Image.SCALE_SMOOTH));
    JButton reset = new JButton(ResetSmile);
    JLabel BombCount = new JLabel();
    JLabel Winner = new JLabel();
    public GameFrame() {
        setIconImage(img3.getImage());
        BombCount.setFont(new Font("Arial", Font.BOLD, 50));
        BombCount.setBounds(35, 35, 85, 70);
        BombCount.setBackground(Color.BLACK);
        BombCount.setOpaque(true);
        BombCount.setForeground(Color.RED);
        add(BombCount);
        JFrame temp = new JFrame();
        temp.pack();
        Insets insets = temp.getInsets();
        temp = null;
        JLabel back = new JLabel(background);
        Winner.setBounds(FRAME_WIDTH/2-145, 35, 350, 70);
        Winner.setFont(new Font("Arial", Font.BOLD, 45));
        add(Winner);
        back.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        reset.setBounds(FRAME_WIDTH/2-35, 35, 70, 70);
        reset.setOpaque(false);
        reset.setContentAreaFilled(false);
        reset.setBorderPainted(false);
        reset.setFocusable(false);
        reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
        reset.addActionListener(d -> StartGame());
        add(reset);
        for (int i = 0; i < GameSize; i++) {
            for (int j = 0 ; j < GameSize ;j++) {
                play[i][j] = new JButton();
                play[i][j].setBounds(j * (int)Math.floor((FRAME_WIDTH-54) / GameSize) +30, i*(int)Math.floor((FRAME_WIDTH-54) / GameSize) +138, (int)Math.floor((FRAME_WIDTH-54) / GameSize), (int)Math.floor((FRAME_WIDTH-54) / GameSize));
                play[i][j].setOpaque(false);
                play[i][j].setContentAreaFilled(false);
                play[i][j].setBorderPainted(false);
                play[i][j].setFocusable(false);
                play[i][j].setVerticalTextPosition(JButton.CENTER);
                play[i][j].setHorizontalTextPosition(JButton.CENTER);
                play[i][j].setFont(new Font("Arial", Font.PLAIN, 0));
                add(play[i][j]);
            }
        }
        StartGame();
        for (int i = 0; i < GameSize ;i++) 
            for (int j = 0; j < GameSize; j++) 
                setButtons(i, j);
        add(back);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setSize(new Dimension(insets.left + insets.right + FRAME_WIDTH, insets.top + insets.bottom + FRAME_HEIGHT));
        setResizable(false);
        setVisible(true);
    }
    public void StartGame() {
        BombNum = Bombs;
        BombCount.setText(" "+String.valueOf(BombNum));
        reset.setPressedIcon(ResetSmile2);
        Winner.setText("");
        buttonPress = true;
        reset.setIcon(ResetSmile);
        for (int i = 0; i < GameSize; i++) {
            for (int j = 0 ; j < GameSize ;j++) {
                if(play[i][j].getIcon()!=img1)
                play[i][j].setIcon(img1);
                play[i][j].setCursor(new Cursor(Cursor.HAND_CURSOR));
                play[i][j].setText("");
            }
        }
        for (int i = 0; i < Bombs; i++) {
            int nNum1 = (int)Math.floor(Math.random()*(GameSize));
            int nNum2 = (int)Math.floor(Math.random()*(GameSize));
            if(play[nNum1][nNum2].getText() != "B")
            play[nNum1][nNum2].setText("B");
            else
            i--;
        }
        for (int i = 0; i < GameSize; i++) {
            for (int j = 0; j < GameSize; j++) { 
                int counter = 0;
                if (play[i][j].getText() != "B") {
                    if (i > 0 && j > 0 && i < GameSize - 1 && j < GameSize - 1) {
                        if (play[i-1][j-1].getText() == "B")
                        counter++;
                        if (play[i-1][j].getText() == "B")
                        counter++;
                        if (play[i-1][j+1].getText() == "B")
                        counter++;
                        if (play[i][j-1].getText() == "B")
                        counter++;
                        if (play[i][j+1].getText() == "B")
                        counter++;
                        if (play[i+1][j-1].getText() == "B")
                        counter++;
                        if (play[i+1][j].getText() == "B")
                        counter++;
                        if (play[i+1][j+1].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    if (i == 0 && j == 0) {
                        if (play[i][j+1].getText() == "B")
                        counter++;
                        if (play[i+1][j+1].getText() == "B")
                        counter++;
                        if (play[i+1][j].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    if (i == 0 && j == GameSize - 1) {
                        if (play[i+1][j].getText() == "B")
                        counter++;
                        if (play[i][j-1].getText() == "B")
                        counter++;
                        if (play[i+1][j-1].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    if (i == GameSize - 1 && j == 0) {
                        if (play[i][j+1].getText() == "B")
                        counter++;
                        if (play[i-1][j].getText() == "B")
                        counter++;
                        if (play[i-1][j+1].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    if (i == GameSize - 1 && j == GameSize - 1) {
                        if (play[i-1][j-1].getText() == "B")
                        counter++;
                        if (play[i-1][j].getText() == "B")
                        counter++;
                        if (play[i][j-1].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    else if (i == 0 && j > 0 && j < GameSize - 1) {
                        if (play[i][j-1].getText() == "B")
                        counter++;
                        if (play[i][j+1].getText() == "B")
                        counter++;
                        if (play[i+1][j-1].getText() == "B")
                        counter++;
                        if (play[i+1][j].getText() == "B")
                        counter++;
                        if (play[i+1][j+1].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    else if (j == 0 && i > 0 && i < GameSize - 1) {
                        if (play[i-1][j].getText() == "B")
                        counter++;
                        if (play[i-1][j+1].getText() == "B")
                        counter++;
                        if (play[i][j+1].getText() == "B")
                        counter++;
                        if (play[i+1][j+1].getText() == "B")
                        counter++;
                        if (play[i+1][j].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    else if (i == GameSize - 1 && j > 0 && j < GameSize - 1) {
                        if (play[i][j-1].getText() == "B")
                        counter++;
                        if (play[i-1][j-1].getText() == "B")
                        counter++;
                        if (play[i-1][j].getText() == "B")
                        counter++;
                        if (play[i-1][j+1].getText() == "B")
                        counter++;
                        if (play[i][j+1].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                    else if (j == GameSize - 1 && i > 0 && i < GameSize - 1) {
                        if (play[i-1][j].getText() == "B")
                        counter++;
                        if (play[i-1][j-1].getText() == "B")
                        counter++;
                        if (play[i][j-1].getText() == "B")
                        counter++;
                        if (play[i+1][j-1].getText() == "B")
                        counter++;
                        if (play[i+1][j].getText() == "B")
                        counter++;
                        play[i][j].setText(String.valueOf(counter));
                    }
                }
            }
        }
    }
    public void GameOver() {
        Winner.setText("You         Lose!");
        reset.setIcon(ResetDeath);
        reset.setPressedIcon(ResetDeath2);
        buttonPress = false;
        for (int b = 0; b < GameSize; b++) {
            for (int m = 0; m < GameSize; m++) {
                openBombs(b, m);
                play[b][m].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
    }
    public void ButtonPressed(int i, int j) {
        if(play[i][j].getIcon() == img1 || play[i][j].getIcon() == flag) {
            if (play[i][j].getText() == "B") {
                GameOver();
                play[i][j].setIcon(img13);
            }
            else {
                play[i][j].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            if (Integer.parseInt(play[i][j].getText()) == 1)
                play[i][j].setIcon(img4);
            if (Integer.parseInt(play[i][j].getText()) == 2)
                play[i][j].setIcon(img5);
            if (Integer.parseInt(play[i][j].getText()) == 3)
                play[i][j].setIcon(img6);
            if (Integer.parseInt(play[i][j].getText()) == 4)
                play[i][j].setIcon(img7);
            if (Integer.parseInt(play[i][j].getText()) == 5)
                play[i][j].setIcon(img8);
            if (Integer.parseInt(play[i][j].getText()) == 6)
                play[i][j].setIcon(img9);
            if (Integer.parseInt(play[i][j].getText()) == 7)
                play[i][j].setIcon(img10);
            if (Integer.parseInt(play[i][j].getText()) == 8)
                play[i][j].setIcon(img11);
            if (Integer.parseInt(play[i][j].getText()) == 0) {
                play[i][j].setIcon(img12);
                openNearBy(i,j);
            }
            checkWin();
            }
        }
    }
    public void openNearBy(int x, int y) {
        if ((y+1)<GameSize)
            CheckTileAt(x, y+1);
        if ((x+1)<GameSize)
            CheckTileAt(x+1, y);
        if ((y-1)>=0)
            CheckTileAt(x, y-1);
        if ((x-1) >= 0)
            CheckTileAt(x-1, y);
        if ((y+1)<GameSize && (x+1)<GameSize)
            CheckTileAt(x+1, y+1);
        if ((y+1)<GameSize && (x-1)>=0)
            CheckTileAt(x-1, y+1);
        if ((y-1)>=0 && (x+1)<GameSize)
            CheckTileAt(x+1, y-1);
        if ((y-1)>=0 && (x-1)>=0)
            CheckTileAt(x-1, y-1);
        
        if(tilesToCheck.size()>0 && counter == 0) {
            counter++;
            RevealAdjacentTilesForTiles();
        }
    }
    public void RevealAdjacentTilesForTiles(){
        for (int i = 0; i <tilesToCheck.size(); i++){         
            String temp[] = tilesToCheck.get(i).split(", ");
            int x = Integer.valueOf(temp[0]);
            int y = Integer.valueOf(temp[1]);
            openNearBy(x,y);
        }
        counter = 0;
        tilesToCheck.clear();
    }
    public void CheckTileAt(int x, int y) {
        if (Integer.parseInt(play[x][y].getText()) > 0 && play[x][y].getIcon() == img1) {
            ButtonPressed(x, y);
        }
        else if (play[x][y].getIcon() == img1 && Integer.parseInt(play[x][y].getText()) == 0){
            tilesToCheck.add(String.valueOf(x)+", "+String.valueOf(y));
            play[x][y].setIcon(img12);
            play[x][y].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
    public void openBombs(int i, int j) {
            if (play[i][j].getText() == "B")
            play[i][j].setIcon(img3);
            if (play[i][j].getIcon() == flag && play[i][j].getText() != "B")
            play[i][j].setIcon(img2);
    }
    public void setButtons(int l, int k) {
        MouseListener mouseListener;
        play[l][k].addMouseListener(mouseListener = new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (buttonPress){
                if ((mouseEvent.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) 
                    ButtonPressed(l, k);
                if ((mouseEvent.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK){
                    if(play[l][k].getIcon() == img1) {
                    play[l][k].setIcon(flag);
                    BombNum--;
                    if (BombNum >=0)
                    BombCount.setText(" "+String.valueOf(BombNum));
                    checkWin();
                    }
                    else if(play[l][k].getIcon() == flag) {
                    play[l][k].setIcon(img1);
                    BombNum++;
                    if (BombNum >=0)
                    BombCount.setText(" "+String.valueOf(BombNum));
                    checkWin();
                    }
                }}}});
    }
    public void checkWin() {
        int check = 0;
        for (int i = 0; i < GameSize; i++) 
            for (int j = 0; j < GameSize; j++) 
                if(play[i][j].getIcon() != img4 && play[i][j].getIcon() != img5 && play[i][j].getIcon() != img6 && play[i][j].getIcon() != img7 && play[i][j].getIcon() != img8 && play[i][j].getIcon() != img9 && play[i][j].getIcon() != img10 && play[i][j].getIcon() != img11 && play[i][j].getIcon() != img12)
                check++;
        if (check == Bombs && BombNum == 0) {
            for (int i = 0; i < GameSize; i++) 
                for (int j = 0; j < GameSize; j++) 
                    play[i][j].setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            Winner.setText("You         Win!");
            buttonPress = false;
        }
    }
}