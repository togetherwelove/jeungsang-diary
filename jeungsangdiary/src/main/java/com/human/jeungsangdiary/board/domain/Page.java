package com.human.jeungsangdiary.board.domain;

public class Page {
	
	private static final int PAGE_NO = 1;
	private static final int ROWS_PER_PAGE = 10;
	private static final int PAGE_COUNT = 10;

	private int pageNo;			// 현재 번호 (초기값 설정)
	private int rowsPerPage; 	// 페이지당 데이터 행 갯수 (초기값 설정)
	private int pageCount;		// 화면에 보여줄 페이지 갯수 (초기값 설정)	 
	
	private int totalCount;		// 전체 데이터 갯수
	
	// 페이지 갯수 계산가능
	private int startPage;		// 시작 번호
	private int endPage;		// 끝 번호
	
	// 추가적 사항
	private int firstPage;		// 첫페이지 번호
	private int lastPage;		// 마지막 번호 
	private int prev;			// 이전 페이지 번호
	private int next;			// 다음 페이지 번호
	
	// 디비에서 가져올 행번호(오라클 11버전 이전용)
	private int startRowNo;
	private int endRowNo;
	
	// 생성자 (목적 : 변수 초기화)
	public Page(int pageNo, int rowsPerPage, int pageCount) {
		super();
		this.pageNo = pageNo;
		this.rowsPerPage = rowsPerPage;
		this.pageCount = pageCount;
	}
	
	// 생성자2 (상수값을 초기화)
	public Page() {
		this(PAGE_NO, ROWS_PER_PAGE, PAGE_COUNT);
	 // this.pageNo = PAGE_NO;
	}

	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrev() {
		return prev;
	}

	public void setPrev(int prev) {
		this.prev = prev;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getStartRowNo() {
		return startRowNo;
	}

	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}

	public int getEndRowNo() {
		return endRowNo;
	}

	public void setEndRowNo(int endRowNo) {
		this.endRowNo = endRowNo;
	}
	
	// 페이징 처리 수식 메소드
	public void paging() {
		
		// 이전 페이지
		this.prev = pageNo - 1;
		// 다음 페이지
		this.next = pageNo + 1;
		
		// 시작 페이지 pageCount = 10 고정
		
		// 마지막 페이지
		this.lastPage = ((totalCount - 1) / pageCount) + 1;
		
		// 1 ~ 9 시작페이지는 1
		this.startPage = ((pageNo - 1) / pageCount) + 1;
		
		// 끝나는 페이지
		this.endPage = (((pageNo - 1) / pageCount) + 1) * 10;
		
		// 페이지 갯수가 10보다 작으면?
		// 마지막 페이지를 확인해서 변경
		if (this.lastPage < 10) {
			this.endPage = ((totalCount - 1) / pageCount) + 1;
		}
	}
}

