public class YearRow {
    int month;
    int amount;
    boolean is_expense;


    YearRow(String[] lines){
        month = Integer.parseInt(lines[0]);
        amount = Integer.parseInt(lines[1]);
        is_expense = Boolean.parseBoolean(lines[2]);
    }
}
