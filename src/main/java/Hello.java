public class Hello {
    public static void sayHello() {
        System.out.println("Привет Мир!");
    }

    public static void main(String[] args) {
        //sayHello();
        int zadDays = 10000;
        int years = zadDays / 365;
        int months = zadDays % 365 / 30;
        int days = zadDays % 365 % 30;

        System.out.println("в " + zadDays + " дней входит:");
        System.out.println(years + " лет");
        System.out.println(months + " месяцев");
        System.out.println(days + " дней");
        System.out.println("Summ: " + (years*365 + months*30 + days));
    }
}
