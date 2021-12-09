import java.util.ArrayList;
import java.util.HashMap;


public class MonthlyReport {
    String maxIncomeName;
    String maxExpenseName;
    String monthName = "";
    int maxSumIncome = 0;
    int maxSumExpense = 0;

    HashMap<String, ArrayList<MonthRow>> contents = new HashMap<>();
    ArrayList<MonthRow> contentsRows = new ArrayList<>();

    void addMonthRow(MonthRow monthRow, String month) {
        contentsRows.add(monthRow);
        contents.put(month, contentsRows);
    }

    void getMaxIncome() {
        for (String month : contents.keySet()) {
            for (MonthRow item : contentsRows) {
                if (!item.is_expense) {
                    if((item.quantity * item.sum_of_one) > this.maxSumIncome) {
                        this.maxSumIncome = item.quantity * item.sum_of_one;
                        this.maxIncomeName = item.item_name;
                        this.monthName = month;
                    }
                }
            }
        }

        System.out.println(this.monthName + ". Самый прибыльный товар: " +
                        "\"" + this.maxIncomeName + "\"" + " на сумму: " + this.maxSumIncome);
    }

    void getMaxExpense() {
        for (String month : contents.keySet()) {
            for (MonthRow item : contentsRows) {
                if (item.is_expense) {
                    if ((item.quantity * item.sum_of_one) > this.maxSumExpense) {
                        this.maxSumExpense = item.quantity * item.sum_of_one;
                        this.maxExpenseName = item.item_name;
                        this.monthName = month;
                    }
                }
            }
        }
        System.out.println(this.monthName + ". Самая большая трата " +
                "\"" + this.maxExpenseName + "\"" + " на сумму: " + this.maxSumExpense);
    }
}
