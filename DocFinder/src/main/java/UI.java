public class UI implements HandleUserEvent, Subscriber{
    private String[] suchParameter;

    private String[] ausgabe;

    public UI(String[] suchParameter){
        this.suchParameter = suchParameter;
    }

    public void menueErstellen(){}

    public String menueAuswahl(){
        return null;
    }

    public String[] suchparameterEingabe(){
        return suchParameter;
    }

    public void update(String[] ausgabe){}
}
