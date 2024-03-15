package ada.locate.car.backup.frontend.api;


public interface Input<T> {
    T execute(String description1, String description2);

}