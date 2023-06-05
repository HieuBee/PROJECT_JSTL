package repo;

import bean.RentalRoom;

import java.util.List;

public interface IRentalRoomRepo {
    boolean create(RentalRoom rentalRoom);
    List<RentalRoom> search(String search);
    List<RentalRoom> findAll();
    boolean delete(int id);
}
