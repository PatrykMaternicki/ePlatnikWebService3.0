package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.AccessSystem.User.Permision;

public class MenagerPermision implements iPermision {

	private final boolean PERMISION_TO_EMPLOYEE_UI =false;
	private final boolean PERMISION_TO_ADMINISTRATOR_UI = false;
	private final boolean PERMISION_TO_SUPERADMINISTRATOR_UI = false;
	private final boolean PERMISION_TO_DEVELOPER_UI= false;
	private final boolean PERMISION_TO_MENAGER_UI = true;
	private final boolean PERMISION_TO_TRAINNER_UI = false;
	private final boolean PERMISION_TO_PRESENTER_UI = false;
	
	@Override
	public boolean hadPermisionToEmployeeUI() {
		return PERMISION_TO_EMPLOYEE_UI;
	}
	@Override
	public boolean hadPermisionToAdministratorUI() {
		return PERMISION_TO_ADMINISTRATOR_UI;
	}
	@Override
	public boolean hadPermisionToSuperAdministratorUI() {
		return PERMISION_TO_SUPERADMINISTRATOR_UI;
	}
	@Override
	public boolean hadPermisionToDeveloperUI() {
		return PERMISION_TO_DEVELOPER_UI;
	}
	@Override
	public boolean hadPermisionToMenagerUI() {
		return  PERMISION_TO_MENAGER_UI;
	}
	@Override
	public boolean hadPermisionToTrainnerUI() {
		return PERMISION_TO_TRAINNER_UI;
	}
	@Override
	public boolean hadPermisionToPresenterUI() {
		return PERMISION_TO_PRESENTER_UI;
	}
}
