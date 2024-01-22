package jp.ac.uryukyu.ie.e235733;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import jp.GameMaster;
import jp.ac.uryukyu.ie.AddMan;
import jp.ac.uryukyu.ie.MultiMan;

public class GameMasterTest {
    @Test
    void singlePlayTest(){
        Costing costing = new Costing(1000000, 10);
        long defaultStock = -10000;
        CalcMan addMan = new AddMan("ado", defaultStock, 0, 0, 0, costing);
        GameMaster gameMaster = new GameMaster();

        gameMaster.singlePlay(addMan);
        assertEquals(defaultStock, addMan.getStock());
    }

    @Test
    void doublePlayTest(){
        Costing costing = new Costing(1000000, 10);
        long defaultAddManStock = -10000;
        long defaultMultiManStock = 9000;
        CalcMan addMan = new AddMan("ado", defaultAddManStock, 0, 0, 0, costing);
        CalcMan multiMan = new MultiMan("maru", defaultMultiManStock, 0, costing);
        GameMaster gameMaster = new GameMaster();

        long sumDefaultStock = defaultAddManStock + defaultMultiManStock;
        gameMaster.doublePlay(addMan, multiMan);
        long sumStock = addMan.getStock() + multiMan.getStock();
        assertEquals(sumDefaultStock, sumStock);        
    }
}
