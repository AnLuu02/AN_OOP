/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class admin extends dangnhap {

    public admin() {
        super();
    }

    public admin(String taikhoan, String matkhau) {
        super(taikhoan, matkhau);
    }

    @Override
    public void nhap() {
        super.nhap();
        if ("admin".equals(taikhoan) && "admin".equals(matkhau)) {
            do {
                try {
                    System.out.println("");
                    System.out.println("+---------  Welcom to Admin!  -----------+");
                    System.out.println("+========================================+");
                    System.out.println("|               MENU ADMIN               |");
                    System.out.println("+========================================+");
                    System.out.println("| 1. Quản lí sản phẩm                    |");
                    System.out.println("| 2. Quản lí phiếu nhập                  |");
                    System.out.println("| 3. Chi tiết phiếu nhập                 |");
                    System.out.println("| 4. Quản lí phiếu xuất                  |");
                    System.out.println("| 5. Chi tiết phiếu xuất                 |");
                    System.out.println("| 6. Quản lí nhân viên                   |");
                    System.out.println("| 7. Quản lí khách hàng                  |");
                    System.out.println("| 8. Quản lí nhà cung cấp                |");
                    System.out.println("| 0. Exit                                |");
                    System.out.println("+========================================+");
                    System.out.println("- Bạn hãy nhập lựa chon: ");
                    chon = sc.nextLine();
                    switch (chon) {
                        case "1":
                            danhsachsanpham dssp = new danhsachsanpham();
                            dssp.menu();
                            break;
                        case "2":
                            danhsachhoadonnhap dspn = new danhsachhoadonnhap();
                            dspn.menu();
                            break;
                        case "3":
                            chitietphieunhap ctpn = new chitietphieunhap();
                            ctpn.xuatchitietphieunhap();
                            break;
                        case "4":
                            danhsachhoadonxuat dsx = new danhsachhoadonxuat();
                            dsx.menu();
                            break;
                        case "5":
                            chitietphieuxuat ctpx = new chitietphieuxuat();
                            ctpx.xuatchitietphieuxuat();
                            break;
                        case "6":
                            danhsachnhanvien dsnv = new danhsachnhanvien();
                            dsnv.menu();
                            break;
                        case "7":
                            danhsachkhachhang dskhang=new danhsachkhachhang();
                            dskhang.menu();
                            break;
                        case "8":
                            danhsachnhacungcap dsncc=new danhsachnhacungcap();
                            dsncc.menu();
                        case "0":
                            System.out.println("+-------- Hẹn gặp lại! --------+");
                            System.out.println("");
                            break;
                        default:
                            System.out.println("- Sai! Mời nhập lại (hãy nhập trong khoảng từ 0->8): ");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
                }

            } while (!chon.equals("0"));
        } else {
            System.out.println("- Sai thông tin đăng nhập!!!!!");
        }
    }
}
