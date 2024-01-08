package jp.ac.uryukyu.ie.e235733;

import java.util.Random;

public class AddMan {
    String name;
    Random rand = new Random();

    long donating = 0;//総寄付額
    long stock = 0;//総貯蓄額

    long nextWage = 10000;//次の給与、計算の答え
    long lastWage = 10000;//前の給与

    public AddMan(String _name){
        this.name = _name;
    }

    public long getStock(){
        return this.stock;
    }

    public long getDonating(){
        return this.donating;
    }

    public void Work(){
        long raise = 1000 + rand.nextLong(1000);
        //次の昇給額の設定。min:1000, max:1999 

        this.nextWage = this.lastWage + raise;
        //（次の給与）＝（前の給与）＋（昇給額）
        System.out.println(this.lastWage + " + " + raise + " ?");
        //次の給与の計算式
    }

    public void Calculate(){
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
}
