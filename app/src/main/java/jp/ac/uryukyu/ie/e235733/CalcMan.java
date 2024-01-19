package jp.ac.uryukyu.ie.e235733;

import java.util.Random;

public abstract class CalcMan {
    String name;
    Random rand = new Random();

    long donating = 0;//総寄付額
    long stock;//総貯蓄額

    long nextIncome;//次の給与、計算の答え
    long lastIncome;//前の給与

    Costing cost;
    long amount;

    public long getStock(){
        return this.stock;
    }

    public long getDonating(){
        return this.donating;
    }

    public abstract void Work();

    public void Donate(){
        this.donating += this.lastIncome;
        //総寄付額に前の給与分が足される

        System.out.println(this.name + " は寄付した。");
        System.out.println("現在の総寄付額: ¥ " + this.donating);
    }

    public abstract void Stock();

    public void Live(){
        this.amount = cost.getNextCosting();

        this.stock -= this.amount;
        System.out.println("¥ " + amount + " の出費！");
        System.out.println("現在の貯蓄額: ¥ " + this.stock);

        cost.setLastCosting(this.amount);
        cost.CalcCost();
    }

    //for CalcBot
    public abstract long thinkBest();

    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }
}
