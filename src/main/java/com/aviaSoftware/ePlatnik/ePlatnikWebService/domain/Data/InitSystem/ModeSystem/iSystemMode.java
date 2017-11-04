package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem;

public interface iSystemMode {
	public boolean isDisableMenagerUI();
	public boolean isDisableUserUI();
	public boolean isDisableAdministratorUI();
	public boolean isDisableSuperAdministratorUI();
	public boolean isDisableTrainerUI();
	public boolean isDisableRestService();
	public boolean isDisableDevelopmentUI();
	public boolean isDisableConfigUI();
	public boolean isDisableCMSSystem();
	public boolean isDisableIgnoreAuthorization();
}
