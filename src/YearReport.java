import java.util.ArrayList;


public class YearReport {
    int profitJanuary = 0;
    int profitFebruary = 0;
    int profitMarch= 0;
    int averageIncome = 0;
    int averageExpense = 0;

    ArrayList<YearRow> contentsRows = new ArrayList<>();

    void addYearRow(YearRow yearRow) {
        contentsRows.add(yearRow);
    }

    void getProfit() {

        for (YearRow row : contentsRows) {
            if (row.month == 1) {
                if (row.is_expense) {
                    this.profitJanuary -= row.amount;
                } else {
                    this.profitJanuary += row.amount;
                }
            } else if (row.month == 2) {
                if (row.month == 2) {
                    if (row.is_expense) {
                        this.profitFebruary -= row.amount;
                    } else {
                        this.profitFebruary += row.amount;
                    }
                }
            } else if (row.month == 3) {
                if (row.month == 3) {
                    if (row.is_expense) {
                        this.profitMarch -= row.amount;
                    } else {
                        this.profitMarch += row.amount;
                    }
                }
            }
        }
        System.out.println("Прибыль за январь: " + this.profitJanuary);
        System.out.println("Прибыль за февраль: " + this.profitFebruary);
        System.out.println("Прибыль за март: " + this.profitMarch);
    }

    void getAverageExpense() {
        int sumExpense = 0;
        int countExpense = 0;
        for (YearRow row : contentsRows) {
            if (row.is_expense) {
                sumExpense += row.amount;
                countExpense += 1;
            }
        }
        System.out.println("Средний расход за все месяцы в году: " + sumExpense / countExpense);
    }

    void getAverageIncome() {
        int sumIncome = 0;
        int countIncome = 0;
        for (YearRow row : contentsRows) {
            if (!row.is_expense) {
                sumIncome += row.amount;
                countIncome += 1;
            }
        }
        System.out.println("Средний доход за все месяцы в году: " + sumIncome / countIncome);
    }
}