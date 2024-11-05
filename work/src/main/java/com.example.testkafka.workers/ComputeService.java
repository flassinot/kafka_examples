package com.example.testkafka.workers;

import org.springframework.stereotype.Service;

@Service
public class ComputeService {

  public Double convertToFahrenheit(Double input) {
    // °F = (°C x 1,8) + 32
    return input * 1.8 + 32;
  }
}
