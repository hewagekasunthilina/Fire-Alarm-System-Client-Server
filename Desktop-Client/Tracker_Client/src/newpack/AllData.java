package newpack;

public class AllData {
	
	private int id;
	private int device_id;
	private String device_status;
	private int device_floor;
	private int device_room;
	private int device_smoke;
	private int device_co2;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDevice_id() {
		return device_id;
	}
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	
	public int getDevice_floor() {
		return device_floor;
	}
	public void setDevice_floor(int device_floor) {
		this.device_floor = device_floor;
	}
	public int getDevice_room() {
		return device_room;
	}
	public void setDevice_room(int device_room) {
		this.device_room = device_room;
	}
	public int getDevice_smoke() {
		return device_smoke;
	}
	public void setDevice_smoke(int device_smoke) {
		this.device_smoke = device_smoke;
	}
	public int getDevice_co2() {
		return device_co2;
	}
	public void setDevice_co2(int device_co2) {
		this.device_co2 = device_co2;
	}
	public String getDevice_status() {
		return device_status;
	}
	public void setDevice_status(String device_status) {
		this.device_status = device_status;
	}

}
