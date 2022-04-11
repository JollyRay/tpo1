package ru.jolly.ray.domen;

public class Plarform implements Subjectable{
    private Speaker speaker;
    private Human breaker;

    protected void smash(Human breaker) {
        this.breaker = breaker;
    }

    @Override
    public String showStatus() {
        StringBuilder sb = new StringBuilder();
        if (speaker != null){
            if (breaker != null){
                return sb.append("Помост занят спикером, но ").append(breaker).append(" разрушил его!").toString();
            } 
            return "Помост занят спикером";
        }
        if (breaker != null){
            return sb.append("Помосту грустно, что он один, так ещё и ").append(breaker).append(" разрушил его!").toString();
        }
        return "Помост грустно стоит в одиночестве и завидует эшафтоу, у которого всегда аншлак.";
    }

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
}
