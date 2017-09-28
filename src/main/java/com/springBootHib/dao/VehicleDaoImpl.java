package com.springBootHib.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.springBootHib.model.Person;
import com.springBootHib.model.Vehicle;

public class VehicleDaoImpl extends AbstractDao implements VehicleDao{

	@Override
	public int saveVehicle(Vehicle vehicle) {
		persist(vehicle);
		return vehicle.getVehicleId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehicle> findAllVehicles() {
		return (List<Vehicle>)getSession().createCriteria(Vehicle.class).list();
	}

	@Override
	public void deleteVehicleById(int id) {
		Vehicle vehicle = (Vehicle)getSession().load(Vehicle.class, id);
		getSession().delete(vehicle);
	}

	@Override
	public Vehicle findVehicleById(int id) {
		Criteria criteria = getSession().createCriteria(Vehicle.class);
		criteria.add(Restrictions.eq("id",id));
		return (Vehicle) criteria.uniqueResult();
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		getSession().update(vehicle);
	}

	@Override
	public List<Vehicle> findAllVehiclesByPersonId(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vehicle findVehicleByPersonId(int personId, int vehicleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
