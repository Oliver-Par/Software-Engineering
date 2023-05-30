public class UI implements HandleUserEvent{
    private String[] suchParameter;

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
}
