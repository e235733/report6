package jp.ac.uryukyu.ie;

import java.util.Random;

import jp.ac.uryukyu.ie.e235733.Costing;
import jp.ac.uryukyu.ie.e235733.CalcMan;

public class MultiMan extends CalcMan{
    String name;
    Random rand = new Random();

    long donating = 0;//総寄付額
    long stock;//総貯蓄額

    long nextIncome;//次の給与、計算の答え
    long lastIncome;//前の給与

    long baseIncome;

    int increase;

    Costing cost;
    long amount;

    public MultiMan(String _name, long _stock, long _baseIncome, Costing _cost){
        this.name = _name;
        this.stock = _stock;
        this.lastIncome= _baseIncome;
        this.cost = _cost;

        this.baseIncome = _baseIncome;
    }

    public long getStock(){
        return this.stock;
    }

    public long getDonating(){
        return this.donating;
    }

    public void setNextIncrease(){
        this.increase = 11 + rand.nextInt(9);
        //次の増加率の設定。min:11, max:19
    }

    @Override
    public void Work(){
        this.setNextIncrease();

        System.out.println(this.lastIncome + " * " + this.increase + " ?");
        //次の給与の計算式

        this.nextIncome = this.lastIncome * this.increase;
        //（次の給与）＝（前の給与）*（昇給額）
        System.out.println("値を入力してください");

        System.out.println(this.nextIncome);
        //本当は値を入力させたいけどできないため確実に正解する

        //if (nextIncome == answer){
            System.out.println("Good Job! ¥ " + this.nextIncome + " 稼いだ。");
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

    public void Live(){
        this.amount = cost.getNextCosting();

        this.stock -= this.amount;
        System.out.println("¥ " + amount + " の出費！");
        System.out.println("現在の貯蓄額: ¥ " + this.stock);

        cost.setLastCosting(this.amount);
        cost.CalcCost();
    }

    @Override
    public void Stock(){
        this.stock += this.lastIncome;
        //貯蓄額に前の給与分が足される

        System.out.println(this.name + " は貯蓄に回した。");
        System.out.println("現在の貯蓄額: ¥ " + this.stock);

        this.lastIncome = this.baseIncome;
        System.out.println("評判が下がり、辞任した。");
        System.out.println(this.name + "は再起業した。");
    }

    //for CalcBot
    @Override
    public long thinkBest(){
        return this.stock + (this.lastIncome * 19); 
    }

    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }
}