import java.util.Calendar;

/**
 * Klasse für komplette Kalender-Verarbeitung
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class MinimalTerminalCalendar {

    /**
     * Kalenderjahr
     */
    private int year;

    /**
     * Monat
     */
    private Months month;

    /**
     * Schaltjahr
     */
    private boolean isLeapYear = false;

    /**
     * Konstruktor für aktuelles Jahr und Monat
     */
    public MinimalTerminalCalendar(){
        //Sorry, ich werde diese Daten nicht wie in der Aufgabe gefordert im Coding hinterlegen
        this.year = Calendar.getInstance().get(Calendar.YEAR);
        this.month = Months.values()[Calendar.getInstance().get(Calendar.MONTH)];
    }

    /**
     * Konstruktor für aktuelles Jahr und eigenen Monat
     * @param month Kalendermonat
     */
    public MinimalTerminalCalendar(Months month){
        this.year = Calendar.getInstance().get(Calendar.YEAR);
        this.month = month;
    }

    /**
     * Konstruktor für eigenes Jahr und Monat
     * @param month Kalendermonat
     * @param Year Jahr
     */
    public MinimalTerminalCalendar(Months month, int year){
        this.year = year;
        this.month = month;
    }

    /**
     * Gauß Algorithmus zur berechnung des ersten Wochentags des Jahrs
     * Siehe https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week#Gauss's_algorithm
     * @return 0 - 6, 0 = Sonntag
     */
    private int getFirstWeekdayOfYear(){
        return (1 + 
            5*((this.year - 1) % 4) +
            4*((this.year - 1) % 100) +
            6*((this.year - 1) % 400)
            ) % 7;    
    }

    /**
     * Berechnet den ersten Tag des jeweiligen Montags
     * @return 0 - 6, 0 = Sonntag
     */
    private int getFirstWeekdayOfMonth(){
        Months[] months = Months.values();
        int days = 0;
        //Summe der Tage bilden bis zum selektierten Monat
        for(var i=0; i < this.month.monthNumber() - 1; i++){
            /*
            Sonderfall ist der Februar. Falls es ein Schaltjahr ist, muss noch 
            ein Tag extra draufgerechnet werden.
            */
            if(i == 1 && isLeapYear){
                days += 1;
            }
            days += months[i].days();
        }

        //Anzahl der Tage mod 7 ergibt die übrigen Tage + Offset des ersten Tag des Jahres = Wochentag
        return (getFirstWeekdayOfYear() + (days % 7)) % 7;
    }

    /**
     * Generiert einen String, der auf der Konsole ausgegeben werden kann
     * @return Kalenderstring
     */
    public String toString(){
        //Stringbuilder für den String
        StringBuilder sb = new StringBuilder();

        //erste Line zentrieren
        String firstLine = this.month.monthName() + " " + this.year;
        /*
        Um die Leerzeilen zu berechnen, nehmen wir die insgesamte Breite des Kalenders
        von 20 (So Mo Di Mi Do Fr Sa), ziehen davon die länge der ersten Zeile ab und 
        teilen es durch zwei. Dann abrunden. 
        */
        int offset = (int)((20 - firstLine.length()) / 2);
        sb.append(String.format("%1$"+offset+"s", "") + firstLine + "\n");
        sb.append("So Mo Di Mi Do Fr Sa\n");

        //Berechnen, ob es ein Schaltjahr ist
        this.isLeapYear = ((this.year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));

        //0 - 6, wobei 0 = Sonntag
        int firstMonthDay = this.getFirstWeekdayOfMonth();

        /*
        Die Anzahl an blanks bevor der erste Tag kommt.
        3 pro Tag
        */
        offset = firstMonthDay * 3;
        sb.append(String.format("%1$"+offset+"s", ""));

        //Wenn es ein Schaltjahr ist und der Monat Februar ist, dann die Anzahl der Tage um 1 erhöhen
        int days = (this.isLeapYear && this.month.monthNumber() == 2) ? month.days() + 1 : month.days();

        int lineItemCount = firstMonthDay;
        for(int i = 1; i <= days; i++){
            //Einstellige Zahlen brauchen einen zusätzlichen Blank davor
            if(i <= 9){
                sb.append(" ");
            }
            sb.append(i);

            lineItemCount += 1;

            //Nach Samstag einen Zeilenumbruch anhängen
            if(lineItemCount > 6){
                sb.append("\n");
                lineItemCount = 0;
            }
            //Ansonsten ein Leerzeichen
            else{
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}