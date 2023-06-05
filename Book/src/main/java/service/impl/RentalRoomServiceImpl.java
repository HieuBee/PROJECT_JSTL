package service.impl;

import bean.RentalRoom;
import repo.impl.RentalRoomRepoImpl;
import service.IRentalRoomService;

import java.util.List;

public class RentalRoomServiceImpl implements IRentalRoomService {
    private RentalRoomRepoImpl repo = new RentalRoomRepoImpl();

    @Override
    public boolean create(RentalRoom rentalRoom) {
        return repo.create(rentalRoom);
    }

    @Override
    public List<RentalRoom> search(String search) {
        return repo.search(search);
    }

    @Override
    public List<RentalRoom> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }
}
