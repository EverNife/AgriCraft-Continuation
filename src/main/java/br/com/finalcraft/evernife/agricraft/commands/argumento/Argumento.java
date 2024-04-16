package br.com.finalcraft.evernife.agricraft.commands.argumento;

import java.util.UUID;

public class Argumento {

    public final static Argumento EMPTY_ARG = new Argumento("");

    private final String argumento;

    public Argumento(String argumento) {
        this.argumento = argumento;
    }

    public int length(){return this.argumento.length();}

    public boolean isEmpty(){
        return this.argumento.isEmpty();
    }

    public boolean equals(String anotherString){
        return this.argumento.equals(anotherString);
    }

    public boolean equalsIgnoreCase(String anotherString){
        return argumento.equalsIgnoreCase(anotherString);
    }

    public boolean equalsIgnoreCase(String... possibilities){
        for (String possibility : possibilities){
            if (possibility.equalsIgnoreCase(argumento)){
                return true;
            }
        }
        return false;
    }

    public String toLowerCase(){
        return this.argumento.toLowerCase();
    }

    public String toUpperCase(){
        return this.argumento.toUpperCase();
    }

    public Integer getInteger(){
        if (argumento.isEmpty()) return null;
        try {
            return Integer.parseInt(argumento);
        }catch (Exception ignored){
            return null;
        }
    }

    public Float getFloat(){
        if (argumento.isEmpty()) return null;
        try {
            return Float.parseFloat(argumento);
        }catch (Exception ignored){
            return null;
        }
    }

    public Long getLong(){
        if (argumento.isEmpty()) return null;
        try {
            return Long.parseLong(argumento);
        }catch (Exception ignored){
            return null;
        }
    }

    public Double getDouble(){
        if (argumento.isEmpty()) return null;
        try {
            return Double.parseDouble(argumento);
        }catch (Exception ignored){
            return null;
        }
    }

    public Boolean getBoolean(){
        if (argumento.isEmpty()) return null;
        switch (argumento.toLowerCase()){
            case "on":
            case "true":
            case "verdadeiro":
            case "yes":
            case "sim":
            case "y":
            case "s":
                return true;
            case "off":
            case "false":
            case "falso":
            case "não":
            case "nao":
            case "n":
                return false;
        }
        return null;
    }

    public UUID getUUID(){
        if (argumento.isEmpty() || argumento.length() != 36) return null;
        try {
            return UUID.fromString(argumento);
        }catch (Exception ignored){
            return null;
        }
    }

    public String replaceAll(String regex, String replacement){
        return this.argumento.replaceAll(regex, replacement);
    }

    public String replace(CharSequence target, CharSequence replacement){
        return this.argumento.replace(target, replacement);
    }

    @Override
    public String toString() {
        return argumento;
    }
}

