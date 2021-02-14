package memberDTO;



public class MemberDTO {
	private String member_id;
	private String member_birthday;
	private String member_password;
	private String member_sex;
	private String member_address;
	private String member_homeNumber;
	private String member_telNumber;
	private int member_leaveChk;
	private String member_email;
	private String member_signDate;
	private String member_signDate1;
	private String member_signDate2;
	private int member_administratorChk;
	private String member_passwordQuestion;
	private String member_passwordAnswer;
	private String member_name;
	private int member_purchaseAmount;
	private int member_purchaseAmount1;
	private int member_purchaseAmount2;
	private String order_date;
	private String order_date1;
	private String order_date2;
	private String all;
	private String member_recentDate;
	private String member_recentDate1;
	private String member_recentDate2;
	
	private int currentPage; // �쁽�옱�럹�씠吏�
	private int totalCount; // 珥� �젅肄붾뱶�닔
	private int blockCount; // �븳 �럹�씠吏��뿉 蹂댁뿬以� �젅肄붾뱶�닔
	private int blockPage = 3; // �븳 釉붾줉�뿉 蹂댁뿬以� �럹�씠吏��닔
	private int totalPage; // 珥� �럹�씠吏��닔
	private int startRow; // �떆�옉 �젅肄붾뱶 踰덊샇
	private int endRow; // �걹 �젅肄붾뱶踰덊샇
	private int startPage; // �븳 釉붾줉�쓽 �떆�옉 �럹�씠吏� 踰덊샇
	private int endPage; // �븳 釉붾줉�쓽 �걹�럹�씠吏� 踰덊샇
	private int number;
	private String sort; // �젙�젹�쓣 �븯湲곗쐞�빐
	private String select;
	private String select_result;
	private int size;
	

	

	
	public MemberDTO(int totalCount){
		  //珥앺럹�씠吏��닔
				totalPage=totalCount/blockCount+(totalCount%blockCount==0?0:1);
	}

	public MemberDTO(int currentPage, int totalCount, int blockCount) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.blockCount = blockCount;
		//�떆�옉�젅肄붾뱶
		startRow=(currentPage-1)*blockCount+1;
		
		//�걹�젅肄붾뱶
		endRow=startRow+blockCount-1;		
		
		//珥앺럹�씠吏��닔
		totalPage=totalCount/blockCount+(totalCount%blockCount==0?0:1);
		
		//�떆�옉�럹�씠吏�
		startPage=(int)((currentPage-1)/blockPage)*blockPage+1;
		
		//�걹�럹�씠吏�
		endPage=startPage+blockPage-1;
		if(totalPage<endPage)
			endPage=totalPage;
		
		//由ъ뒪�듃�럹�씠吏��뿉 異쒕젰踰덊샇			
		 number=totalCount-(currentPage-1)*blockCount;
	}
	
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getBlockCount() {
		return blockCount;
	}

	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}

	public int getBlockPage() {
		return blockPage;
	}

	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
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
	

	
	
	





	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getOrder_date1() {
		return order_date1;
	}

	public void setOrder_date1(String order_date1) {
		this.order_date1 = order_date1;
	}

	public String getOrder_date2() {
		return order_date2;
	}

	public void setOrder_date2(String order_date2) {
		this.order_date2 = order_date2;
	}

	public String getMember_recentDate() {
		return member_recentDate;
	}

	public void setMember_recentDate(String member_recentDate) {
		this.member_recentDate = member_recentDate;
	}

	public String getMember_signDate() {
		return member_signDate;
	}

	public void setMember_signDate(String member_signDate) {
		this.member_signDate = member_signDate;
	}

	public int getMember_purchaseAmount() {
		return member_purchaseAmount;
	}

	public void setMember_purchaseAmount(int member_purchaseAmount) {
		this.member_purchaseAmount = member_purchaseAmount;
	}

	public int getMember_purchaseAmount1() {
		return member_purchaseAmount1;
	}

	public void setMember_purchaseAmount1(int member_purchaseAmount1) {
		this.member_purchaseAmount1 = member_purchaseAmount1;
	}

	public int getMember_purchaseAmount2() {
		return member_purchaseAmount2;
	}

	public void setMember_purchaseAmount2(int member_purchaseAmount2) {
		this.member_purchaseAmount2 = member_purchaseAmount2;
	}

	private String member_recentString;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_birthday() {
		return member_birthday;
	}

	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public String getMember_sex() {
		return member_sex;
	}

	public void setMember_sex(String member_sex) {
		this.member_sex = member_sex;
	}

	public String getMember_address() {
		return member_address;
	}

	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}

	public String getMember_homeNumber() {
		return member_homeNumber;
	}

	public void setMember_homeNumber(String member_homeNumber) {
		this.member_homeNumber = member_homeNumber;
	}

	public String getMember_telNumber() {
		return member_telNumber;
	}

	public void setMember_telNumber(String member_telNumber) {
		this.member_telNumber = member_telNumber;
	}

	public int getMember_leaveChk() {
		return member_leaveChk;
	}

	public void setMember_leaveChk(int member_leaveChk) {
		this.member_leaveChk = member_leaveChk;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}



	public int getMember_administratorChk() {
		return member_administratorChk;
	}

	public void setMember_administratorChk(int member_administratorChk) {
		this.member_administratorChk = member_administratorChk;
	}

	public String getMember_passwordQuestion() {
		return member_passwordQuestion;
	}

	public void setMember_passwordQuestion(String member_passwordQuestion) {
		this.member_passwordQuestion = member_passwordQuestion;
	}

	public String getMember_passwordAnswer() {
		return member_passwordAnswer;
	}

	public void setMember_passwordAnswer(String member_passwordAnswer) {
		this.member_passwordAnswer = member_passwordAnswer;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}



	public String getMember_recentString() {
		return member_recentString;
	}

	public void setMember_recentString(String member_recentString) {
		this.member_recentString = member_recentString;
	}

	public String getMember_signDate1() {
		return member_signDate1;
	}

	public void setMember_signDate1(String member_signDate1) {
		this.member_signDate1 = member_signDate1;
	}

	public String getMember_signDate2() {
		return member_signDate2;
	}

	public void setMember_signDate2(String member_signDate2) {
		this.member_signDate2 = member_signDate2;
	}



	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getSelect_result() {
		return select_result;
	}

	public void setSelect_result(String select_result) {
		this.select_result = select_result;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getMember_recentDate1() {
		return member_recentDate1;
	}

	public void setMember_recentDate1(String member_recentDate1) {
		this.member_recentDate1 = member_recentDate1;
	}

	public String getMember_recentDate2() {
		return member_recentDate2;
	}

	public void setMember_recentDate2(String member_recentDate2) {
		this.member_recentDate2 = member_recentDate2;
	}
	
	
	
	
	
	
	
	
	
}
