package test;

import java.util.List;

import dao.ShiftDao;
import dto.Shift;

public class ShiftDAOTest {

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

        ShiftDao dao = new ShiftDao();

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
        Shift ins = new Shift(0, "saito-yuri-e", "2026-06-16", "09:00", "18:00", "", "");
        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            List<Shift> afterIns = dao.select(new Shift(0, "saito-yuri-e", "", "", "", "", ""));
            showAllData(afterIns);
        } else {
            System.out.println("登録失敗！");
        }

        // update() テスト
        System.out.println("---------- update() テスト ----------");
        List<Shift> upList = dao.select(new Shift(0, "山田祐樹", "", "", "", "", ""));
        if (!upList.isEmpty()) {
            Shift up = upList.get(0);
            up.setClock_in("08:55");  // 出勤時間を変更
            up.setClock_out("18:05");
            up.setReal_in("08:58");
            up.setReal_out("18:10");

            if (dao.update(up)) {
                System.out.println("更新成功！");
                List<Shift> afterUp = dao.select(new Shift(0, "山田祐樹", "", "", "", "", ""));
                showAllData(afterUp);
            } else {
                System.out.println("更新失敗！");
            }
        } else {
            System.out.println("更新対象が見つかりません");
        }

        // delete() テスト
        System.out.println("---------- delete() テスト ----------");
        List<Shift> delList = dao.select(new Shift(0, "山田祐樹", "", "", "", "", ""));
        if (!delList.isEmpty()) {
            Shift del = delList.get(0);
            if (dao.delete(del)) {
                System.out.println("削除成功！");
                List<Shift> afterDel = dao.select(new Shift(0, "", "", "", "", "", ""));
                showAllData(afterDel);
            } else {
                System.out.println("削除失敗！");
            }
        } else {
            System.out.println("削除対象が見つかりません");
        }
        
        System.out.println("---- 出勤登録テスト ----");
        if (dao.updateRealIn("山田祐樹", "2026-06-16")) {
            System.out.println("出勤登録成功！");
        } else {
            System.out.println("出勤登録失敗…");
        }

        System.out.println("---- 退勤登録テスト ----");
        if (dao.updateRealOut("山田祐樹", "2026-06-16")) {
            System.out.println("退勤登録成功！");
        } else {
            System.out.println("退勤登録失敗…");
        }
        
    }


    }
