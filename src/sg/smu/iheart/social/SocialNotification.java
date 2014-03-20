package sg.smu.iheart.social;

import android.graphics.drawable.Drawable;

public class SocialNotification {
	public Drawable profileDrawable;
	public String title;
	public String location;
	public String date;
	public String time;
	public String message;
	public int drawableResource;
	public int type;
	public SocialNotification(String title,String location, String date, String time,
			String message,int drawableResource,int type) {
		super();
		this.title = title;
		this.location = location;
		this.date = date;
		this.time = time;
		this.message = message;
		this.drawableResource = drawableResource;
		this.type = type;
	}
	
	
	public String name;
	public String email;
	public String mobile;
	public String gender;
	public SocialNotification(double dummy,String name,String email, String mobile, String gender, String message, int drawableResource, int type) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.message = message;
		this.drawableResource = drawableResource;
		this.type = type;
	}
}
