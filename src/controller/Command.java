package controller;

public enum Command {

	COMMAND_ACCEPT("COMMAND_ACCEPT", "Aceptar");
	
	private String command;
	private String title;
	
	private Command(String command, String title) {
		this.command = command;
		this.title = title;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getTitle() {
		return title;
	}
}