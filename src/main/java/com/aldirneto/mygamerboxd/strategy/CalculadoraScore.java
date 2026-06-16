package com.aldirneto.mygamerboxd.strategy;
import com.aldirneto.mygamerboxd.entity.Review;
import java.math.BigDecimal;
import java.util.List;
public interface CalculadoraScore {
    BigDecimal calcular(List<Review> reviews);
}