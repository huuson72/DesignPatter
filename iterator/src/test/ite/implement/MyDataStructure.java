package test.ite.implement;

import java.util.ArrayList;
import java.util.List;

import test.ite.IterableSoNguyenCollection;
import test.ite.IteratorSoNguyen;
/* Lớp này triển khai IterableSoNguyenCollection và cung cấp các phương thức để thêm 
số nguyên vào danh sách và tạo ra các iterator cho danh sách.*/
public class MyDataStructure implements IterableSoNguyenCollection {
	private List<Integer> lst = new ArrayList<>();

	public void setList(List<Integer> lst) {
		this.lst = lst;
	}

	public void add(Integer x) {
		this.lst.add(x);
	}

	@Override
	public IteratorSoNguyen getIteratorSoNguyenChuan() {
		return new IteratorSoNguyenChuan(lst);
	}

	public IteratorSoNguyenDuong getIteratorSoNguyenDuong() {
		return new IteratorSoNguyenDuong(lst);
	}

	public List<Integer> getLst() {
		return lst;
	}
}
