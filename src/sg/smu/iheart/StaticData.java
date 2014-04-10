package sg.smu.iheart;

import java.util.ArrayList;
import java.util.List;

import sg.smu.iheart.eform.EFormQuestion;
import sg.smu.iheart.faq.FAQQuestion;
import sg.smu.iheart.myrecord.MyRecord;
import sg.smu.iheart.social.SocialFriend;
import sg.smu.iheart.social.SocialNotification;

public class StaticData {
	public static List<SocialNotification> notifications = new ArrayList<SocialNotification>();
	public static List<EFormQuestion> eformQuestions = new ArrayList<EFormQuestion>();
	public static List<MyRecord> records = new ArrayList<MyRecord>();
	public static List<SocialFriend> friends=new ArrayList<SocialFriend>();
	public static List<FAQQuestion> faqQuestions = new ArrayList<FAQQuestion>();
	public static List<SocialFriend> broadcastFriends = new ArrayList<SocialFriend>();

	static{
		friends.add(new SocialFriend("taeyeon@naver.com", "Kim Taeyeon", "939958594", "Female",R.drawable.image_1,true));
		friends.add(new SocialFriend("jessica@naver.com", "Jessica Jung", "399405", "Female",R.drawable.image_7,true));
		friends.add(new SocialFriend("yoona@naver.com", "Yoona Im", "233233", "Female",R.drawable.image_4,true));
		friends.add(new SocialFriend("hwang@naver.com", "Tiffany Hwang", "454545", "Female",R.drawable.image_3,true));
		friends.add(new SocialFriend("seohyun@naver.com", "Seohyun", "433434", "Female",R.drawable.image_2,false));
		friends.add(new SocialFriend("lee@naver.com", "Lee Sonkyu", "1231232", "Female",R.drawable.image_5,false));
		friends.add(new SocialFriend("yuri@naver.com", "Yuri", "8484733", "Female",R.drawable.image_6,true));
		
		friends.add(new SocialFriend("amber@naver.com", "Amber", "939958594", "Female",R.drawable.image_7,false));
		friends.add(new SocialFriend("boyoung@naver.com", "Park Bo-young", "939958594", "Female",R.drawable.image_6,false));
		friends.add(new SocialFriend("luna@naver.com", "Luna", "939958594", "Female",R.drawable.image_8,false));
		friends.add(new SocialFriend("krystal@naver.com", "Krystal", "939958594", "Female",R.drawable.image_4,false));
		friends.add(new SocialFriend("victoria@naver.com", "Victoria", "939958594", "Female",R.drawable.image_2,false));
		friends.add(new SocialFriend("jihyun@naver.com", "Lee Ji Hyun", "939958594", "Female",R.drawable.image_1,false));


	}
	static{
		notifications.add(new SocialNotification("Sooyoung","HSA","12/05/2014","11:00","Hey! Let's go together",R.drawable.image_2,0));
		notifications.add(new SocialNotification(0, "Sunny", "sunny@naver.kr", "843339944", "Female", "Yo,be friend!", R.drawable.image_4, 1));
		notifications.add(new SocialNotification("Minah","HSA","20/05/2014","11:00","Hey! Let's go together",R.drawable.image_3,0));
		notifications.add(new SocialNotification("Jessica","HSA","19/05/2014","11:00","Hey! Let's go together",R.drawable.image_4,0));
		notifications.add(new SocialNotification(0, "Mackenzie Foy", "foy@uk.twilight.com", "8383444", "Female", "Glad to know you!", R.drawable.image_5, 1));
		notifications.add(new SocialNotification("Yoona","HSA","21/05/2014","11:00","Hey! Let's go together",R.drawable.image_1,0));
		notifications.add(new SocialNotification("Tiffany","HSA","10/05/2014","11:00","Hey! Let's go together",R.drawable.image_2,0));
		
		records.add(new MyRecord("HSA", "05/02/2014", "13:00 - 14:00"));
		records.add(new MyRecord("HSA", "07/07/2013", "10:00 - 11:00"));
		records.add(new MyRecord("HSA", "02/02/2012", "9:00 - 140:00"));
		
		eformQuestions.add(new EFormQuestion("1.Is your purpose for this donation visit to find out whether or not you are infected with HIV or suffering from AIDS?", false));
		eformQuestions.add(new EFormQuestion("2.There is a window period in the early stage of HIV infection where you may test negative for the virus and you may feel well. Do you know that during this window period you can transmit the virus to someone else?", false));
		eformQuestions.add(new EFormQuestion("3.Is there any reason for you to suspect that you have or could possibly have been infected with HIV or AIDS?", false));
		eformQuestions.add(new EFormQuestion("4.Have you ever offered to anyone sexual activity* services for cash or benefits of any kind?", false));
		eformQuestions.add(new EFormQuestion("5.Male Donors: have you ever engaged in sexual activity* with another male?", false));
		eformQuestions.add(new EFormQuestion("6.Female Donors: in the past twelve (12) months, have you engaged in sexual activity* with a male whom you know or suspect to have engaged in sexual activity* with another male?", false));
		eformQuestions.add(new EFormQuestion("7.In the past twelve (12) months, have you had: unexplained weight loss or persistent night sweats, fever, diarrhoea or swollen glands?", false));
		eformQuestions.add(new EFormQuestion("8.In the last twelve (12) months, have you engaged in sexual activity* with anyone you know or have reason to suspect is infected with HIV or AIDS?", false));
		eformQuestions.add(new EFormQuestion("9.Do you have any fever today or during the past 3 weeks?", false));
		eformQuestions.add(new EFormQuestion("10.In the past eight weeks, have you received smallpox vaccination or have you had close physical contact with (eg, touch) the vaccination site of anyone who received small pox vaccination?", false));
		
		faqQuestions.add(new FAQQuestion("1. Can I eat before I donate?",
				"It's very important that donors drink decaffeinated fluids and eat a good meal within four hours of donating."));
		faqQuestions.add(new FAQQuestion("2. I am on Anti-Hypercholesterolaemia Medication, Can I Still Donate Blood?",
				"You may, if you are on regular anti-cholesterol medication e.g. statins, but free from cardiovascular complications."));
		faqQuestions.add(new FAQQuestion("3. Is Donating Blood Safe?",
				"Blood donation is a safe procedure. It takes only about 45 minutes (whole blood donation). Donors give about 10-12% of their circulating blood volume during each blood donation. In general, blood donation, whether whole blood or apheresis (plasma/platelets), does not usually have significant adverse effects on a donor's health. Healthy adult donors who meet the required screening criteria should be able to donate safely and regularly."));
		faqQuestions.add(new FAQQuestion("4. How often can I donate blood?",
				"You can donate blood every 12 weeks, up to 4 times a year."));
		faqQuestions.add(new FAQQuestion("5. What is the Criteria for Donating Blood?",
				"It is very important to ensure that the act of donating blood does not jeopardize the donor's health in any way. Blood donors should be in good health and not suffer from any serious illness. Donated blood must also not harm the recipient. It must be safe for transfusion to those who need it. Safe blood is blood that does not contain viruses, bacteria, parasites, drugs or other injurious factors that may harm a blood recipient."));
		faqQuestions.add(new FAQQuestion("6. I have malaria, can I still donate blood ?",
				"If this is your 1st time donating blood in Singapore and previously diagnosed to have malaria, you will be deferred indefinitely. It is because the malaria parasites may still remain in your body at a very low level. Although it causes no harm to you but a patient may develop malaria infection after receiving your blood."));
		faqQuestions.add(new FAQQuestion("7. Can I donate blood if I am pregnant or breast feeding?",
				"You are advised not to donate blood during pregnancy or within six weeks after the delivery or abortion. If the delivery was by Caeserean Section, please wait for 6 months from the operation before donating blood. If you are still breastfeeding, you should not donate blood as this may reduce your iron stores and affect your baby’s iron intake from the breast milk."));

	}
	
	public static int profileDrawableResource = R.drawable.image_1;
	public static String username = "Taeyeon";
	public static String dateOfBirth = "20/08/1992";
	public static String nric = "S12345634";
	public static String email = "taeyeon@naver.com";
	public static String mobileNo = "52343210";
}
