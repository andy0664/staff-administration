package at.fh.swenga.jpa.dto;

public class NewPassword {
	
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	
	public NewPassword() {
	}
		
	public NewPassword(String oldPassword, String newPassword,
			String repeatPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.repeatPassword = repeatPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	

}
