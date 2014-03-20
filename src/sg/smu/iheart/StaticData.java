package sg.smu.iheart;

import java.util.ArrayList;
import java.util.List;

import sg.smu.iheart.eform.EFormQuestion;
import sg.smu.iheart.myrecord.MyRecord;
import sg.smu.iheart.social.SocialFriend;
import sg.smu.iheart.social.SocialNotification;

public class StaticData {
	public static String username = "Taeyeon";
	public static int profileDrawableResource = R.drawable.image_1;
	public static List<SocialNotification> notifications = new ArrayList<SocialNotification>();
	public static List<EFormQuestion> eformQuestions = new ArrayList<EFormQuestion>();
	public static List<MyRecord> records = new ArrayList<MyRecord>();
	public static List<SocialFriend> friends=new ArrayList<SocialFriend>();
	static{
		friends.add(new SocialFriend("taeyeon@naver.com", "Kim Taeyeon", "939958594", "Female",R.drawable.image_1));
		friends.add(new SocialFriend("jessica@naver.com", "Jessica Jung", "399405", "Female",R.drawable.image_2));
		friends.add(new SocialFriend("yoona@naver.com", "Yoona Im", "233233", "Female",R.drawable.image_4));
		friends.add(new SocialFriend("hwang@naver.com", "Tiffany Hwang", "454545", "Female",R.drawable.image_3));
		friends.add(new SocialFriend("seohyun@naver.com", "Seohyun", "433434", "Female",R.drawable.image_2));
		friends.add(new SocialFriend("lee@naver.com", "Lee Sonkyu", "1231232", "Female",R.drawable.image_1));
		friends.add(new SocialFriend("yuri@naver.com", "Yuri", "8484733", "Female",R.drawable.image_3));
	}
	static{
		notifications.add(new SocialNotification("Sooyoung has invited you to go for donation","HSA","21/12/2012","11:00 - 12:00","Hey! Let's go together",R.drawable.image_2,0));
		notifications.add(new SocialNotification(0, "Sunny", "sunny@naver.kr", "843339944", "Female", "Yo,be friend!", R.drawable.image_4, 1));
		notifications.add(new SocialNotification(0, "Mackenzie Foy", "foy@uk.twilight.com", "8383444", "Female", "Glad to know you!", R.drawable.image_5, 1));
		notifications.add(new SocialNotification("Minah has invited you to go for donation","HSA","21/12/2012","11:00 - 12:00","Hey! Let's go together",R.drawable.image_3,0));
		notifications.add(new SocialNotification("Jessica has invited you to go for donation","HSA","21/12/2012","11:00 - 12:00","Hey! Let's go together",R.drawable.image_4,0));
		notifications.add(new SocialNotification("Yoona has invited you to go for donation","HSA","21/12/2012","11:00 - 12:00","Hey! Let's go together",R.drawable.image_1,0));
		notifications.add(new SocialNotification("Tiffany has invited you to go for donation","HSA","21/12/2012","11:00 - 12:00","Hey! Let's go together",R.drawable.image_2,0));
		
		records.add(new MyRecord("HSA", "05/02/2014", "13:00 - 14:00"));
		records.add(new MyRecord("HSA", "07/07/2013", "10:00 - 11:00"));
		records.add(new MyRecord("HSA", "02/02/2012", "9:00 - 140:00"));
		
		eformQuestions.add(new EFormQuestion("1.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("2.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("3.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("4.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("5.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("6.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("7.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("8.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("9.Have you ever travelled to places such as Europe within the past few months?", false));
		eformQuestions.add(new EFormQuestion("10.Have you ever travelled to places such as Europe within the past few months?", false));


	}
}
