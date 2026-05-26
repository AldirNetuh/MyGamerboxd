package com.aldirneto.mygamerboxd.strategy;

import com.aldirneto.mygamerboxd.entity.Admin;
import com.aldirneto.mygamerboxd.entity.Review;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class CalculoPonderado implements CalculadoraScore {

    @Override
    public BigDecimal calcular(List<Review> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal somaPonderada = BigDecimal.ZERO;
        BigDecimal somaPesos = BigDecimal.ZERO;

        for (Review r : reviews) {
            // O polimorfismo brilhando: se o usuário da review for uma instância de Admin, o peso é 2.
            BigDecimal peso = (r.getUsuario() instanceof Admin) ? new BigDecimal("2") : BigDecimal.ONE;
            
            somaPonderada = somaPonderada.add(r.getNota().multiply(peso));
            somaPesos = somaPesos.add(peso);
        }

        return somaPonderada.divide(somaPesos, 2, RoundingMode.HALF_UP);
    }
}