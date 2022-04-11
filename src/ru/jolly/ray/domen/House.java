package ru.jolly.ray.domen;

public class House  implements Subjectable{
    private MajesticWindow[] windows;
    private Plarform plarform;

    public House(int quantityWindow, Plarform plarform){
        this.plarform = plarform;
        if (quantityWindow < 1){
            quantityWindow = 4;
        }
        windows = new MajesticWindow[quantityWindow];
        for (int iter = 0; iter < quantityWindow; iter++){
            windows[iter] = new MajesticWindow(iter);
        }
    }

    protected void smash(Human breaker) {
        int numberWindowBreak = (int)Math.floor(Math.random() * windows.length);
        windows[numberWindowBreak].smash(breaker);
    }

    @Override
    public String showStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("Я величественный двухэтажный дом, так в меня входят разные вещи. Давайте послушает, что они нам скажут.\n").append("------------------------------")
            .append("\nПомост: ").append(plarform.showStatus()).append('\n');
        for (MajesticWindow window : windows) {
            sb.append("\n").append(window.showStatus());
        }
        sb.append('\n').append("------------------------------");
        return sb.toString();
    }
}
