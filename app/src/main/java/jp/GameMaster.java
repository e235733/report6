package jp;

import java.util.InputMismatchException;
import java.util.Scanner;

import jp.ac.uryukyu.ie.e235733.CalcMan;

/**
 * 問題を解決するクラス/
 * ゲームを進める
 */
public class GameMaster {
    /**
     * シングルプレイを動かすメソッド/
     * CalcManの貯蓄がマイナスになるまで続く
     * @param calcMan AddMan or MultiMan
     */
    public void singlePlay(CalcMan calcMan){
        System.out.println(calcMan.getName() + "の人生が始まった。");
        System.out.println("----------------------------------------");
        System.out.println("現在の貯蓄額 : ¥ " + calcMan.getStock());
        System.out.println("----------------------------------------");
        while (calcMan.getStock() >= 0){
            calcMan.work();
            calcMan.live();
            System.out.println("----------------------------------------");
            System.out.println("現在の貯蓄額 : ¥ " + calcMan.getStock());
            System.out.println("----------------------------------------");
        }
        System.out.println(calcMan.getName() + "の人生が終わった。");
        System.out.println("総寄付額 : ¥ " + calcMan.getDonating());
        System.out.println("----------------------------------------");
    }

    /**
     * ダブルプレイを動かすメソッド/
     * CalcMan の合計貯蓄額がマイナスになるまで続く
     * @param addMan2 AddMan
     * @param multiMan2 MultiMan
     */
    public void doublePlay(CalcMan addMan2, CalcMan multiMan2){
        System.out.println(addMan2.getName() + "と" + multiMan2.getName() + "の人生が始まった。");
        System.out.println("----------------------------------------");
        long sumStock = addMan2.getStock() + multiMan2.getStock();
        System.out.println("現在の二人の合計貯蓄額 : ¥ " + sumStock);
        System.out.println("----------------------------------------");
        while (sumStock >= 0){
            addMan2.work();
            addMan2.live();
            System.out.println("----------------------------------------");
            multiMan2.work();
            multiMan2.live();
            System.out.println("----------------------------------------");
            sumStock = addMan2.getStock() + multiMan2.getStock();
            System.out.println("現在の二人の合計貯蓄額 : ¥ " + sumStock);
            System.out.println("----------------------------------------");
        }
        System.out.println(addMan2.getName() + "と" + multiMan2.getName() + "の人生が終わった。");
        long sumDonating = addMan2.getDonating() + multiMan2.getDonating();
        System.out.println("総寄付額 : ¥ " + sumDonating);
        System.out.println("----------------------------------------");
    }

    /**
     * プレイモードを選択・開始するメソッド/
     * 1: AddManのソロプレイ , 2: MultiManのソロプレイ , 3: AddMan と MultiMan のダブルプレイ
     * @param addMan AddMan
     * @param multiMan MultiMan
     */
    public void startGame(CalcMan addMan, CalcMan multiMan){
        int input;
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.println("1: ソロ・AddMan , 2: ソロ・MultiMan , 3: デュオ・AddMan & MultiMan");
                System.out.print("モード選択 : ");
                input = sc.nextInt();
                break;
            } catch (InputMismatchException e){
                sc.nextLine();
            }
        }
        if (input == 1){
            System.out.println("----------------------------------------");
            this.singlePlay(addMan);
        }
        else if (input == 2){
            System.out.println("----------------------------------------");
            this.singlePlay(multiMan);
        }
        else if (input == 3){
            System.out.println("----------------------------------------");
            this.doublePlay(addMan, multiMan);
        }
        else {
            this.startGame(addMan, multiMan);
        }
    }
}
