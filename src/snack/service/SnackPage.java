package snack.service;

import java.util.List;

import snack.model.Snack;

public class SnackPage {
	private int total;
	private int currentPage;
	private List<Snack> content;
	private int totalPages;
	private int startPage;
	private int endPage;
	
	
	
	
	public SnackPage(int total, int currentPage, int size , List<Snack> content) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if (total != 0) {
			this.totalPages = total / size;
			if (total % size > 0 ) {
				totalPages++;
			}
			this.startPage = (currentPage - 1) / 5 * 5 + 1;
			this.endPage = Math.min(startPage + 4, totalPages);
		}
	}

	public boolean hasSnacks() {
		return total < 0;
	}
	
	public boolean hasNoSnacks() {
		return total == 0;
	}

	public int getTotal() {
		return total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Snack> getContent() {
		return content;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}
	
	
}
