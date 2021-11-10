package week5.task11;

import java.time.LocalDateTime;

public class Lot {
    double currentPrice = 0.0;
    String leader = "Denis";
    LocalDateTime finishTime = LocalDateTime.of(2021,11,11,11,11,11);

    synchronized void updatePrice(double newPrice, String name) {
        if(LocalDateTime.now().isBefore(finishTime) && newPrice > currentPrice) {
            currentPrice = newPrice;
            leader = name;
        }
    }

    synchronized String getLeader() {
        return leader;
    }
}
