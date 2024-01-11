import jp.Solver;
import jp.ac.CalcBot;
import jp.ac.uryukyu.ie.e235733.AddMan;
import jp.ac.uryukyu.ie.e235733.Costing;

public class Main {
    public static void main(String[] args){
        Costing costing = new Costing(1000, 1.2);

        AddMan addMan = new AddMan("太郎", 20000, 10000, 2000, 1000, costing);

        CalcBot calcBot = new CalcBot();

        Solver game = new Solver();

        game.Play(addMan, calcBot);
        
    }
}
