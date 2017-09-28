package com.springBootHib.dao;

import java.util.List;

import com.springBootHib.model.Vehicle;

public interface VehicleDao {
	int saveVehicle(Vehicle vehicle);
	List<Vehicle> findAllVehicles();
	void deleteVehicleById(int id);
	Vehicle findVehicleById(int id);
	void updateVehicle(Vehicle vehicle);
	List<Vehicle> findAllVehiclesByPersonId(int personId);
	Vehicle findVehicleByPersonId(int personId, int vehicleId);
}
