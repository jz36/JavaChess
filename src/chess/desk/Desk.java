package chess.desk;

/**
 * Created by jz36 on 30.04.16.
 */

import chess.figure.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Desk {
    public Cell[][] cell;
    private int startX, startY;
    private JTextArea[] chars,numbers;
    private byte aByte;
    private char aChar;
    MouseListener listener = new DragMouseAdapter();
    public Figure[] figureArray;

    public Desk(){
        ImageIcon icon1 = new ImageIcon("src/figure/image/wPawn.png");
        figureArray = new Figure[32];
        JFrame DeskFrame = new JFrame();
        DeskFrame.setSize(600, 600);
        DeskFrame.setLayout(null);
        DeskFrame.setVisible(true);
        startX = 60;
        startY = 60;
        cell = new Cell[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                cell[i][j] = new Cell(j, i);
                cell[i][j].setBounds(startX, startY, 60, 60);
                cell[i][j].addMouseListener(listener);
                DeskFrame.add(cell[i][j]);
                startX += 60;
            }
            startX = 60;
            startY += 60;
        }
        chars = new JTextArea[8];
        numbers = new JTextArea[8];
        startX = 60;
        startY = 60;
        for(int i = 0; i < 8; i++){
            numbers[i] = new JTextArea(String.valueOf(8-i));
            numbers[i].setBounds(30, startY, 60, 60);
            aByte = (byte)(i+65);
            aChar = (char)aByte;
            chars[i] = new JTextArea(String.valueOf(aChar));
            chars[i].setBounds(startX, 540, 60, 60);
            DeskFrame.add(numbers[i]);
            DeskFrame.add(chars[i]);
            startY += 60;
            startX += 60;
        }
        for(int i = 0; i < 8; i++){
            figureArray[i] = new Pawn(cell[6][i]);
            figureArray[i + 16] = new Pawn(cell[1][i]);
        }

        figureArray[8] = new Rook(cell[7][0]);
        figureArray[9] = new Rook(cell[7][7]);
        figureArray[10] = new Knight(cell[7][1]);
        figureArray[11] = new Knight(cell[7][6]);
        figureArray[12] = new Bishop(cell[7][2]);
        figureArray[13] = new Bishop(cell[7][5]);
        figureArray[14] = new Queen(cell[7][4]);
        figureArray[15] = new King(cell[7][3]);
        figureArray[24] = new Rook(cell[0][0]);
        figureArray[25] = new Rook(cell[0][7]);
        figureArray[26] = new Knight(cell[0][1]);
        figureArray[27] = new Knight(cell[0][6]);
        figureArray[28] = new Bishop(cell[0][2]);
        figureArray[29] = new Bishop(cell[0][5]);
        figureArray[30] = new Queen(cell[0][4]);
        figureArray[31] = new King(cell[0][3]);


        DeskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    class DragMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JComponent c = (JComponent) e.getSource();
            TransferHandler handler = c.getTransferHandler();
            System.out.println(handler);
            handler.exportAsDrag(c, e, TransferHandler.COPY);
        }
    }
}
