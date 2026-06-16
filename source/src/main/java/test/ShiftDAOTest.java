package test;

import java.util.List;

import dao.Shift_e_Dao;
import dto.Shift;

public class ShiftDAOTest {

    public static void main(String[] args) {

        // DAO のインスタンス
        Shift_e_Dao dao = new Shift_e_Dao();

        // 検索条件（user_name をセット）
        Shift condition = new Shift();
        condition.setUser_name("山田");   // ← DB に存在する user_name を入れてね

        // DAO の select を実行
        List<Shift> list = dao.select(condition);

        // 結果を表示
        if (list == null) {
            System.out.println("検索に失敗しました");
            return;
        }

        if (list.size() == 0) {
            System.out.println("該当データなし");
            return;
        }

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
}
