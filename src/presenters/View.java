package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отобразить список столиков в представлении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Регистрация наблюдателя
     * @param observer
     */
    void setObserver(ViewObserver observer);

    /**
     * Распечатать результат бронирования столика
     * @param reservationNo
     */
    void printReservationTableResult(int reservationNo);

    /*
     * Резервация столика
     */
    void reservationTable(Date orderDate, int tableNo, String name);


    /*
     * Изменение бронирования
     */
    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);

    /*
     * Отмена бронирования
     */
    void cancelReservationTable(int reservationId);
}
