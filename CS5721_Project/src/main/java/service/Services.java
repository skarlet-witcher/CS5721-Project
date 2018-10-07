package service;

import java.util.List;

import controller.Controller;
import model.Module;

public class Services {
	private static Services services = null;
	private Services() {
		
	}
	public static Services getInstance() {
		if(services == null) {
			return new Services();
		}
		return services;
	}
	public List<Module> getAllModule(String procedureName) {
		String[] params = {};
		Object[] values = {};
		return Controller.getInstance().operation(procedureName, Module.class, params, values);
	}
	public int updateLecturerName(String procedureName, Class entityName, String moduleNo, String lecturerName) {
		String[] params = { "var_module_no", "var_lecturer_name"};
		Object[] values = { moduleNo, lecturerName};
		return Controller.getInstance().operation(procedureName, entityName, params, values).size();
	}
}
