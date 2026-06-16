package test;

import java.util.List;

import dao.Shift_e_Dao;
import dto.Shift;

public class Shift_e_DAOTest {

    // 取得データを表示するメソッド
    public static void showAllData(List<Shift> list) {
        for (Shift s : list) {
            System.out.println("ID: " + s.getId());
            System.out.println("名前: " + s.getUser_name());
            System.out.println("日付: " + s.getDate());
            System.out.println("出勤: " + s.getClock_in());
            System.out.println("退勤: " + s.getClock_out());
            System.out.println("実出勤: " + s.getReal_in());
            System.out.println("実退勤: " + s.getReal_out());
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {

        Shift_e_Dao dao = new Shift_e_Dao();

        // select() テスト1（名前で検索）
        System.out.println("---------- select() テスト1 ----------");
        List<Shift> sel1 = dao.select(new Shift(0, "山田祐樹", "", "", "", "", ""));
        showAllData(sel1);

        // select() テスト2（全件取得）
        System.out.println("---------- select() テスト2 ----------");
        List<Shift> sel2 = dao.select(new Shift());
        showAllData(sel2);

        // insert() テスト
        System.out.println("---------- insert() テスト ----------");
        Shift ins = new Shift(0, "saito-yuri-e", "2026-06-16", "09:00", "18:00", "09:05", "18:10");
        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            List<Shift> afterIns = dao.select(new Shift(0, "saito-yuri-e", "", "", "", "", ""));
            showAllData(afterIns);
        } else {
            System.out.println("登録失敗！");
        }

    }
}