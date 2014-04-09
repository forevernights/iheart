package sg.smu.iheart.social;

public class SocialFriend {
	public String email;
	public String name;
	public String mobile;
	public String gender;
	public int drawableResource;
	public boolean isFriend=true;;
	public SocialFriend(String email, String name, String mobile, String gender,int drawableResource,boolean isFriend) {
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.gender = gender;
		this.drawableResource = drawableResource;
		this.isFriend = isFriend;
	}
	
}
