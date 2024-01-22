import jp.GameMaster;
import jp.ac.uryukyu.ie.AddMan;
import jp.ac.uryukyu.ie.MultiMan;
import jp.ac.uryukyu.ie.e235733.Costing;
import jp.ac.uryukyu.ie.e235733.CalcMan;

public class Main {
    public static void main(String[] args){
        Costing costing = new Costing(1000, 1.4);

        CalcMan addMan = new AddMan("太郎", 20000, 10000, 2000, 2000, costing);
        CalcMan multiMan = new MultiMan("次郎", 5000, 3, costing);

        GameMaster game = new GameMaster();
        
        game.startGame(addMan, multiMan);
    }
}
