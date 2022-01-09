package do_an;

import java.io.Serializable;

public class khachhang extends connguoi implements Serializable {

    protected String makh;
    protected String ngaymua;
    public khachhang() {
        super();
        makh = "";
    }

    public khachhang(String hoten, String dienthoai, String makh) {
        super(hoten, makh, hoten, makh, dienthoai, makh);
        this.makh = makh;
    }

    public void setmakh(String makh) {
        System.out.println("- Nhập mã khách hàng: ");
        makh = kt.KiemTraNhapMaKhachHang();
        this.makh = makh;
    }

    public String getmakh() {
        return makh;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public void nhapkh() {
        super.nhap();
    }
    @Override
    public void HienThi(){
        System.out.printf("|%-10s||%-20s|%-12s|%-12s|%-20s|%-15s|%-27s|%-15s|\n",makh, hoten, ngaysinh, gioitinh, diachi, dienthoai, email,ngaymua);
    }

}
