package com.aldirneto.mygamerboxd.strategy;

import com.aldirneto.mygamerboxd.entity.Review;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Component
public class CalculoAritmetico implements CalculadoraScore {
    
    @Override
    public BigDecimal calcular(List<Review> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return BigDecimal.ZERO;
        }
        
        BigDecimal soma = BigDecimal.ZERO;
        for (Review r : reviews) {
            soma = soma.add(r.getNota());
        }
        
        return soma.divide(new BigDecimal(reviews.size()), 2, RoundingMode.HALF_UP);
    }
}