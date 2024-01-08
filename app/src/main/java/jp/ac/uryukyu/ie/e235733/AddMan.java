package jp.ac.uryukyu.ie.e235733;

import java.util.Random;

public class AddMan {
    String name;
    Random rand = new Random();

    long donating = 0;
    long stock = 0;

    long nextWage = 10000;
    long lastWage = 10000;

    public AddMan(String _name){
        this.name = _name;
    }

    public void Work(){
        long raise = rand.nextLong(1000);
        this.nextWage = this.lastWage + raise;
        System.out.println(this.lastWage + "+" + raise + "?");
    }

    public void Calculate(){
        System.out.println("値を入力してください");

        System.out.println(this.nextWage);

        //if (nextWage == answer){
            System.out.println("Good Job! 太郎は ¥" + this.nextWage + " 稼いだ。");
            this.lastWage = this.nextWage;
        //}

        /*else {
            System.out.println("クビになった。");
        }
        */
    }

    public void Donate(){
        this.donating += this.lastWage;
    }

    public void Stock(){
        this.stock += this.lastWage;
    }
}
