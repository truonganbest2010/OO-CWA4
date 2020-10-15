package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import controller.MazePanelListener;
import model.MazeGenerator;

import java.awt.*;

public class MazePanel {
    
    private JFrame window;
    private MazeCanvas mazeCanvas;
    private MazeGenerator mazeGen;
    private int preferredSize;
    private int mazeSize; // x, y same

    private JButton newGameBtn = new JButton("New Game");
    private JButton configBtn = new JButton("Settings");

    public MazePanel(JFrame window){
        this.window = window;
        this.mazeSize = 15;
        preferredSize = 15;
        mazeGen = new MazeGenerator(mazeSize, preferredSize);
        mazeCanvas = new MazeCanvas(this, mazeSize, preferredSize);
        window.setResizable(false);
        window.setTitle("Maze Game");
    }

    public void init(){
        Container cp = window.getContentPane();
        
        TitledBorder canvasBorder = BorderFactory.createTitledBorder("");
        mazeCanvas.setBorder(canvasBorder);
        cp.add(BorderLayout.CENTER, mazeCanvas);

        JPanel rightPanel = new JPanel();
        cp.add(BorderLayout.EAST, rightPanel);
        rightPanel.setLayout(new GridLayout(2, 1));

        rightPanel.add(newGameBtn);
        rightPanel.add(configBtn);

        MazePanelListener listener = new MazePanelListener(this);
        newGameBtn.addActionListener(listener);
        configBtn.addActionListener(listener);
        mazeCanvas.addKeyListener(listener);
        mazeCanvas.requestFocusInWindow();
        mazeCanvas.setFocusable(true);

        newGameBtn.setFocusable(false);
        configBtn.setFocusable(false);
    }

    public JFrame getWindow() {
        return window;
    }
    public MazeCanvas getMazeCanvas() {
        return mazeCanvas;
    }
    public MazeGenerator getMazeGen() {
        return mazeGen;
    }
    public int getPreferredSize() {
        return preferredSize;
    }
    public JButton getNewGameBtn() {
        return newGameBtn;
    }
    public JButton getConfigBtn() {
        return configBtn;
    }



}