package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {

    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(pr -> pr.getStandard() - pr.getActual()  >= 0)
                .filter(pr -> pr.getStandard() - pr.getActual() <= 3)
                .map(pr -> new Label(pr.getName(), pr.getPrice() / 2).toString())
                .collect(Collectors.toList());
    }
}
