package sg.smu.iheart.navigation;


public class NavigationButton {
	public int iconResId;
	public String title;
	public Class targetActivityClass;
	public NavigationButton(String title,int iconResId,Class targetActivityClass){
		this.iconResId = iconResId;
		this.title = title;
		this.targetActivityClass = targetActivityClass;
	}
}
