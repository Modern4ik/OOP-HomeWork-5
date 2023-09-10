package models;

import presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить список всех столиков
     * @return коллекция столиков
     */
    @Override
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }


    /**
     * Бронирование столика
     * @param reservationDate дата
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }

    /**
     *  Метод изменения бронирования
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        int isDeleted = cancelReservationTable(oldReservation);

        if (isDeleted == 1){
            return reservationTable(reservationDate, tableNo, name);
        }

        return isDeleted;
    }


    /*
     * Метод удаления бронирования
     */
    @Override
    public int cancelReservationTable(int reservationId){
        for (Table table : loadTables()){
            for (Reservation reservation : table.getReservations()){
                if (reservation.getId() == reservationId){
                    table.getReservations().remove(reservation);
                    
                    return 1;
                }
            }
        }
        return -2;
    }
}
