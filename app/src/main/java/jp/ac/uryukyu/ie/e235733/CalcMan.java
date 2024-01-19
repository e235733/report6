package jp.ac.uryukyu.ie.e235733;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * ゲームのキャラクター。AddManとMultiManがいる。/
 * 計算をして正解すれば収入が得られる。/
 */
public abstract class CalcMan {
    String name;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    long input;

    long donating = 0;//総寄付額
    long stock;//総貯蓄額

    long nextIncome;//次の給与、計算の答え
    long lastIncome;//前の給与

    Costing cost;
    long amount;

    /**
     * @return 現在の貯蓄額
     */
    public long getStock(){
        return this.stock;
    }

    /**
     * @return 現在の総寄付額
     */
    public long getDonating(){
        return this.donating;
    }

    /**
     * @return CalcManの名前
     */
    public String getName(){
        return this.name;
    }

    /**
     * 数値を入力し、inputに保存される/
     * long型のみ有効。それ以外はもう一度入力させられる
     */
    public void Input(){
        while (true){
            try {
                System.out.println("値を入力してください");
                this.input = sc.nextLong();
                break;
            } catch (InputMismatchException e){
                sc.nextLine();
            }
        }
    }

    /**
     * 数値を入力する/
     * long型の1と2のみ有効。それ以外は再度入力/
     * 1: 寄付する, 2: 貯蓄する
     */
    public void Select(){
        System.out.println("寄付する:1, 貯蓄する:2");
        this.Input();

        if (this.input == 1){
            this.Donate();
        }

        else if (this.input == 2){
            this.Stock();
        }

        else {
            this.Select();
        }
    }

    public abstract void Work();

    /**
     * 収入を寄付するメソッド
     * 総寄付額に収入額が足される
     */
    public void Donate(){
        this.donating += this.lastIncome;
        //総寄付額に前の給与分が足される

        System.out.println(this.name + " は寄付した。");
        System.out.println("現在の総寄付額: ¥ " + this.donating);
    }

    public abstract void Stock();

    /**
     * 貯蓄から生活コストが引かれるメソッド
     */
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

    /**
     * CalcBotが次のコストを得るためのメソッド
     * @return 次のコスト
     */
    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }
}
