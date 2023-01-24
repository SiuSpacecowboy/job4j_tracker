package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {

    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(pr -> pr.getStandard() - pr.getActual()  >= 0 && pr.getStandard() - pr.getActual() <= 3)
                .map(pr -> "Label{"
                        + "name='" + pr.getName() + '\''
                        + ", price=" + pr.getPrice() / 2
                        + '}')
                .collect(Collectors.toList());
    }
}
