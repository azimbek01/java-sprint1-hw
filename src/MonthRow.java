public class MonthRow {
    String item_name;
    boolean is_expense;
    int quantity;
    int sum_of_one;

    MonthRow(String[] lines){
        item_name = lines[0];
        is_expense = Boolean.parseBoolean(lines[1]);
        quantity = Integer.parseInt(lines[2]);
        sum_of_one = Integer.parseInt(lines[3]);
    }
}
