package language;

public class JapaneseStrategy extends LanguageStrategy {
	
	/**
	 * @author Anthony Narlock (narlock)
	 * @translator Marie マリ
	 */
  
	public JapaneseStrategy() {
		String engText[] = {
			"メニュー",
			"ようこそ, ",
			"スクリーンタイトル",
			"集中",
			"ストア",
			"テーマ",
			"インベントリー",
			"統計",
			"実績",
			"設定",
			"情報",
			"実績を解除しました"
		};
		this.text = engText;
		
		String engTitleText[] = {
			"Never give up!!"
		};
		this.titleText = engTitleText;
	
		String engFocusText[] = {
			"レベル",
			"セッション数",
			"セッションの長さ",
			"ブレークの長さ",
			"集中を始める",
			"集中を停止する",
			"セッション完成",
			"集中セッションを中断しました",
			"集中しました",
			"分間",
			"秒間",
			"集中しましょう！",
			"ブレーク"
		};
		this.focusText = engFocusText;
		
		String engShopText[] = {
			"食料品店",
			"バックグラウンド",
			"こんにちは！キャスと申します。",
			"いらっしゃいませ！",
			"ご購入になりますか。",
			"申し訳ございませんが、お金は十分お持ちになりません",
			"タモが満腹していますよ！",
			"よろしいですか。",
			"で",
			"タモトークンズ",
			"と",
			"何かに関して",
			"助けさせていただけますか。",
			"はい",
			"いいえ",
			"このアイテムをもう持っていらっしゃいますよ！"
		};
		this.shopText = engShopText;
		
		String[] engThemeText = {
			"ダークモード",
			"ライトモード",
			"クラシック赤",
			"クラシック青",
			"クラシック緑",
			"クラシック黄色",
			"クラシックオレンジ",
			"クラシック紫",
			"テーマ",
			"選択",
			"クラシックテーマ",
			"[name of theme]に変更しました。",
		};
		this.themesText = engThemeText;
		
		String[] engInvText = {
			"インベントリーが空いた",
			"選択",
			"バックグラウンドを変更しました！",
			"インベントリー"
		};
		this.inventoryText = engInvText;
		
		String[] engStatsText = {
			"統計",
			"ユーザー",
			"入会年月日",
			"集中時間集計",
			"実績解除",
			"タモレベル"
		};
		this.statsText = engStatsText;
		
		String[] engAhmTitle = {
			"その始め！",
			"何も止められない！",
			"ネバー・ギブ・アップ！",
			"集中の登頂",
			"カストマイザー１",
			"カストマイザー２",
			"始めから",
			"タモフル",
			"タモラブ",
			"実績１０",
			"実績１１",
			"実績１２"
		};
		this.ahmTitle = engAhmTitle;
		
		String[] engAhmText = {
			"集中時間の集計を３時間に<br>達する",
			"集中時間の集計を1日間に<br>達する",
			"集中時間の集計を７日間に<br>達する",
			"集中時間の集計を３０日間に<br>達する",
			"TamoStudyのテーマを変更する",
			"タモのバックグラウンドを<br>変更する",
			"以前のバージョンを<br>更新する",
			"タモを満腹にする",
			"タモの幸せレベルを最高に達する",
			"この実績については不明である",
			"この実績については不明である",
			"この実績については不明である"
		};
		this.ahmText = engAhmText;
		
		String[] engSettingsText = {
			"集中モード",
			"言語",
			"難易度",
			"アラームサウンド",
			"カスタムの間隔カウントダウン",
			"5分間隔カウントダウン",
			"ポモドーロモード",
			"ストップウォッチモード",
			"英語",
			"スペイン語",
			"ポルトガル語",
			"ドイツ語",
			"フランス語",
			"オランダ語",
			"トルコ語",
			"アイルランド語",
			"ヒンディー語",
			"日本語",
			"中国語",
			"平和的",
			"挑戦的",
			"オフ",
			"オン",
			"ソフトアラーム",
			"クラシックアラーム",
			"パックアラーム",
			"セーブ",
			"変更をセーブしました！",
			"セーブされていない変更があります",
			"実績通知",
			"音なし"
		};
		this.settingsText = engSettingsText;
		
		String[] engAboutText = {
			"TamoStudy（タモスタディ）は",
			"バーチャルなペットを埋め込んで、",
			"プロダクティビティや労働に",
			"集中するようなタイマーである！",
			"開発者: ",
			"Anthony Narlock（アンソニー・ナーロック）"
		};
		this.aboutText = engAboutText;
		
		String[] engDeathText = {
			"タモの死",
			"あなたのタモは適当なケアを受けなく、死んでしまいました",
			"以前のタモの統計はリセットされます",
			"新タモの名前： "
		};
		this.deathText = engDeathText;	
	}
	
	@Override
	public void printCurrentLanguage() {
		System.out.println("Japanese");
	}
}
