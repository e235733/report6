package jp;

import jp.ac.uryukyu.ie.e235733.AddMan;

public class Solver {
    public void StockEnough(){
        AddMan worker1 = new AddMan("太郎");

        while (worker1.getDonating() <= 1000000){
            worker1.Work();
            worker1.Calculate();
            worker1.Donate();
        }

        System.out.println("よくやった！ ¥ " + worker1.getDonating() + " 寄付した。");
    }

    public void DonateEnough(){
        AddMan worker2 = new AddMan("太郎");

        while (worker2.getStock() <= 1000000){
            worker2.Work();
            worker2.Calculate();
            worker2.Stock();
        }

        System.out.println("よく働いた！ ¥ " + worker2.getStock() + " 貯蓄した。");
    }
}
