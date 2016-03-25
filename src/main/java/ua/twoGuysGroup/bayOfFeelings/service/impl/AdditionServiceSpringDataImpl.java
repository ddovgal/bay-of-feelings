package ua.twoGuysGroup.bayOfFeelings.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.twoGuysGroup.bayOfFeelings.entity.Addition;
import ua.twoGuysGroup.bayOfFeelings.repository.AdditionRepository;
import ua.twoGuysGroup.bayOfFeelings.service.AdditionService;

@Service
@Transactional
public class AdditionServiceSpringDataImpl implements AdditionService {

    @Autowired
    private AdditionRepository additionRepository;

    @Override
    public Addition getById(Long id) {
        return additionRepository.findOne(id);
    }

    @Override
    public Addition save(Addition addition) {
        return additionRepository.save(addition);
    }

    @Override
    public void deleteById(Long id) {
        additionRepository.delete(id);
    }

    @Override
    public void delete(Addition addition) {
        additionRepository.delete(addition);
    }
}
