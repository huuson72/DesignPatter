package com.nvtrung.baikiemtraso1.model;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
public class CauHinh {
	public static String LOAI_TEXT_FILE = "TEXT_FILE";
	public static String LOAI_SQL = "MS_SQLSERVER";
	
	private String loaiNguon;
	private String chuoiKetNoi;
}
