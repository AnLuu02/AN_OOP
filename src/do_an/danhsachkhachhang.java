/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package do_an;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author PC
 */
public class danhsachkhachhang {

    protected khachhang[] khach;
    private int soluong;
    static kiemtra kt = new kiemtra();

    public danhsachkhachhang() {
    }

    public danhsachkhachhang(khachhang[] khach, int soluong) {
        this.khach = khach;
        this.soluong = soluong;
    }

    public khachhang[] getKhach() {
        return khach;
    }

    public void setKhach(khachhang[] khach) {
        this.khach = khach;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }


    public void doc_file(String link) throws IOException {
        FileInputStream in = null;
        ObjectInputStream InputStream = null;
        try {
            in = new FileInputStream(link);
            InputStream = new ObjectInputStream(in);
            khach = (khachhang[]) InputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {

        } finally {
            if (in != null) {
                in.close();
            }
            if (InputStream != null) {
                InputStream.close();
            }
        }
    }

    public void nhap() {
        System.out.println("- Nhập số lượng khách hàng: ");
        soluong = kt.KiemTraNhapSoNguyen();
        khach = new khachhang[soluong];
        for (int i = 0; i < soluong; i++) {
            khach[i] = new khachhang();
            khach[i].nhap();
        }
    }

    public void table() {
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|\t\t\t\t\t\t\t\tDanh sách khách hàng\t\t\t\t\t\t\t    |");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-10s||%-20s|%-12s|%-12s|%-20s|%-15s|%-27s|%-15s|\n","Mã KH", "Ho ten", "Ngay sinh", "Gioi tinh", "Dia chi", "Dien thoai", "Email","Ngày mua");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public void footer() {
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    public void tim_kiem() throws IOException {
        doc_file("khachhang.txt");
        String chon;
        if (khach.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+=============================+");
                System.out.println("|           Tìm kiếm          |");
                System.out.println("+=============================+");
                System.out.println("| 1. Theo mã khách hàng       |");
                System.out.println("| 2. Theo tên khách hàng      |");
                System.out.println("| 0. Exit                     |");
                System.out.println("+=============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = kt.KiemTraNhapChuoi();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        System.out.println("- Nhập mã khách hàng: ");
                        String makhachhang = kt.KiemTraNhapMaNhanVien();
                        table();
                        for (int i = 0; i < khach.length; i++) {
                            if (khach[i].getmakh().equals(makhachhang)) {
                                dem++;
                                khach[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có khách hàng cần tìm");
                        }
                        footer();
                        break;
                    case "2":
                        System.out.println("- Nhập tên khách hàng: ");
                        String tenkhachhang = kt.KiemTraNhapTenSanPham();
                        table();
                        for (int i = 0; i < khach.length; i++) {
                            if (khach[i].gethoten().equals(tenkhachhang)) {
                                dem++;
                                khach[i].HienThi();
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Không có khách hàng cần tìm");
                        }
                        footer();
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
    }

    public void xoa() throws IOException {
        String chon;
        doc_file("khachhang.txt");
        int i, j;
        if (khach.length < 1) {
            System.out.println("- Danh sách rỗng");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==============================+");
                System.out.println("|        Xóa khách hàng        |");
                System.out.println("+==============================+");
                System.out.println("| 1. Theo mã khách hàng        |");
                System.out.println("| 2. Theo tên khách hàng       |");
                System.out.println("| 0. Exit                      |");
                System.out.println("+==============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = kt.KiemTraNhapChuoi();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String makhachhang;
                        System.out.println("- Nhập mã khách hàng cần xóa: ");
                        makhachhang = kt.KiemTraNhapMaNhanVien();
                        khachhang[] temp = new khachhang[khach.length - 1];
                        for (i = j = 0; i < khach.length; i++) {
                            if (!khach[i].getmakh().equals(makhachhang)) {
                                temp[j++] = khach[i];
                                dem++;
                            }
                        }
                        if (dem == khach.length) {
                            System.out.println("- Không có khách hàng cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp, "khachhang.txt");
                        break;
                    case "2":
                        String tenkhachhang;
                        System.out.println("- Nhập tên khách hàng cần xóa: ");
                        tenkhachhang = kt.KiemTraNhapTenSanPham();
                        khachhang[] temp1 = new khachhang[khach.length - 1];
                        for (i = j = 0; i < khach.length; i++) {
                            if (!khach[i].gethoten().equals(tenkhachhang)) {
                                temp1[j++] = khach[i];
                                dem++;
                            }
                        }
                        if (dem == khach.length) {
                            System.out.println("- Không có khách hàng cần xóa");
                        } else {
                            System.out.println("- Xóa thành công.");
                        }
                        file.ghi_file(temp1, "khachhang.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                        break;
                }
            } while (!chon.equals("0"));
        }
    }

    public khachhang[] sua() throws IOException {
        String chon;
        doc_file("khachhang.txt");
        if (khach.length < 1) {
            System.out.println("- Danh sách rỗng!!!!");
        } else {
            do {
                int dem = 0;
                System.out.println("");
                System.out.println("+==============================+");
                System.out.println("|  Sửa thông tin khách hàng    |");
                System.out.println("+==============================+");
                System.out.println("| 1. Theo mã khách hàng        |");
                System.out.println("| 2. Theo tên khách hàng       |");
                System.out.println("| 0. Exit                      |");
                System.out.println("+==============================+");
                System.out.println("- Bạn hãy nhập lựa chọn: ");
                chon = kt.KiemTraNhapChuoi();
                switch (chon) {
                    case "0":
                        break;
                    case "1":
                        String makhachhang;
                        System.out.println("- Nhập mã khách hàng cần sửa: ");
                        makhachhang = kt.KiemTraNhapMaNhanVien();
                        for (int i = 0; i < khach.length; i++) {
                            if (khach[i].getmakh().equals(makhachhang)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+===============================+");
                                System.out.println("|       Thông tin cần sửa       |");
                                System.out.println("+===============================+");
                                System.out.println("| 1. Địa chỉ                    |");
                                System.out.println("| 2. Số điện thoại              |");
                                System.out.println("| 3. Email                      |");
                                System.out.println("| 0. Dung chinh sua             |");
                                System.out.println("+===============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = kt.KiemTraNhapChuoi();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        khach[i].setDiachi(khach[i].getdiachi());
                                        break;
                                    case "2":
                                        khach[i].setDienthoai(khach[i].getdienthoai());
                                        break;
                                    case "3":
                                        khach[i].setEmail(khach[i].getemail());
                                        break;
                                    default:
                                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                                        break;
                                }
                            }
                        }

                        if (dem == 0) {
                            System.out.println("- Tìm không thấy khách hàng!!!");
                        } else {
                            System.out.println("- Sửa thành công!");
                        }
                        file.ghi_file(khach, "khachhang.txt");
                        break;
                    case "2":
                        String tenkhachhang;
                        System.out.println("- Nhập tên nhà khách hàng cần sửa: ");
                        tenkhachhang = kt.KiemTraNhapTenSanPham();
                        for (int i = 0; i < khach.length; i++) {
                            if (khach[i].gethoten().equals(tenkhachhang)) {
                                dem++;
                                System.out.println("");
                                System.out.println("+===============================+");
                                System.out.println("|       Thông tin cần sửa       |");
                                System.out.println("+===============================+");
                                System.out.println("| 1. Địa chỉ                    |");
                                System.out.println("| 2. Số điện thoại              |");
                                System.out.println("| 3. Email                      |");
                                System.out.println("| 0. Dung chinh sua             |");
                                System.out.println("+===============================+");
                                System.out.println("- Bạn hãy nhập lựa chọn: ");
                                chon = kt.KiemTraNhapChuoi();
                                switch (chon) {
                                    case "0":
                                        break;
                                    case "1":
                                        khach[i].setDiachi(khach[i].getdiachi());
                                        break;
                                    case "2":
                                        khach[i].setDienthoai(khach[i].getdienthoai());
                                        break;
                                    case "3":
                                        khach[i].setEmail(khach[i].getemail());
                                        break;
                                    default:
                                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                                        break;
                                }
                            }
                        }
                        if (dem == 0) {
                            System.out.println("- Tìm không thấy khách hàng!!!");
                        } else {
                            System.out.println("- Sửa thành công!");
                        }
                       file. ghi_file(khach, "khachhang.txt");
                        break;
                    default:
                        System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                }
            } while (!chon.equals("0"));
        }
        return khach;
    }

    public void HienThi() throws IOException {
        doc_file("khachhang.txt");
        table();
        for (int i = 0; i < khach.length; i++) {
            khach[i].HienThi();
        }
        footer();
    }

    public void menu() throws IOException {
        String chonn;
        do {
            System.out.println("");
            System.out.println("+==================================+");
            System.out.println("|       Quản lí khách hàng         |");
            System.out.println("+==================================+");
            System.out.println("| 1. Xuất thông tin khách hàng     |");
            System.out.println("| 2. Xóa khách hàng                |");
            System.out.println("| 3. Sửa thông tin khách hàng      |");
            System.out.println("| 4. Tim kiếm khách hàng           |");
            System.out.println("| 0. Exit                          |");
            System.out.println("+==================================+");
            System.out.println("- Bạn hãy nhập lựa chọn: ");
            chonn = kt.KiemTraNhapChuoi();
            switch (chonn) {
                case "0":
                    break;
                case "1":
                    HienThi();
                    break;
                case "2":
                    xoa();
                    break;
                case "3":
                    khach = sua();
                    break;
                case "4":
                    tim_kiem();
                    break;
                default:
                    System.out.println("- Lựa chọn không hợp lệ! Mời nhập lại.");
                    break;
            }
        } while (!chonn.equals("0"));
    }

    public static void main(String[] args) throws IOException {
        danhsachkhachhang nhcc = new danhsachkhachhang();
        nhcc.menu();
    }
}
