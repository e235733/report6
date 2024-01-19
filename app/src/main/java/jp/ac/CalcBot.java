package jp.ac;

import jp.ac.uryukyu.ie.e235733.CalcMan;

public class CalcBot {
    public void Select(CalcMan calcMan){
        if (calcMan.getStock() >= calcMan.thinkNextCosting()){
            calcMan.Donate();
        }

        else if (calcMan.thinkBest() < calcMan.thinkNextCosting()){
            calcMan.Donate();
        }

        else {
            calcMan.Stock();
        }
    }
}
