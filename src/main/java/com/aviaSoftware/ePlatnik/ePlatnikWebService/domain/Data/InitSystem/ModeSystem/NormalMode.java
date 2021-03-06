package com.aviaSoftware.ePlatnik.ePlatnikWebService.domain.Data.InitSystem.ModeSystem;

public class NormalMode implements iSystemMode{
	private final boolean DISABLE_MENAGER_UI = false;
	private final boolean DISABLE_USER_UI = false;
	private final boolean DISABLE_ADMINISTRATOR_UI = false;
	private final boolean DISABLE_PRESENTER_UI = false;
	private final boolean DISABLE_SUPERADMINISTRATOR_UI = false;
	private final boolean DISABLE_TRAINER_UI = false;
	private final boolean DISABLE_RESTSERVICE= false;
	private final boolean DISABLE_DEVELOPMENT_UI= true;
	private final boolean DISABLE_CONFIG_UI = true;
	private final boolean DISABLE_CMS_SYSTEM = false;
	private final boolean DISABLE_IGNORE_AUTHORIZATION = false;
	@Override
	public boolean isDisableMenagerUI() {
		return DISABLE_MENAGER_UI;
	}
	@Override
	public boolean isDisableUserUI() {
		return DISABLE_USER_UI;
	}
	@Override
	public boolean isDisableAdministratorUI() {
		return DISABLE_ADMINISTRATOR_UI;
	}
	@Override
	public boolean isDisableTrainerUI() {
		return DISABLE_TRAINER_UI;
	}
	@Override
	public boolean isDisableRestService() {
		return DISABLE_RESTSERVICE;
	}
	@Override
	public boolean isDisableDevelopmentUI() {
		return  DISABLE_DEVELOPMENT_UI;
	}
	@Override
	public boolean isDisableConfigUI() {
		return  DISABLE_CONFIG_UI;
	}
	@Override
	public boolean isDisableCMSSystem() {
		return DISABLE_CMS_SYSTEM;
	}
	@Override
	public boolean isDisableIgnoreAuthorization() {
		return DISABLE_IGNORE_AUTHORIZATION;
	}
	@Override
	public boolean isDisableSuperAdministratorUI() {
		return DISABLE_SUPERADMINISTRATOR_UI;
	}
}
