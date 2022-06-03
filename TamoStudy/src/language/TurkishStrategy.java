package language;

public class TurkishStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Enes "Eno" Yılmaz
	 */
	
	public TurkishStrategy() {
		String engText[] = {
			"MENÜ",
			"Hoş Geldin, ",
			"Başlık Kartı",
			"Odaklanma",
			"Mağaza",
			"Temalar",
			"Envanter",
			"İstatistikler",
			"Başarımlar",
			"Ayarlar",
			"Hakkında",
			"Başarım Açıldı"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Asla Pes Etme!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"Seviye",
			"# Oturum",
			"Oturum Süresi",
			"Mola Süresi",
			"Odaklanmaya Başla",
			"Odaklanmayı Durdur",
			"Oturum Tamamlandı",
			"Oturumdaki odaklanma bozuldu",
			"Süresince odaklandın",
			"Dakika ve",
			"Saniye",
			"Hadi Odaklanalım!",
			"Ara"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"Yiyecek Mağazası",
			"Arka Planlar",
			"Selam! Ben Kath.",
			"Mağazaya Hoş Geldin!",
			"Öde",
			"Yetersiz bakiye!",
			"Tamo şu an tok!",
			"Emin misin?",
			"için",
			"TamoTokens?",
			"ve",
			"Herhangi",
			"yardım edebileceğim bir şey?",
			"EVET",
			"HAYIR",
			"Bu eşyaya zaten sahipsin!"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"Karanlık Mod",
			"Beyaz Mod",
			"Klasik Kırmızı",
			"Klasik Mavi",
			"Klasik Yeşil",
			"Klasik Sarı",
			"Klasik Turuncu",
			"Klasik Pembe",
			"Temalar",
			"Seç",
			"Klasik temalar",
			"Tema Şuna Dönüştürüldü ",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"Envanter Boş",
			"Seç",
			"Arka Plan değişti!",
			"Envanter"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"İstatistikler",
			"Kullanıcı Adı",
			"Katılma Günü",
			"Odaklanılan Toplam Süre",
			"Başarım Açıldı",
			"Tamo Seviyesi"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"Başlangıç!",
			"Hiçbir şey seni durduramaz!",
			"Asla Pes Etme!",
			"Odak Artışı",
			"Customizer 1",
			"Customizer 2",
			"Başlangıçtan İtibaren",
			"Tamo Tok",
			"Tamo Aşkı",
			"Başarım 10",
			"Başarım 11",
			"Başarım 12"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"Toplamda 3 saat odaklanma<br>süresine ulaş",
			"Toplamda 1 gün odaklanma<br>süresine ulaş",
			"Toplamda 7 gün odaklanma<br>süresine ulaş",
			"Toplamda 30 gün odaklanma<br>süresine ulaş",
			"TamoStudy'nin temasını değiştir!",
			"Tamo'nun arka planını<br>değiştir",
			"Önceki bir TamoStudy<br>versiyonundan yükseltildi",
			"Maksimum Tamo açlığına ulaşın",
			"Maksimum Tamo mutluluğuna ulaşın",
			"Bu başarım hakkında fazla bir şey bilmiyoruz",
			"Bu başarı hakkında fazla bir şey bilmiyoruz",
			"Bu başarı hakkında fazla bir şey bilmiyoruz"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"Odaklanma Modunu Değiştir",
			"Dili Değiştir",
			"Zorlul Seviyesini Değiştir",
			"Alarm Sesi",
			"Özel Geri Sayım",
			"5-Aralıklı Geri Sayım",
			"Pomodoro Modu",
			"Stopwatch Modu",
			"İngilizce",
			"İspanyolca",
			"Portekizce",
			"Almanca",
			"Fransızca",
			"Felemenkçe",
			"Türkçe",
			"İrlandaca",
			"Hintçe",
			"Japonca",
			"Çince",
			"Barışçıl",
			"Zorlayıcı",
			"KAPALI",
			"AÇIK",
			"Yumuşak Alarm",
			"Trad Alarm",
			"Pac Alarm",
			"Değişiklikleri Kaydet",
			"Değişiklikler Kaydedildi!",
			"Kaydedilmemiş Değişikler Var.",
			"Başarım Bildirimleri",
			"Ses Yok"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"TamoStudy, sanal bir evcil hayvan kurarak",
			"Odaklanmaya devam etmenize yardımcı olan bir üretkenlik",
			"Çalışma ve",
			"Odaklanma zamanlayıcısıdır!",
			"Tarafından geliştirildi: ",
			"Anthony Narlock"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"Tamo Öldü",
			"Tamo'nuz ihtiyaç duyduğu bakımı almadı ve öldü",
			"Önceki Tamo'nuz için istatistikleriniz sıfırlanacak",
			"Yeni Tamo için isim giriniz: "
		};
		this.deathText = engDeathText;	
	}
	
	@Override
	public void printCurrentLanguage() {
		System.out.println("Turkish");
	}
}
