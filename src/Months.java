/**
 * Enum für die Monate eines Jahrs
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public enum Months {
    /**
     * 1. Monat
     * Januar
     */
    JAN("January", 1, 31),

    /**
     * 2. Monat
     * Februar
     */
    FEB("February", 2, 28),

    /**
     * 3. Monat
     * März
     */
    MAR("March", 3, 31),

    /**
     * 4. Monat
     * April
     */
    APR("April", 4, 30),

    /**
     * 5. Monat
     * Mai
     */
    MAY("May", 5, 31),

    /**
     * 6. Monat
     * Juni
     */
    JUN("June", 6, 30),

    /**
     * 7. Monat
     * Juli
     */
    JUL("July", 7, 31),

    /**
     * 8. Monat 
     * August
     */
    AUG("August", 8, 31),

    /**
     * 9. Monat
     * September
     */
    SEP("September", 9, 30),

    /**
     * 10. Monat
     * Oktober
     */
    OCT("October", 10, 31),

    /**
     * 11. Monat
     * November
     */
    NOV("November", 11, 30),

    /**
     * 12. Monat
     * Dezember
     */
    DEC("December", 12, 31);

    /**
     * Name des Monats
     */
    private final String monthName;

    /**
     * Nummer des Monats
     */
    private final int monthNumber;

    /**
     * Anzahl der Tage eines Monats
     */
    private final int days;

    /**
     * Konstruktor
     */
    Months(String monthName, int monthNumber, int days){
        this.monthName = monthName;
        this.monthNumber = monthNumber;
        this.days = days;
    }

    /**
     * Name des Monats
     */
    public String monthName(){
        return monthName;
    }

    /**
     * Nummer des Monats
     */
    public int monthNumber(){
        return monthNumber;
    }

    /**
     * Anzahl der Tage eines Monats
     */
    public int days(){
        return days;
    }
}