package info.service;

import java.util.List;

import info.model.Info;

public class InfoPage {
	private int total;
	private int currentPage;
	private List<Info> content;
	private int totalPage;
	private int startPage;
	private int endPage;
	
	
	
	
	
	public InfoPage(int total, int currentPage, List<Info> content, int size) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if(total != 0) {
			this.totalPage = total / size;
			if (total % size > 0) {
				this.totalPage++;
			}
			this.startPage = (currentPage -1) / 5 * 5 + 1;
			this.endPage = Math.min(startPage + 4, totalPage);
		}
		
		
	}

	
	public int getTotal() {
		return total;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public List<Info> getContent() {
		return content;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public boolean hasNoArticles() {
		return total == 0;
	}

	public boolean hasArticles() {
		return total > 0;
	}
	
}
