package language;

public class HindiStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Gautam Menon (Gmn0n)
     
	 /** */
	
	public HindiStrategy() {
		String hindiText[] = {
			"मेनू",
			"स्वागत हे, ",
			"शीर्षक कार्ड",
			"फोकस",
			"दुकान",
			"ऐप का लुक",
			"भंडार",
			"सांख्यिकी",
			"उपलब्धि",
			"सेटिंग",
			"टैमोस्टडी के बारे में"
		};
		this.text = hindiText;
		
		String hindiTitleText[] = {
			"कभी हार मत मानो!"
		};
		this.titleText = hindiTitleText;
	
		String hindiFocusText[] = {
			"लेवल",
			"# सेशन ",
			"सेशन की लंबाई",
			"अंतराल की लंबाई",
			"फोकस शुरू करें",
			"ब्रेक फोकस",
			"सेशन पूरा हो गया है!",
			"सेशन फोकस टूट गया है",
			"फोकस किया हुआ समय",
			"मिनट (ओं) और",
			"सेकंड (ओं) और",
			"आइए फोकस करते है",
			"ब्रेक का समय"
		};
		this.focusText = hindiFocusText;
		
		String hindiShopText[] = {
			"भोजन का दूकान",
			"बैकग्राउंड",
			"हैलो मैं कैथ हूँ।.",
			"दुकान में आपका स्वागत है!",
			"अभी खरीदें",
			"आपके पास पर्याप्त धन नहीं है!",
			"आपका तामो भरा हुआ है!",
			"क्या आप वाकई इस खरीदारी को जारी रखना चाहते हैं",
			"क्या आप",
			"तामो टोकन के लिए खरीदना चाहते हैं",
			"और",
			"क्या मैं आपकी कुछ मदद कर सकता हूँ?",
			"हां",
			"नहीं",
			"आपके पास पहले से ही यह आइटम है!"
		};
		this.shopText = hindiShopText;
		
		String[] hindiThemeText = {
			"डार्क मोड",
			"सफेद मोड",
			"क्लासिक लाल",
			"क्लासिक नीला",
			"क्लासिक हरा",
			"क्लासिक पीला",
			"क्लासिक नारंगी",
			"क्लासिक नारंगी",
			"ऐप का लुक",
			"सिलेक्ट",
			"क्लासिक लुकस",
			"अब ऐप का यह लुक होगा:",
		};
		this.themesText = hindiThemeText;
		
		String[] hindiInvText = {
			"इन्वेंट्री खाली है",
			"सिलेक्ट",
			"बैकग्राउंड बदल गई है!",
			"इन्वेंट्री"
		};
		this.inventoryText = hindiInvText;
		
		String[] hindiStatsText = {
			"सांख्यिकी",
			"यूजर नेम",
			"शामिल होने का दिन",
			"कुल फोकस किया हुआ घंटे",
			"उपलब्धि जो अनलॉक हो गई है",
			"तामो का लेवल"
		};
		this.statsText = hindiStatsText;
		
		String[] hindiAhmTitle = {
			"शुरुवात !",
			"हमें कुछ नहीं रोक सकता!",
			"कभी हार मत मानो!",
			"फोकस बढ़ रहा है",
			"कस्टमाइज़ ऑप्शन 1",
			"कस्टमाइज़ ऑप्शन 2",
			"प्रारंभ से",
			"तामो भरा हुआ है",
			"तामो प्यार",
			"उपलब्धि 10",
			"उपलब्धि 11",
			"उपलब्धि 12"
		};
		this.ahmTitle = hindiAhmTitle;
		
		String[] hindiAhmText = {
			"अनलॉक करने के लिए आपको 3 घंटे के कुल फोकस समय तक पहुंचना होगा",
			"अनलॉक करने के लिए आपको 1 दिन के कुल फोकस समय तक पहुंचना होगा",
			"अनलॉक करने के लिए आपको 7 दिन के कुल फोकस समय तक पहुंचना होगा",
			"अनलॉक करने के लिए आपको 30 दिन के कुल फोकस समय तक पहुंचना होगा",
			"अनलॉक करने के लिए आपको तामो स्टडी की थीम बदलनी चाहिए!",
			"अनलॉक करने के लिए आपको तामो स्टडी की बैकग्राउंड बदलनी होगी",
			"अनलॉक करने के लिए आपको तामो स्टडी के पिछले संस्करण से अपडेट होना चाहिए",
			"अनलॉक करने के लिए आपको अधिकतम तामो भूख हासिल करनी होगी",
			"अनलॉक करने के लिए आपको अधिकतम तामो खुशी प्राप्त करनी होगी",
			"हमें इस उपलब्धि के बारे में जानकारी नहीं है",
			"हमें इस उपलब्धि के बारे में जानकारी नहीं है",
			"हमें इस उपलब्धि के बारे में जानकारी नहीं है"
		};
		this.ahmText = hindiAhmText;
		
		String[] hindiSettingsText = {
			"फ़ोकस मोड बदलें",
			"भाषा बदलें",
			"कठिनाई को बदलें",
			"अलार्म साउंड सेटिंग्स",
			"कस्टम अंतराल उलटी गिनती",
			"5 अंतराल उलटी गिनती",
			"पोमोडोरो मोड",
			"स्टॉपवॉच मोड",
			"अंग्रेज़ी",
			"स्पैनिश",
			"पुर्तगाली",
			"जर्मन",
			"जापानी",
			"डच",
			"फ्रेंच",
			"तुर्की",
			"आयरिश",
			"हिन्दी",
			"चीनी",
			"शांतिदायक प्रकार",
			"चुनौतीपूर्ण मोड",
			"बंद",
			"चालू करो",
			"सॉफ्ट अलार्म",
			"क्लासिक अलार्म",
			"पॅक गेम अलार्म",
			"क्या ऐप परिवर्तनो को सेव करना चाहते हैं?",
			"परिवर्तन सेव हुए है!",
			"परिवर्तन सेव नहीं हुए है",
			"उपलब्धि सूचनाएं"
		};
		this.settingsText = hindiSettingsText;
		
	}

	@Override
	public void printCurrentLanguage() {
		// TODO Auto-generated method stub
		System.out.println("Hindi");
	}
}
