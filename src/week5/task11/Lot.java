package week5.task11;

import java.time.LocalDateTime;

public class Lot {
    double currentPrice;
    String leader;
    LocalDateTime finishTime;

    Lot(double startPrice, LocalDateTime finishTime) {
        this.currentPrice = startPrice;
        this.finishTime = finishTime;
    }

    void updatePrice(double newPrice, String name) {

        if(LocalDateTime.now().isBefore(finishTime) && newPrice > currentPrice) {
            synchronized (this) {
                if (LocalDateTime.now().isBefore(finishTime) && newPrice > currentPrice) {
                    currentPrice = newPrice;
                    leader = name;
                }
            }
        }
    }

    String getLeader() {
        return leader;
    }
}
