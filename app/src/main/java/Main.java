import jp.GameMaster;
import jp.ac.uryukyu.ie.AddMan;
import jp.ac.uryukyu.ie.MultiMan;
import jp.ac.uryukyu.ie.e235733.Costing;
import jp.ac.uryukyu.ie.e235733.CalcMan;

public class Main {
    public static void main(String[] args){
        Costing costing1 = new Costing(1000, 1.2);
        Costing costing2 = new Costing(1000, 2.3);

        CalcMan addMan = new AddMan("太郎", 20000, 10000, 2000, 2000, costing1);
        CalcMan multiMan = new MultiMan("次郎", 30000, 33, costing2);

        GameMaster game = new GameMaster();
        
        game.Play(addMan);
        game.Play(multiMan);
        
    }
}
