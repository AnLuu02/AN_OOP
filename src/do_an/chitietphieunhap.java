/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class chitietphieunhap extends danhsachhoadonnhap implements Serializable {

    public chitietphieunhap() {
        super();
    }

    public chitietphieunhap(hoadonnhap[] hdn, int soluong1, nhanvien[] nv, int soluong) {
        super(hdn, soluong1, nv, soluong);
    }

    public void xuatchitietphieunhap() throws IOException {
        do {
            super.doc_file("hoadonnhap.txt");
            super.HienThi();
            String mahoadonxuat;
            int dem = 0;
            System.out.println("");
            System.out.println("+-----------------------+");
            System.out.println("|          MENU         |");
            System.out.println("+-----------------------+");
            System.out.println("| 1. Chi tiết hóa đơn   |");
            System.out.println("| 0. Kết thúc           |");
            System.out.println("+-----------------------+");
            System.out.println("Nhập lựa chọn: ");
            chon = kt.KiemTraNhapChuoi();
            switch (chon) {
                case "0":
                    break;
                case "1":
                    System.out.println("");
                    System.out.println("- Nhập mã hóa đơn nhập hàng: ");
                    mahoadonxuat = kt.KiemTraNhapMaHoaDon();
                    System.out.println("");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-   Chi tiết  -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                    System.out.println("+-------------------------------------------------------------------------------+");
                    System.out.println("|\t\t\t\tDanh sách sản phẩm\t\t\t\t|");
                    System.out.println("+-------------------------------------------------------------------------------+");
                    System.out.printf("|%-15s|%-20s|%-10s|%-15s|%-15s|\n", "Mã SP", "Tên SP", "Giá", "Loại", "Số lượng");
                    System.out.println("+-------------------------------------------------------------------------------+");
                    for (int i = 0; i < super.hdn.length; i++) {
                        if (super.hdn[i].getMahoadon().equals(mahoadonxuat)) {
                            dem++;
                            for (int j = 0; j < super.hdn[i].spnhap.length; j++) {
                                super.hdn[i].spnhap[j].HienThi();
                            }
                            System.out.println("+-------------------------------------------------------------------------------+");
                            System.out.println("- Mã hóa đơn: " + super.hdn[i].getMahoadon());
                            System.out.println("- Ngày nhập: " + super.hdn[i].getNgaynhap());
                            System.out.println("- Thành tiền: " + super.hdn[i].tongtien);
                        }
                    }
                    if (dem == 0) {
                        System.out.println("- Hóa đơn không tồn tại.");
                    } else {
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!!!");
            }

        } while (!chon.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        chitietphieunhap hd = new chitietphieunhap();
        hd.xuatchitietphieunhap();
    }
}
