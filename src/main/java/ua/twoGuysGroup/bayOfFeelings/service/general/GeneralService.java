package ua.twoGuysGroup.bayOfFeelings.service.general;

public interface GeneralService<T, I> {

    T getById(Long id);

    T save(T var);

    void deleteById(I id);

    void delete(T var);

}
