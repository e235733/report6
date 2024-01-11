package jp.ac;

import jp.ac.uryukyu.ie.e235733.AddMan;

public class CalcBot {
    public void Select(AddMan addMan){
        if (addMan.getStock() >= addMan.thinkNextCosting()){
            addMan.Donate();
        }

        else if (addMan.thinkBest() < addMan.thinkNextCosting()){
            addMan.Donate();
        }

        else {
            addMan.Stock();
        }
    }
}
