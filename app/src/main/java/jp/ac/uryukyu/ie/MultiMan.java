package jp.ac.uryukyu.ie;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import jp.ac.uryukyu.ie.e235733.Costing;
import jp.ac.uryukyu.ie.e235733.CalcMan;

/**
 * MultiManは掛け算をするCalcManのクラス/
 * 起業家タイプでリスクが大きい。貯蓄に回すとすぐに評判が下がる。/
 * 貯蓄すると収入はリセットされる。
 */
public class MultiMan extends CalcMan{
    String name;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    long input;

    long donating = 0;//総寄付額
    long stock;//総貯蓄額

    long nextIncome;//次の給与、計算の答え
    long lastIncome;//前の給与

    long baseIncome;

    int increase;

    Costing cost;
    long amount;

    /**
     * 
     * @param _name 名前
     * @param _stock 最初の貯蓄額
     * @param _baseIncome 収入の基準
     * @param _cost 生活コスト
     */
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

    public String getName(){
        return this.name;
    }

    /**
     * 次の収入倍率を決定するメソッド/
     * min:11, max:19
     */
    public void setNextIncrease(){
        this.increase = 11 + rand.nextInt(9);
    }

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

    /**
     * 計算をして次の収入を得るメソッド/
     * (次の収入) = (前の収入) * (倍率)/
     * 次の収入が前の収入となる
     */
    @Override
    public void Work(){
        this.setNextIncrease();

        System.out.println(this.lastIncome + " * " + this.increase + " ?");
        //次の給与の計算式

        this.nextIncome = this.lastIncome * this.increase;
        //（次の給与）＝（前の給与）*（昇給額）

        this.Input();

        if (this.nextIncome == this.input){
            System.out.println("Good Job! " + this.name + " ¥ " + this.nextIncome + " 稼いだ。");
            this.lastIncome = this.nextIncome;

            this.Select();
        }

        else {
            System.out.println("会社が倒産した。" + this.name + "は再起業した。");
            this.lastIncome = this.baseIncome;
        }
    }

    public void Donate(){
        this.donating += this.lastIncome;
        //総寄付額に前の給与分が足される

        System.out.println(this.name + " は寄付した。");
        System.out.println("現在の総寄付額: ¥ " + this.donating);
    }

    /**
     * 前の収入を貯蓄するメソッド/
     * 貯蓄額に前の収入が足される/
     * AddManとは違い、貯蓄に回すと収入がリセットされる
     */
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

    public void Live(){
        this.amount = cost.getNextCosting();

        this.stock -= this.amount;
        System.out.println("¥ " + amount + " の出費！");
        System.out.println("現在の貯蓄額: ¥ " + this.stock);

        cost.setLastCosting(this.amount);
        cost.CalcCost();
    }

    //for CalcBot
    /**
     * CalcBotが期待される最高額の貯蓄額を得るメソッド/
     * (現在の貯蓄) + (前の収入) * (最高倍率:19)
     * @return 貯蓄の最高期待額
     */
    @Override
    public long thinkBest(){
        return this.stock + (this.lastIncome * 19); 
    }

    public long thinkNextCosting(){
        return this.cost.getNextCosting();
    }
}