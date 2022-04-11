package ru.jolly.ray.domen;

public class MajesticWindow implements Subjectable {
    
    private Human breaker;
    private int number;

    public MajesticWindow(int number){
        this.number = number;
    }

    protected void smash(Human breaker) {
        this.breaker = breaker;
    }
    
    @Override
    public String showStatus() {
        StringBuilder sb = new StringBuilder();
        if (breaker == null){
            return toString();
        }
        return sb.append("Как ты, ").append(breaker).append(", жалкий человечешка посмел разрушить меня, великое окно номер ")
            .append(number).append(". Я достояние культуры, а ты мешок с костями. Мои ♂братья♂ отомстят!").toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("Я величественное охно номер ").append(number).append(", завидуй мне жалкий человечшка. Тебе никогда не достичь моего величия.").toString();
    }
}
