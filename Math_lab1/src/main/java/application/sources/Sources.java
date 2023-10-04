package application.sources;

public enum Sources {
    FILE("Файл"),
    CONSOLE("Консоль"),
    AUTO("Автозаполнение");
    private final String source;
    Sources(String source){
        this.source = source;
    }

    public String toString(){
        return this.ordinal()+1 + ") " + this.source;
    }
}
