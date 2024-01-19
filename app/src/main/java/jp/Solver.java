package jp;

import jp.ac.CalcBot;
import jp.ac.uryukyu.ie.e235733.CalcMan;

public class Solver {

    public void SetAddMan(CalcMan calcMan){
        
    }

    public void Play(CalcMan calcMan, CalcBot calcBot){
        while (calcMan.getStock() >= 0){
            calcMan.Work();

            calcBot.Select(calcMan);
            
            calcMan.Live();
        }
    }

}
