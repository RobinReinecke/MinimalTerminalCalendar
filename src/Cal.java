/**
 * Hausaufgabe 2. Cal Implementierung
 * 
 * @author Robin Reinecke, Matrikelnummer, Gruppennummer
 * @version 1.0
 */
public class Cal {
    /**
     * Startmethode
     * 
     * @param args Übergabeparameter
     */
    public static void main(String[] args) {
        switch (args.length){
            //keine Parameter übergeben
            case 0:
                //Kalendar für das aktuelle Jahr und Monat ausgeben
                System.out.println(new MinimalTerminalCalendar().toString());
                break;

            //ein Parameter übergeben
            case 1:
                try {
                    //Überprüfen, ob der Paramter ein valider Monat ist
                    Months passedMonth = Months.valueOf(args[0].toUpperCase());
                    //Kalendar für das aktuelle Jahr und übergebenen Monat ausgeben
                    System.out.println(new MinimalTerminalCalendar(passedMonth).toString());
                }
                catch(IllegalArgumentException exception){
                    System.out.println("No valid month passed.");
                }
                break;

            //zwei Parameter übergeben
            case 2:
                try {
                    //Überprüfen, ob der erste Paramter ein valider Monat ist
                    Months passedMonth = Months.valueOf(args[0].toUpperCase());

                    //Überprüfen, ob der zweite Parameter eine Zahl ist
                    int passedYear = Integer.parseInt(args[1]);
                    
                    //Überprüfen, ob die Zahl ein valides Jahr ist
                    if(passedYear < 0 || passedYear > 9999){
                        throw new NumberFormatException();
                    }

                    //Kalendar für das aktuelle Jahr und übergebenen Monat ausgeben
                    System.out.println(new MinimalTerminalCalendar(passedMonth, passedYear).toString());
                }
                catch(NumberFormatException exception){
                    System.out.println("No valid year passed.");
                }
                catch(IllegalArgumentException exception){
                    System.out.println("No valid month passed.");
                }
                break;

            //zu viele Parameter übergeben
            default:
                System.out.println("Too many parameters passed.");
                break;
        }
    }
}