package ch09_class.students;

public class Movie {
	
	private String title;    /* 영화제목 */
	private String quotes;    /* 명대사 */
	private String actors;   /* 배우 */
	private String word;     /* 초성 */

	
	
	// 1. 기본 생성자
	public Movie() {
		
	}

	public Movie(String title, String quotes, String actors, String word) {
		super();
		this.title = title;
		this.quotes = quotes;
		this.actors = actors;
		this.word = word;
	}
	// 2. setter, getter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuote() {
		return quotes;
	}
	public void setQuote(String quote) {
		this.quotes = quote;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
}
