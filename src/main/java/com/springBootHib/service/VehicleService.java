package com.springBootHib.service;

import java.util.List;

import com.springBootHib.model.Vehicle;

public interface VehicleService {
	int saveVehicle(Vehicle vehicle);
	List<Vehicle> findAllVehicles();
	void deleteVehicleById(int vehicleId);
	Vehicle findVehicleById(int vehicleId);
	void updateVehicle(Vehicle vehicle);
	List<Vehicle> findAllVehiclesByPersonId(int personId);
}
