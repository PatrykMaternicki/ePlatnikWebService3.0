package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.Permision;

public interface iPermision {
	public boolean hadPermisionToEmployeeUI();
	public boolean hadPermisionToAdministratorUI();
	public boolean hadPermisionToSuperAdministratorUI();
	public boolean hadPermisionToDeveloperUI();
	public boolean hadPermisionToMenagerUI();
	public boolean hadPermisionToTrainnerUI();
	public boolean hadPermisionToPresenterUI();
}