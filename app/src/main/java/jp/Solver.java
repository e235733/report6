package jp;

import jp.ac.CalcBot;
import jp.ac.uryukyu.ie.e235733.AddMan;

public class Solver {

    public void SetAddMan(AddMan _addMan){
        
    }

    public void Play(AddMan addMan, CalcBot calcBot){
        while (addMan.getStock() >= 0){
            addMan.Work();
            calcBot.Select(addMan);
            addMan.Live();
        }
    }

}
