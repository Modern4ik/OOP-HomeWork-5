package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {

    private ViewObserver observer;

    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void printReservationTableResult(int reservationNo) {
        // if (reservationNo > 0)
        //     System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
        // else
        //     System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");

        switch (reservationNo){
            case -1:
                System.out.println("Не удалось забронировать столик. Попробуйте выполнить операцию позже.");
                break;
            case -2:
                System.out.println("Данный номер бронирования не найден! Проверьте правильность введённых данных!");
                break;
            case 1:
                System.out.println("Ваше бронирование успешно удалено!");
                break;
            default:
                System.out.printf("Столик успешно забронирован. Номер вашей брони: #%d\n", reservationNo);
                break;
        }
    }

    public void reservationTable(Date orderDate, int tableNo, String name){
        observer.onReservationTable(orderDate, tableNo, name);
    }

    /**
     * Пользователь нажал кнопку для изменения бронирования
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }


    /*
     * Пользователь нажал кнопку для удаления бронирования
     */
    public void cancelReservationTable(int reservationId){
        observer.onCancelReservationTable(reservationId);
    }
}
