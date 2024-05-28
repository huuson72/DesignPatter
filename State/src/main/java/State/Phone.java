package State;



public class Phone {
	private State state;

	public void onCalling() {
		this.state.onCalling();
	}
	
	public void onSMSReceived() {
		this.state.onSMSReceived();
	}
	
	public void onSystemNotification() {
		this.state.onSystemNotification();
	}
	
	public void setProfile(State state) {
		System.out.printf("Thiết lập trạng thái [%s] cho điện thoại\n", state.getClass().toString());
		this.state = state;
	}
}
