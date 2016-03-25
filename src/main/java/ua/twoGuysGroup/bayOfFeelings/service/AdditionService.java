package ua.twoGuysGroup.bayOfFeelings.service;

import ua.twoGuysGroup.bayOfFeelings.entity.Addition;

public interface AdditionService {
    Addition getById(Long id);

    Addition save(Addition addition);

    void deleteById(Long id);

    void delete(Addition addition);
}
