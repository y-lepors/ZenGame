package gameLauncher;

import consoleView.GraphicGameMenu;
import consoleView.IGameMenu;
import consoleView.PrintGameMenu;
import consoleView.frame.FirstFramePage;
import consoleView.listener.FirstListenerPage;
import zenGame.GraphicType;

import javax.swing.*;

/**
 * Ask the gameType when you execute the JAR
 */
public class AskGameType {

    private GraphicType gameType;
    private IGameMenu gameMenu;

    /**
     * Ask the gameType to the user
     */
    public AskGameType(){
        askGameType();
        if(this.gameType.equals(GraphicType.Console)){
            this.gameMenu = new PrintGameMenu();
        } else if(this.gameType.equals(GraphicType.Graphic)){
            FirstFramePage firstFramePage = new FirstFramePage();
            FirstListenerPage firstListenerPage = new FirstListenerPage(firstFramePage);
        }
    }

    /**
     * Ask the user about the graphic type
     */
    public void askGameType() {

        Object[] type = {"Console", "Graphic"};
        int index = JOptionPane.showOptionDialog(null,
                "Quel mode de jeu ?",
                "Mode de jeu",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("./data/logo_Zen.png"), type, type[0]);
        if(index == 0){
            this.gameType = GraphicType.Console;
        } else if(index == 1) {
            this.gameType = GraphicType.Graphic;
        }
    }
}
