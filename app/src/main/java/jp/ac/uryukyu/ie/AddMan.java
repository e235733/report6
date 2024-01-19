package jp.ac.uryukyu.ie;

import java.util.Random;

import jp.ac.uryukyu.ie.e235733.Costing;
import jp.ac.uryukyu.ie.e235733.CalcMan;

public class AddMan extends CalcMan{
    String name;
    Random rand = new Random();

    long donating = 0;//総寄付額
    long stock;//総貯蓄額

    long nextIncome;//次の給与、計算の答え
    long lastIncome;//前の給与

    Costing cost;
    long amount;

    long raise;
    long raiseBase;
    long raiseBound;

    public AddMan(String _name, long _stock, long _baseIncome, long _raiseBase, long _raiseBound, Costing _cost){
        this.name = _name;
        this.stock = _stock;
        this.lastIncome = _baseIncome;
        this.raiseBase = _raiseBase;
        this.raiseBound = _raiseBound;
        this.cost = _cost;
    }

    public long getStock(){
        return this.stock;
    }

    public long getDonating(){
        return this.donating;
    }

    @Override
    public void Work(){
        this.raise = raiseBase + rand.nextLong(raiseBound);
        //次の昇給額の設定。min:raiseBase , max:raiseBase + raiseBound

        System.out.println(this.lastIncome + " + " + this.raise + " ?");
        //次の給与の計算式

        this.nextIncome = this.lastIncome + this.raise;
        //（次の給与）＝（前の給与）＋（昇給額）
        System.out.println("値を入力してください");

        System.out.println(this.nextIncome);
        //本当は値を入力させたいけどできないため確実に正解する

        //if (nextIncome == answer){
            System.out.println("Good Job! 太郎は ¥ " + this.nextIncome + " 稼いだ。");
            this.lastIncome = this.nextIncome;
        //}

        /*else {
            System.out.println("クビになった。");
        }
        */

    }

    public void Donate(){
        this.donating += this.lastIncome;
        //総寄付額に前の給与分が足される

        System.out.println(this.name + " は寄付した。");
        System.out.println("現在の総寄付額: ¥ " + this.donating);
    }

    public void Stock(){
        this.stock += this.lastIncome;
        //貯蓄額に前の給与分が足される

        System.out.println(this.name + " は貯蓄に回した。");
        System.out.println("現在の貯蓄額: ¥ " + this.stock);
    }

    public void Live(){
        this.amount = cost.getNextCosting();

        this.stock -= this.amount;
        System.out.println("¥ " + amount + " の出費！");
        System.out.println("現在の貯蓄額: ¥ " + this.stock);

        cost.setLastCosting(this.amount);
        cost.CalcCost();
    }

    //for CalcBot
    @Override
    public long thinkBest(){
        return this.stock + this.lastIncome + this.raiseBase + this.raiseBound; 
    }

    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }
}
