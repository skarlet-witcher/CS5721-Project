package controller;

import java.util.List;

import dao.DataAccess;
import model.Module;

public class Controller {
	
	private static Controller controller = null;
	private Controller() {
		
	}
	
	public static Controller getInstance() {
		if(controller == null) {
			return new Controller();
		}
		return controller;
	}
	
	
	public List<Module> getAllModule() {
		String sql = "Select e from " + Module.class.getName() + " e ";
		return (List<Module>)DataAccess.getInstance().OperationsByList(sql);
	}
	public List<Module> insertModule() {
		String sql = "Select e from " + Module.class.getName() + " e ";
		return (List<Module>)DataAccess.getInstance().OperationsByList(sql);
	}
	public void updateLecturerName(Module module) {
		String sql = "update " + Module.class.getName() +
				" e set e.lecturer_name = '" + module.getLecturer_name() + "'" + " where e.module_no= '"+ module.getModule_no() + "' ";
		DataAccess.getInstance().operationsForDeleteAndUpdate(sql, module);
	}
}
