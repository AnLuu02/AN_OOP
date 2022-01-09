package do_an;

import java.io.Serializable;

public class nhanvienbanhang extends nhanvien implements Serializable,nhvien {

    public nhanvienbanhang() {
        super();
        chucvu = "Bán hàng";
    }

    public nhanvienbanhang(String manv, String calamviec, String chucvu, String hoten, String ngaysinh, String gioitinh, String diachi, String dienthoai, String email) {
        super(manv, calamviec, chucvu, hoten, ngaysinh, gioitinh, diachi, dienthoai, email);
    }

    @Override
    public void nhap() {
        System.out.println("- Thông tin nhân viên bán hàng: ");
        super.nhap();
    }

    @Override
    public void HienThi() {
        super.HienThi();
    }
}
