package test.ite;
// Định nghĩa các phương thức cần thiết cho Iterator
public interface IteratorSoNguyen {
	// khởi động bộ lặp
	void start();
	
	// kiểm tra xem có ptử phía sau?
	boolean hasNext();
	
	// lấy giá trị ptử hiện tại & dịch ra sau
	int next();
}
