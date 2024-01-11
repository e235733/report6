package jp.ac.uryukyu.ie.e235733;

import java.util.Random;

public class AddMan {
    String name;
    Random rand = new Random();

    long donating = 0;//総寄付額
    long stock;//総貯蓄額

    long nextWage;//次の給与、計算の答え
    long lastWage;//前の給与

    long raise;
    long raiseBase;
    long raiseBound;

    Costing cost;
    long amount;

    public AddMan(String _name, long _stock, long _firstWage, long _raiseBase, long _raiseBound, Costing _cost){
        this.name = _name;
        this.stock = _stock;
        this.lastWage= _firstWage;
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

    public void Work(){
        this.raise = raiseBase + rand.nextLong(raiseBound);
        //次の昇給額の設定。min:raiseBase , max:raiseBase + raiseBound

        System.out.println(this.lastWage + " + " + this.raise + " ?");
        //次の給与の計算式

        this.nextWage = this.lastWage + this.raise;
        //（次の給与）＝（前の給与）＋（昇給額）
        System.out.println("値を入力してください");

        System.out.println(this.nextWage);
        //本当は値を入力させたいけどできないため確実に正解する

        //if (nextWage == answer){
            System.out.println("Good Job! 太郎は ¥ " + this.nextWage + " 稼いだ。");
            this.lastWage = this.nextWage;
        //}

        /*else {
            System.out.println("クビになった。");
        }
        */

    }

    public void Donate(){
        this.donating += this.lastWage;
        //総寄付額に前の給与分が足される

        System.out.println(this.name + " は寄付した。");
        System.out.println("現在の総寄付額: ¥ " + this.donating);
    }

    public void Stock(){
        this.stock += this.lastWage;
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
    public long thinkBest(){
        return this.stock + this.lastWage + this.raiseBase + this.raiseBound; 
    }

    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }
}
